package junior.test.task.controller;

import junior.test.task.model.MonthlyLimit;
import junior.test.task.service.MonthlyLimitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;

@RestController
@RequiredArgsConstructor
@RequestMapping("/limits")
public class MonthlyLimitController {
  private final MonthlyLimitService monthlyLimitService;

  @PostMapping("/goods")
  public MonthlyLimit addLimitsForGoods(@RequestBody MonthlyLimit monthlyLimit){
    return monthlyLimitService.setGoodsLimit(monthlyLimit, monthlyLimit.getGoodsLimitUSD());
  }

  @PostMapping("/service")
  public MonthlyLimit addLimitsForServices(@RequestBody MonthlyLimit monthlyLimit){
    return monthlyLimitService.setServicesLimit(monthlyLimit, monthlyLimit.getServicesLimitUSD());
  }

  @GetMapping(value = "{month}")
  public MonthlyLimit getMonthLimits(@PathVariable(name = "month") YearMonth month){
    return monthlyLimitService.getOrCreateLimitForMonth(month);
  }
}
