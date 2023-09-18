package junior.test.task.service;

import junior.test.task.model.Transaction;
import junior.test.task.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {
  private final TransactionRepository transactionRepository;

  public void saveExpense(Transaction transaction) {
    // Сохраните операцию в базу данных
    transactionRepository.save(transaction);
  }
}
