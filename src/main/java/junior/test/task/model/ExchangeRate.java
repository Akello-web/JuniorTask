package junior.test.task.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Entity
@Table(name = "t_exchange_rates")
@Getter
@Setter
public class ExchangeRate {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private BigDecimal kztValue;
  private BigDecimal rubValue;
  private String timeLastUpdateUtc;
}
