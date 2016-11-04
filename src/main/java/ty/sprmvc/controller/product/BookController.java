package ty.sprmvc.controller.product;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ty.sprmvc.domain.product.Book;
import ty.sprmvc.domain.product.Category;
import ty.sprmvc.service.product.BookService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    private static final Log logger = LogFactory.getLog(BookController.class);

    @RequestMapping(value = "/input-book.pro")
    public String inputBook(Model model) {
        List<Category> categories = bookService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("book", new Book());
        return "product/BookAddForm";
    }

    @RequestMapping(value = "/edit-book.pro/{id}")
    public String editBook(Model model, @PathVariable long id) {
        List<Category> categories = bookService.getAllCategories();
        model.addAttribute("categories", categories);
        Book book = bookService.get(id);
        model.addAttribute("book", book);
        return "product/BookEditForm";
    }

    @RequestMapping(value = "/save-book.pro")
    public String saveBook(@ModelAttribute Book book) {
        Category category = bookService.getCategory(book.getCategory().getId());
        book.setCategory(category);
        bookService.save(book);
        return "redirect:/list-books.pro";
    }

    @RequestMapping(value = "/update-book.pro")
    public String updateBook(@ModelAttribute Book book) {
        Category category = bookService.getCategory(book.getCategory().getId());
        book.setCategory(category);
        bookService.update(book);
        return "redirect:/list-books.pro";
    }

    @RequestMapping(value = "/list-books.pro")
    public String listBooks(Model model) {
        logger.info("list-book");
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "product/BookList";
    }
}
