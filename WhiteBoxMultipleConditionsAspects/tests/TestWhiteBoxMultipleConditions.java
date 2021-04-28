import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.es2.multipleconditions.CourseUtils;
import com.es2.multipleconditions.DriveUtils;
import com.es2.multipleconditions.ListUtils;
import com.es2.multipleconditions.Marks;
import com.es2.multipleconditions.Person;
import com.es2.multipleconditions.PersonCannotDriveException;

class TestWhiteBoxMultipleConditions {


	@AfterAll
	static void tearDownAfterClass() {
		new End();
	}	

	@Test
	void testOverAge() throws PersonCannotDriveException {
		Person p = new Person("Ana",18);
		DriveUtils.assertConditionsToDrive(p);
	}
	
	@Test
	void testUnderAge() throws PersonCannotDriveException {
		Person p = new Person("Ana",17);
		Assertions.assertThrows(PersonCannotDriveException.class, ()-> {
			DriveUtils.assertConditionsToDrive(p);
		});
		
	}
	
	@Test
	void testNullPerson() throws PersonCannotDriveException {
		Person p =null;
		DriveUtils.assertConditionsToDrive(p);
	}
	
	@Test
	void testListEqualsName() {
		ArrayList<String> names = new ArrayList<String>();
		
		names.add("João");
		names.add("Maria");
		names.add("Ana");
		names.add("Pedro");
		
		assertEquals(ListUtils.findName(names, "João"),0);
		assertEquals(ListUtils.findName(names, "Mariana"),-1);		
	}
	
	@Test
	void testApprovedC1() {
		Marks m1 = new Marks(10,.7f,10);
		Marks m2 = new Marks(10,.6f,10);
		Marks m3 = new Marks(10,.7f,9);
		Marks m4 = new Marks(10,.6f,9);
		
		Marks m5 = new Marks(9,.7f,10);
		Marks m6 = new Marks(9,.6f,10);
		Marks m7 = new Marks(9,.7f,9);
		Marks m8 = new Marks(9,.6f,9);
		
		assertTrue(CourseUtils.approved(m1));
		assertFalse(CourseUtils.approved(m2));
		assertFalse(CourseUtils.approved(m3));
		assertFalse(CourseUtils.approved(m4));
		assertFalse(CourseUtils.approved(m5));
		assertFalse(CourseUtils.approved(m6));
		assertFalse(CourseUtils.approved(m7));
		assertFalse(CourseUtils.approved(m8));
	}

}
