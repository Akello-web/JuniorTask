package junior.test.task.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Table(name = "t_transaction")
@Getter
@Setter
public class Transaction extends BaseModel{
  private int amount;
  private String currency;
  private LocalDateTime transactionDate;
  private boolean goods_limit;
  private boolean service_limit;

  @ManyToOne(fetch = FetchType.EAGER)
  private Category category;
}
