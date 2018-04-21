
import com.onlineLibrary.library.dao.implementations.BookDAOImplementation;
import com.onlineLibrary.library.dao.interfaces.BookDAO;
import com.onlineLibrary.library.entities.Book;
import com.onlineLibrary.library.entities.Genre;
import com.onlineLibrary.library.entities.Publisher;
import com.onlineLibrary.library.entities.Writer;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="../../../web/WEB-INF/configurations/spring/dispatcher-servlet.xml")
@WebAppConfiguration
public class BookDAOTest extends Assert{

   @Autowired
    private BookDAO bookDAO;

   @Autowired
   private SessionFactory sessionFactory;

    @Test
    public void bookDao_should_be_not_null(){
        assertNotNull(bookDAO);
    }

    @Test
    public void books_count_should_more_zero_and_booksList_not_null_if_return_all_books(){
        List<Book> booksList = bookDAO.getAllBooks();
        int booksCount = booksList.size();
        assertNotNull(booksList);
        assertTrue(booksCount > 0);
    }

    @Test
    public void equals_should_return_true_if_found_book_by_name(){
        String bookName = "Бог как иллюзия";
        Book book = new Book();
        book.setName(bookName);

        List<Book> books = bookDAO.getBooksByName(bookName);
        Book bookReceivedOnQuery;
        if(books.size() > 0){
            bookReceivedOnQuery = books.get(0);
            assertNotNull(bookReceivedOnQuery);
            assertEquals(bookReceivedOnQuery.getName(), book.getName());
        }
    }

    @Test
    public void equals_should_return_true_if_found_book_by_genre(){
        String genreName = "Научно-популярная";
        Genre genre = new Genre();
        genre.setName(genreName);

        List<Book> books = bookDAO.getBooksByGenre(genre);
        Book bookReceivedOnQuery;
        if(books.size() > 0){
            bookReceivedOnQuery = books.get(0);
            assertNotNull(bookReceivedOnQuery);
            assertEquals(bookReceivedOnQuery.getGenre().getName(), genre.getName());
        }
    }

    @Test
    public void equals_should_return_true_if_found_book_by_publisher(){
        String publisherName = "Азбука";
        Publisher publisher = new Publisher();
        publisher.setId(1);
        publisher.setName(publisherName);

        List<Book> books = bookDAO.getBooksByPublisher(publisher);
        Book bookReceivedOnQuery;
        if(books.size() > 0){
            bookReceivedOnQuery = books.get(0);
            assertNotNull(bookReceivedOnQuery);
            assertEquals(bookReceivedOnQuery.getPublisher(), publisher);
        }
    }

    @Test
    public void equals_should_return_true_if_found_book_by_writer(){
        String writerName = "Клинтон Ричард Докинз";
        Writer writer = new Writer();
        writer.setFullName(writerName);

        List<Book> books = bookDAO.getBooksByWriter(writer);
        Book bookReceivedOnQuery;
        if(books.size() > 0){
            bookReceivedOnQuery = books.get(0);
            assertNotNull(bookReceivedOnQuery);
            assertEquals(bookReceivedOnQuery.getWriters().get(0), writer);
        }
    }

    @Test
    public void equals_should_be_true_if_bookId__equals_deletedBookId(){
        int bookId = 1;
        int deletedBookId = bookDAO.deleteBookById(bookId);
        assertEquals(bookId, deletedBookId);
    }
}
