package junior.test.task.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.YearMonth;

@Getter
@Setter
public class MonthlyLimitDto {
  private Long id;
  private BigDecimal goodsLimitUSD;
  private BigDecimal servicesLimitUSD;
  private YearMonth month;
}
