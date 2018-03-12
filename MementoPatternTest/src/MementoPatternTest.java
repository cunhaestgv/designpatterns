import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.es2.memento.BackupService;
import com.es2.memento.ExistingStudentException;
import com.es2.memento.NotExistingSnapshotException;
import com.es2.memento.Server;

class MementoPatternTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	
	@Test
	@DisplayName("Test if the server returns to the initial server state")
	void testAddReturnInitialServerState() throws ExistingStudentException, NotExistingSnapshotException {
		Server s = new Server();
		BackupService backup =  new BackupService(s);
		backup.takeSnapshot();
		s.addStudent("Maria José");
		s.addStudent("Manuel António");
		
		assertEquals(s.getStudentNames().size(), 2);
		
		backup.restoreSnapshot(0);		
		assertEquals(s.getStudentNames().size(), 0);
	}
	
	@Test
	@DisplayName("Test if the server returns to a previous snapshot")
	void testAddReturnToPreviousSnapshot() throws ExistingStudentException, NotExistingSnapshotException {
		Server s = new Server();
		BackupService backup =  new BackupService(s);
		backup.takeSnapshot();
		s.addStudent("Maria José");
		backup.takeSnapshot();
		s.addStudent("Manuel António");
		
		assertEquals(2, s.getStudentNames().size());
		
		backup.restoreSnapshot(1);		
		assertEquals(1, s.getStudentNames().size());
	}
	
	@Test
	@DisplayName("Test if the server ExistingStudentException is thrown")
	void testExistingStudentExceptionThrown() throws ExistingStudentException {
		Server s = new Server();
		s.addStudent("Maria José");
		assertThrows(ExistingStudentException.class,()->{
			s.addStudent("Maria José");
		});
	}
	
	@Test
	@DisplayName("Test if the server NotExistingSnapshotException is thrown")
	void testNotExistingSnapshotException() throws ExistingStudentException {
		Server s = new Server();
		BackupService backup =  new BackupService(s);
		backup.takeSnapshot();
		s.addStudent("Maria José");
		backup.takeSnapshot();
		s.addStudent("Manuel António");
							
		assertThrows(NotExistingSnapshotException.class,()->{
			backup.restoreSnapshot(2);
		});
	}

}
