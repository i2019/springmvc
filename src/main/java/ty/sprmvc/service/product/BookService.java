package ty.sprmvc.service.product;

import java.util.List;

import ty.sprmvc.domain.product.Book;
import ty.sprmvc.domain.product.Category;


public interface BookService {
    List<Category> getAllCategories();
    Category getCategory(int id);
    List<Book> getAllBooks();
    Book save(Book book);
    Book update(Book book);
    Book get(long id);
    long getNextId();
}