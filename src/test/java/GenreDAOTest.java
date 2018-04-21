

import com.onlineLibrary.library.dao.implementations.GenreDAOImplementation;
import com.onlineLibrary.library.dao.interfaces.GenreDAO;
import com.onlineLibrary.library.entities.Book;
import com.onlineLibrary.library.entities.Genre;
import junit.framework.TestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GenreDAOTest  extends Assert {

    private GenreDAO genreDAO = new GenreDAOImplementation();

    @Test
    public void genres_count_should_more_zero_and_genresList_not_null_if_return_all_genres(){
        List<Genre> genresList = genreDAO.getAllGenres();


        int genresCount = genresList.size();
        assertTrue(genresCount > 0);
    }
}
