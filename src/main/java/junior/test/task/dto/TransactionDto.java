package junior.test.task.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TransactionDto {
  private Long id;
  private int amount;
  private String currency;
  private LocalDate transactionDate;
  private boolean goods_limit_exceeded;
  private boolean service_limit_exceeded;
  private CategoryDto category;
}
