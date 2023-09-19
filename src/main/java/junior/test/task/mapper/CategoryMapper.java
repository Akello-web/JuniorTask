package junior.test.task.mapper;


import junior.test.task.dto.CategoryDto;
import junior.test.task.model.Category;

import java.util.List;

public interface CategoryMapper {
  CategoryDto toDto(Category transaction);

  Category fromDto(CategoryDto transactionDto);

  List<CategoryDto> toTransactionDtoList(List<Category> categoryList);
  List<Category> toTransactionModelList(List<CategoryDto> categoryDtoList);
}
