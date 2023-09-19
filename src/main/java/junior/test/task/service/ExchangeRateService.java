package junior.test.task.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import junior.test.task.dto.ExchangeRateDto;
import junior.test.task.jsonModel.ExchangeRates;
import junior.test.task.mapper.ExchangeMapper;
import junior.test.task.repository.ExchangeRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ExchangeRateService {
  private final ExchangeRateRepository exchangeRateRepository;
  private final ExchangeMapper exchangeMapper;

  public String getExchangeRateJson() throws JsonProcessingException {
    RestTemplate restTemplate = new RestTemplate();

    String apiUrl = "https://v6.exchangerate-api.com/v6/c9d48243dcc1bbe061817d0f/latest/USD";

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<String> entity = new HttpEntity<>(headers);

    ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);

    return response.getBody();
  }

  @Scheduled(cron = "0 */5 * * * ?")//updated every 5 min for now
  public void getCurrentExchangeRate() throws JsonProcessingException {
    ExchangeRateDto exchangeRateDto = new ExchangeRateDto();
    String jsonResponse = getExchangeRateJson();
    ObjectMapper objectMapper = new ObjectMapper();
    ExchangeRates exchangeRates = objectMapper.readValue(jsonResponse, ExchangeRates.class);
    exchangeRateDto.setKztValue(exchangeRates.getConversion_rates().get("KZT"));
    exchangeRateDto.setRubValue(exchangeRates.getConversion_rates().get("RUB"));
    exchangeRateDto.setTimeLastUpdateUtc(exchangeRates.getTime_last_update_utc());
    exchangeMapper.toDto(exchangeRateRepository.save(exchangeMapper.fromDto(exchangeRateDto)));
  }

}
