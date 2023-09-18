package junior.test.task.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_exchange_rates")
@Getter
@Setter
public class ExchangeRate {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private double kztValue;
  private double rubValue;
  private String timeLastUpdateUtc;
}
