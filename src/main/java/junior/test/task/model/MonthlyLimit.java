package junior.test.task.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.YearMonth;

@Entity
@Table(name = "t_monthly_limit")
@Getter
@Setter
public class MonthlyLimit {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private int goodsLimitUSD;
  private int servicesLimitUSD;
  private YearMonth month;
}
