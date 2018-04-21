package tests;

import com.onlineLibrary.library.dao.interfaces.WriterDAO;
import com.onlineLibrary.library.entities.Writer;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WriterDAOTest extends TestCase {
    @Autowired
    private WriterDAO writerDAO;

    @Test
    public void writers_count_should_more_zero_and_writerList_not_null_if_return_all_writers(){
        List<Writer> writerList = writerDAO.getAllWriters();
        assertNotNull(writerList);

        int writersCount = writerList.size();
        assertTrue(writersCount > 0);
    }
}
