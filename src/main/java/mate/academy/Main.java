package mate.academy;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import mate.academy.dao.BookDao;
import mate.academy.lib.Injector;
import mate.academy.model.Book;

public class Main {

    private static final Injector injector = Injector.getInstance("mate.academy");
    private static final String FIRST_TITLE = "To Kill a Mockingbird";
    private static final String SECOND_TITLE = "1984";
    private static final String THIRD_TITLE = "The Great Gatsby";
    private static final BigDecimal FIRST_PRICE = BigDecimal.valueOf(99.99);
    private static final BigDecimal SECOND_PRICE = BigDecimal.valueOf(79.99);
    private static final BigDecimal THIRD_PRICE = BigDecimal.valueOf(129.99);
    private static final BigDecimal FOURTH_PRICE = BigDecimal.valueOf(150.09);

    public static void main(String[] args) {

        Book firstBook = new Book();
        firstBook.setTitle(FIRST_TITLE);
        firstBook.setPrice(FIRST_PRICE);

        Book secondBook = new Book();
        secondBook.setTitle(SECOND_TITLE);
        secondBook.setPrice(SECOND_PRICE);

        Book thirdBook = new Book();
        thirdBook.setTitle(THIRD_TITLE);
        thirdBook.setPrice(THIRD_PRICE);

        BookDao bookDao = (BookDao) injector.getInstance(BookDao.class);
        bookDao.create(firstBook);
        bookDao.create(secondBook);
        bookDao.create(thirdBook);

        Optional<Book> bookById = bookDao.findById(1L);
        System.out.println(bookById);

        List<Book> books = bookDao.findAll();
        System.out.println(books);

        thirdBook.setPrice(FOURTH_PRICE);
        bookDao.update(thirdBook);

        bookDao.deleteById(2L);
        System.out.println(bookDao.findAll());

    }
}
