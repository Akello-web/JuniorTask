package junior.test.task;

import junior.test.task.dto.CategoryDto;
import junior.test.task.dto.TransactionDto;
import junior.test.task.mapper.TransactionMapper;
import junior.test.task.model.Category;
import junior.test.task.model.MonthlyLimit;
import junior.test.task.model.Transaction;
import junior.test.task.repository.MonthlyLimitRepository;
import junior.test.task.repository.TransactionRepository;
import junior.test.task.service.TransactionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.YearMonth;

@SpringBootTest
public class TransactionsTest {
  @InjectMocks
  private TransactionService transactionService;

  @Mock
  private MonthlyLimitRepository monthlyLimitRepository;

  @Mock
  private TransactionRepository transactionRepository;

  @Mock
  private TransactionMapper transactionMapper;

  private MonthlyLimit limitToday;
  private TransactionDto transactionDto;
  private Transaction transaction;

  @BeforeEach
  public void setUp() {
    limitToday = new MonthlyLimit();
    limitToday.setMonth(YearMonth.now());
    limitToday.setGoodsLimitUSD(1000);
    limitToday.setServicesLimitUSD(2000);

    transactionDto = new TransactionDto();
    transactionDto.setTransactionDate(LocalDate.now());
    transactionDto.setAmount(1100);
    transactionDto.setCategory(new CategoryDto());
    transactionDto.getCategory().setId(1L);

  }

  @Test
  public void testSaveExpense_GoodsCategory() {
    Mockito.when(monthlyLimitRepository.findAllByMonth(YearMonth.now()))
            .thenReturn(limitToday);

    transaction = transactionMapper.fromDto(transactionDto);

    Mockito.when(transactionRepository.save(Mockito.any(Transaction.class)))
            .thenReturn(transaction);

    transactionService.saveExpense(transactionDto);

    Mockito.verify(monthlyLimitRepository).findAllByMonth(YearMonth.now());
    Mockito.verify(transactionRepository).save(transaction);
    Assertions.assertTrue(transactionDto.isGoods_limit_exceeded());
    Assertions.assertFalse(transactionDto.isService_limit_exceeded());
  }
}
