package junior.test.task.controller;

import junior.test.task.dto.TransactionDto;
import junior.test.task.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/expenses")
public class TransactionController {
  private final TransactionService transactionService;

  @PostMapping
  public TransactionDto addExpense(@RequestBody TransactionDto transactionDto) {
    return transactionService.saveExpense(transactionDto);
  }

  @GetMapping("/exceeded_goods")
  public List<TransactionDto> getExceededGoods(){
    return transactionService.getGoodsExceededList();
  }

  @GetMapping("/exceeded_services")
  public List<TransactionDto> getExceededServices(){
    return transactionService.getServicesExceededList();
  }

}
