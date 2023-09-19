package junior.test.task.service;

import junior.test.task.dto.TransactionDto;
import junior.test.task.mapper.TransactionMapper;
import junior.test.task.repository.MonthlyLimitRepository;
import junior.test.task.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.YearMonth;

@Service
@RequiredArgsConstructor
public class TransactionService {
  private final TransactionRepository transactionRepository;
  private final TransactionMapper transactionMapper;
  private final MonthlyLimitRepository monthlyLimitRepository;

  public TransactionDto saveExpense(TransactionDto transactionDto) {
    transactionDto.setTransactionDate(LocalDateTime.now());
    int limitToday;

    if (transactionDto.getCategory().getId() == 1) {
      limitToday = monthlyLimitRepository.findAllByMonth(YearMonth.now()).getGoodsLimitUSD();
      if (transactionDto.getAmount() > limitToday) {
        transactionDto.setGoods_limit(true);
      } else transactionDto.setGoods_limit(false);
    } else if (transactionDto.getCategory().getId() == 2) {
      limitToday = monthlyLimitRepository.findAllByMonth(YearMonth.now()).getServicesLimitUSD();
      if (transactionDto.getAmount() > limitToday) {
        transactionDto.setService_limit(true);
      } else transactionDto.setService_limit(false);
    }
      return transactionMapper.toDto(transactionRepository.save(transactionMapper.fromDto(transactionDto)));
  }
}
