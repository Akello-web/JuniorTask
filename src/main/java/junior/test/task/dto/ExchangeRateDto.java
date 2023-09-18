package junior.test.task.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeRateDto {
  private  Long id;
  private double kztValue;
  private double rubValue;
  private String timeLastUpdateUtc;
}
