package junior.test.task.service;

import junior.test.task.model.MonthlyLimit;
import junior.test.task.repository.MonthlyLimitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MonthlyLimitService {
  private final MonthlyLimitRepository monthlyLimitRepository;

  public MonthlyLimit getOrCreateLimitForMonth(YearMonth month) {
    Optional<MonthlyLimit> existingLimit = monthlyLimitRepository.findByMonth(month);
    return existingLimit.orElseGet(() -> createNewLimitForMonth(month));
  }

  public MonthlyLimit setGoodsLimit(MonthlyLimit limit, int newLimit) {
    limit.setMonth(YearMonth.now());
    MonthlyLimit monthlyLimit = monthlyLimitRepository.findAllByMonth(limit.getMonth());
    if(monthlyLimit != null){
      monthlyLimit.setGoodsLimitUSD(newLimit);
      return monthlyLimitRepository.save(monthlyLimit);
    }else {
      limit.setGoodsLimitUSD(newLimit);
      return monthlyLimitRepository.save(limit);
    }
  }

  public MonthlyLimit setServicesLimit(MonthlyLimit limit, int newLimit) {
    limit.setMonth(YearMonth.now());
    MonthlyLimit monthlyLimit = monthlyLimitRepository.findAllByMonth(limit.getMonth());
    if(monthlyLimit != null){
      monthlyLimit.setServicesLimitUSD(newLimit);
      return monthlyLimitRepository.save(monthlyLimit);
    }else {
      limit.setServicesLimitUSD(newLimit);
      return monthlyLimitRepository.save(limit);
    }
  }

  public MonthlyLimit createNewLimitForMonth(YearMonth month) {
    MonthlyLimit newLimit = new MonthlyLimit();
    newLimit.setMonth(month);
    newLimit.setGoodsLimitUSD(1000);
    newLimit.setServicesLimitUSD(1000);
    return monthlyLimitRepository.save(newLimit);
  }
}
