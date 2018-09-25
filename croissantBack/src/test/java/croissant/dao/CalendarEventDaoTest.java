package croissant.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseSetup;

import croissant.AbstractTest;
import croissant.source.dao.CalendarEventDao;
import croissant.source.model.CalendarEventModel;

@DatabaseSetup("dataset.xml")
public class CalendarEventDaoTest extends AbstractTest {

	@Autowired
	private CalendarEventDao calendarEventDao;

	@Test
	public void getAllEventTest() throws Exception {
		List<CalendarEventModel> calendarEventModelList = this.calendarEventDao
				.getAllEvent();
		assertEquals(2, calendarEventModelList.size());
		assertEquals("Test0", calendarEventModelList.get(0).getTitle());
	}

}
