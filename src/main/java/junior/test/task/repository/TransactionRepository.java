package junior.test.task.repository;

import junior.test.task.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
  @Query("SELECT t FROM Transaction t WHERE t.goods_limit_exceeded = true")
  List<Transaction> findAllByGoodsLimitExceededIsTrue();

  @Query("SELECT t FROM Transaction t WHERE t.service_limit_exceeded = true")
  List<Transaction> findAllByServiceLimitExceededIsTrue();

}