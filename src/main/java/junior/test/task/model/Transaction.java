package junior.test.task.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "t_transaction")
@Getter
@Setter
public class Transaction extends BaseModel{
  private int amount;
  private String currency;
  private LocalDate transactionDate;
  private boolean goods_limit_exceeded;
  private boolean service_limit_exceeded;

  private int init_goods_limit;
  private int init_service_limit;

  @ManyToOne(fetch = FetchType.EAGER)
  private Category category;
}
