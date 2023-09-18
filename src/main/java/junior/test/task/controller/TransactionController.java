package junior.test.task.controller;

import junior.test.task.dto.TransactionDto;
import junior.test.task.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expenses")
public class TransactionController {
  private final TransactionService transactionService;

  @Autowired
  public TransactionController(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @PostMapping("/add")
  public ResponseEntity<String> addExpense(@RequestBody TransactionDto transactionDto) {
    // Вызовите метод сервиса для сохранения операции
    transactionService.saveExpense(transactionDto);
    // Верните ответ клиенту, например, "Операция успешно сохранена"
    return ResponseEntity.ok("Операция успешно сохранена");
  }

}
