package junior.test.task.service;

import junior.test.task.model.MonthlyLimit;
import junior.test.task.repository.MonthlyLimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Optional;

@Service
public class MonthlyLimitService {
  private final MonthlyLimitRepository monthlyLimitRepository;

  @Autowired
  public MonthlyLimitService(MonthlyLimitRepository monthlyLimitRepository) {
    this.monthlyLimitRepository = monthlyLimitRepository;
  }

  public MonthlyLimit getOrCreateLimitForMonth(YearMonth month) {
    Optional<MonthlyLimit> existingLimit = monthlyLimitRepository.findByMonth(month);
    return existingLimit.orElseGet(() -> createNewLimitForMonth(month));
  }

  public void updateGoodsLimit(MonthlyLimit limit, BigDecimal newLimit) {
    limit.setGoodsLimitUSD(newLimit);
    monthlyLimitRepository.save(limit);
  }

  public void updateServicesLimit(MonthlyLimit limit, BigDecimal newLimit) {
    limit.setServicesLimitUSD(newLimit);
    monthlyLimitRepository.save(limit);
  }

  public MonthlyLimit createNewLimitForMonth(YearMonth month) {
    MonthlyLimit newLimit = new MonthlyLimit();
    newLimit.setMonth(month);
    newLimit.setGoodsLimitUSD(BigDecimal.valueOf(1000)); // Установите лимит по умолчанию, если не установлен
    newLimit.setServicesLimitUSD(BigDecimal.valueOf(1000)); // Установите лимит по умолчанию, если не установлен
    return monthlyLimitRepository.save(newLimit);
  }
}
