package junior.test.task.mapper;

import junior.test.task.dto.TransactionDto;
import junior.test.task.model.Transaction;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
  TransactionDto toDto(Transaction transaction);

  Transaction fromDto(TransactionDto transactionDto);

  List<TransactionDto> toTransactionDtoList(List<Transaction> commentsList);
  List<Transaction> toTransactionModelList(List<TransactionDto> commentsDTO);
}
