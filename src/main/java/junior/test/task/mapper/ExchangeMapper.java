package junior.test.task.mapper;

import junior.test.task.dto.ExchangeRateDto;

import junior.test.task.model.ExchangeRate;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExchangeMapper {

  ExchangeRateDto toDto(ExchangeRate exchangeRate);

  ExchangeRate fromDto(ExchangeRateDto exchangeRateDto);

  List<ExchangeRateDto> toExchangeRateDtoList(List<ExchangeRate> exchangeRateList);
  List<ExchangeRate> toExchangeRateModelList(List<ExchangeRateDto> exchangeRateDtoList);
}
