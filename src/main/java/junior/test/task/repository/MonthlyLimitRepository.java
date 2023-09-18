package junior.test.task.repository;

import junior.test.task.model.MonthlyLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.YearMonth;
import java.util.Optional;

@Repository
public interface MonthlyLimitRepository extends JpaRepository<MonthlyLimit, Long> {
  Optional<MonthlyLimit> findByMonth(YearMonth month);
  MonthlyLimit findAllByMonth(YearMonth month);
}
