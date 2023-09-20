package junior.test.task;

import junior.test.task.model.MonthlyLimit;
import junior.test.task.repository.MonthlyLimitRepository;
import junior.test.task.service.MonthlyLimitService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.YearMonth;


@SpringBootTest
class TaskApplicationTests {
  @InjectMocks
  private MonthlyLimitService monthlyLimitService;

  @Mock
  private MonthlyLimitRepository monthlyLimitRepository;

  @Test
  public void testSetGoodsLimit_ExistingMonthlyLimit() {
    YearMonth currentMonth = YearMonth.now();
    int newLimit = 100;
    MonthlyLimit existingMonthlyLimit = new MonthlyLimit();
    existingMonthlyLimit.setMonth(currentMonth);

    Mockito.when(monthlyLimitRepository.findAllByMonth(currentMonth))
            .thenReturn(existingMonthlyLimit);

    monthlyLimitService.setGoodsLimit(existingMonthlyLimit, newLimit);

    Mockito.verify(monthlyLimitRepository).save(existingMonthlyLimit);
    Assertions.assertEquals(newLimit, existingMonthlyLimit.getGoodsLimitUSD());
  }

  @Test
  public void testSetGoodsLimit_NewMonthlyLimit() {
    YearMonth currentMonth = YearMonth.now();
    int newLimit = 200;
    MonthlyLimit newMonthlyLimit = new MonthlyLimit();
    newMonthlyLimit.setMonth(currentMonth);

    Mockito.when(monthlyLimitRepository.findAllByMonth(currentMonth))
            .thenReturn(null);
    Mockito.when(monthlyLimitRepository.save(Mockito.any(MonthlyLimit.class)))
            .thenReturn(newMonthlyLimit);

    MonthlyLimit result = monthlyLimitService.setGoodsLimit(newMonthlyLimit, newLimit);

    Mockito.verify(monthlyLimitRepository).save(newMonthlyLimit);
    Assertions.assertEquals(newLimit, result.getGoodsLimitUSD());
  }

  private MonthlyLimit existingMonthlyLimit;

  @BeforeEach
  public void setUp() {
    existingMonthlyLimit = new MonthlyLimit();
    existingMonthlyLimit.setMonth(YearMonth.now());
  }
  @Test
  public void testSetServicesLimit_ExistingMonthlyLimit() {
    int newLimit = 100;

    Mockito.when(monthlyLimitRepository.findAllByMonth(existingMonthlyLimit.getMonth()))
            .thenReturn(existingMonthlyLimit);

    monthlyLimitService.setServicesLimit(existingMonthlyLimit, newLimit);

    Mockito.verify(monthlyLimitRepository).save(existingMonthlyLimit);
    Assertions.assertEquals(newLimit, existingMonthlyLimit.getServicesLimitUSD());
  }

  @Test
  public void testSetServicesLimit_NewMonthlyLimit() {
    int newLimit = 200;

    Mockito.when(monthlyLimitRepository.findAllByMonth(existingMonthlyLimit.getMonth()))
            .thenReturn(null);
    Mockito.when(monthlyLimitRepository.save(Mockito.any(MonthlyLimit.class)))
            .thenReturn(existingMonthlyLimit);

    MonthlyLimit result = monthlyLimitService.setServicesLimit(existingMonthlyLimit, newLimit);

    Mockito.verify(monthlyLimitRepository).save(existingMonthlyLimit);
    Assertions.assertEquals(newLimit, result.getServicesLimitUSD());
  }
}
