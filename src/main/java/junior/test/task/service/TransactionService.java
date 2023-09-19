package junior.test.task.service;

import junior.test.task.dto.TransactionDto;
import junior.test.task.mapper.TransactionMapper;
import junior.test.task.model.MonthlyLimit;
import junior.test.task.repository.MonthlyLimitRepository;
import junior.test.task.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TransactionService {
  private final TransactionRepository transactionRepository;
  private final TransactionMapper transactionMapper;
  private final MonthlyLimitRepository monthlyLimitRepository;

  public TransactionDto saveExpense(TransactionDto transactionDto) {
    transactionDto.setTransactionDate(LocalDate.now());

    MonthlyLimit limitToday = monthlyLimitRepository.findAllByMonth(YearMonth.now());
    if (transactionDto.getCategory().getId() == 1) {
      limitToday.setGoodsLimitUSD(limitToday.getGoodsLimitUSD() - transactionDto.getAmount());
    }else if (transactionDto.getCategory().getId() == 2) {
      limitToday.setServicesLimitUSD(limitToday.getServicesLimitUSD() - transactionDto.getAmount());
    }

    if (limitToday.getGoodsLimitUSD() <= 0) {
      transactionDto.setGoods_limit_exceeded(true);
    }
    if (limitToday.getServicesLimitUSD() <= 0) {
      transactionDto.setService_limit_exceeded(true);
    }

    transactionDto.setInit_goods_limit(MonthlyLimitService.forGoods);
    transactionDto.setInit_service_limit(MonthlyLimitService.forServices);

    return transactionMapper.toDto(transactionRepository.save(transactionMapper.fromDto(transactionDto)));
  }

  public List<TransactionDto> getGoodsExceededList(){
    return transactionMapper.toTransactionDtoList(transactionRepository.
            findAllByGoodsLimitExceededIsTrue());
  }

  public List<TransactionDto> getServicesExceededList(){
    return transactionMapper.toTransactionDtoList(transactionRepository.
            findAllByServiceLimitExceededIsTrue());
  }

}


