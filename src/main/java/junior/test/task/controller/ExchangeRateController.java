package junior.test.task.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import junior.test.task.dto.ExchangeRateDto;

import junior.test.task.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exchange-rate")
public class ExchangeRateController {
  private final ExchangeRateService exchangeRateService;

  @GetMapping
  public ExchangeRateDto getRate() throws JsonProcessingException {
  return exchangeRateService.getCurrentExchangeRate();
  }
}
