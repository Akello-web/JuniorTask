package junior.test.task.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Table(name = "t_transaction")
@Getter
@Setter
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private BigDecimal amount;
  private String currency;
  private LocalDateTime transactionDate;
}
