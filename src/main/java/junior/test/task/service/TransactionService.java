package junior.test.task.service;

import junior.test.task.dto.TransactionDto;
import junior.test.task.mapper.TransactionMapper;
import junior.test.task.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {
  private final TransactionRepository transactionRepository;
  private final TransactionMapper transactionMapper;

  public void saveExpense(TransactionDto transactionDto) {
    // Сохраните операцию в базу данных
    transactionRepository.save(transactionMapper.fromDto(transactionDto));
  }
}
