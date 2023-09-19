package junior.test.task.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionDto {
  private Long id;
  private int amount;
  private String currency;
  private LocalDateTime transactionDate;
  private boolean goods_limit;
  private boolean service_limit;
  private CategoryDto category;
}
