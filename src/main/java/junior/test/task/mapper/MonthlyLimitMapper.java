package junior.test.task.mapper;

import junior.test.task.dto.MonthlyLimitDto;
import junior.test.task.model.MonthlyLimit;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MonthlyLimitMapper {

  MonthlyLimitDto toDto(MonthlyLimit monthlyLimit);

  MonthlyLimit fromDto(MonthlyLimitDto monthlyLimitDto);

  List<MonthlyLimitDto> toMonthlyLimitDtoList(List<MonthlyLimit> monthlyLimitList);
  List<MonthlyLimit> toMonthlyLimitModelList(List<MonthlyLimitDto> monthlyLimitDtoList);
}
