package junior.test.task.controller;

import junior.test.task.dto.TransactionDto;
import junior.test.task.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/expenses")
public class TransactionController {
  private final TransactionService transactionService;

  @PostMapping
  public TransactionDto addExpense(@RequestBody TransactionDto transactionDto) {
    return transactionService.saveExpense(transactionDto);
  }

}
