package junior.test.task.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.YearMonth;

@Getter
@Setter
public class MonthlyLimitDto {
  private Long id;
  private int goodsLimitUSD;
  private int servicesLimitUSD;
  private YearMonth month;
}
