import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.es2.stubs.AuthorServiceImpl;
import com.es2.stubs.BookDaoImpl;
import com.es2.stubs.BookServiceImpl;
import com.es2.stubs.FakeBookValidatorService;
import com.es2.stubs.MockBookServiceImpl;

class TestStubTopDown {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
    public void test_total_book_by_mock() {

	/*	//1. Setup
        AuthorServiceImpl obj = new AuthorServiceImpl();
        BookServiceImpl bookService = new BookServiceImpl();
        bookService.setBookDao(new BookDaoImpl()); //Where Dao connect to?
        obj.setBookService(bookService);
        obj.setBookValidatorService(new FakeBookValidatorService());

		//2. Test method
        int qty = obj.getTotalBooks("mkyong");

		//3. Verify result
        assertEquals(qty, 3);*/

    }
	
	@Test
    public void test_total_book_by_mock2() {

		//1. Setup
        AuthorServiceImpl obj = new AuthorServiceImpl();

        /*BookServiceImpl bookService = new BookServiceImpl();
        bookService.setBookDao(new BookDaoImpl());
        obj.setBookService(bookService);*/

        obj.setBookService(new MockBookServiceImpl());
        obj.setBookValidatorService(new FakeBookValidatorService());

		//2. Test method
        int qty = obj.getTotalBooks("mkyong");

		//3. Verify result
        assertEquals(qty, 3);

    }

}
