package junior.test.task.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionDto {
  private Long id;
  private BigDecimal amount;
  private String currency;
  private LocalDateTime transactionDate;
}
