package tests;

import com.onlineLibrary.library.dao.interfaces.PublisherDAO;
import com.onlineLibrary.library.entities.Publisher;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PublisherDAOTest extends TestCase {
    @Autowired
    private PublisherDAO publisherDAO;

    @Test
    public void publishers_count_should_more_zero_and_publisherList_not_null_if_return_all_publishers(){
        List<Publisher> publisherList = publisherDAO.getAllPublishers();
        assertNotNull(publisherList);

        int publishersCount = publisherList.size();
        assertTrue(publishersCount > 0);
    }
}
