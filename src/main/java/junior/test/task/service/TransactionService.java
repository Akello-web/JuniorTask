package junior.test.task.service;

import junior.test.task.dto.TransactionDto;
import junior.test.task.mapper.TransactionMapper;
import junior.test.task.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransactionService {
  private final TransactionRepository transactionRepository;
  private final TransactionMapper transactionMapper;

  public TransactionDto saveExpense(TransactionDto transactionDto) {
    transactionDto.setTransactionDate(LocalDateTime.now());
    System.out.println(LocalDateTime.now());
    // Сохраните операцию в базу данных
    return transactionMapper.toDto(transactionRepository.save(transactionMapper.fromDto(transactionDto)));
  }
}
