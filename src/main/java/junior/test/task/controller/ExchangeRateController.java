package junior.test.task.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import junior.test.task.jsonModel.ExchangeRates;

import junior.test.task.repository.ExchangeRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class ExchangeRateController {

  private final ExchangeRateRepository exchangeRateRepository;

  @GetMapping("/exchange-rate")
  public ResponseEntity<String> getExchangeRate() throws JsonProcessingException {
    RestTemplate restTemplate = new RestTemplate();

    String apiUrl = "https://v6.exchangerate-api.com/v6/c9d48243dcc1bbe061817d0f/latest/USD";

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<String> entity = new HttpEntity<>(headers);

    ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);

    String responseBody = response.getBody();

    ObjectMapper objectMapper = new ObjectMapper();
    ExchangeRates exchangeRates = objectMapper.readValue(responseBody, ExchangeRates.class);

    String jsonResponse = objectMapper.writeValueAsString(exchangeRates);


    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.setContentType(MediaType.APPLICATION_JSON);

    return ResponseEntity.ok().headers(responseHeaders).body(jsonResponse);
  }
}
