package junior.test.task.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ExchangeRateDto {
  private  Long id;
  private BigDecimal kztValue;
  private BigDecimal rubValue;
  private String timeLastUpdateUtc;
}
