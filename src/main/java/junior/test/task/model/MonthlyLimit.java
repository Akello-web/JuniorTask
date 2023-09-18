package junior.test.task.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.YearMonth;

@Entity
@Table(name = "t_monthly_limit")
@Getter
@Setter
public class MonthlyLimit {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private BigDecimal goodsLimitUSD;

  @Column(nullable = false)
  private BigDecimal servicesLimitUSD;

  @Column(nullable = false)
  private YearMonth month;
}
