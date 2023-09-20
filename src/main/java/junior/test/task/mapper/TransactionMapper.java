package junior.test.task.mapper;

import junior.test.task.dto.TransactionDto;
import junior.test.task.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
  @Mapping(source = "category", target = "category")
  TransactionDto toDto(Transaction transaction);

  @Mapping(source = "category", target = "category")
  Transaction fromDto(TransactionDto transactionDto);

  @Mapping(source = "category", target = "category")
  List<TransactionDto> toTransactionDtoList(List<Transaction> transactionList);
  @Mapping(source = "category", target = "category")
  List<Transaction> toTransactionModelList(List<TransactionDto> transactionDtoList);
}
