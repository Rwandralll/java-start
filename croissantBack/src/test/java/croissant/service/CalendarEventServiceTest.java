package croissant.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import croissant.AbstractTest;
import croissant.source.dao.CalendarEventDao;
import croissant.source.model.CalendarEventModel;
import croissant.source.service.CalendarEventServiceImpl;

public class CalendarEventServiceTest extends AbstractTest {

	@Mock
	private CalendarEventDao calendarEventDao;

	@InjectMocks
	private CalendarEventServiceImpl calendarEventService;

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllEventTest() throws Exception {

		List<CalendarEventModel> calendarEventModelList = new ArrayList<CalendarEventModel>();

		CalendarEventModel calendarEventModel1 = new CalendarEventModel();
		calendarEventModel1.setTitle("Test0");
		CalendarEventModel calendarEventModel2 = new CalendarEventModel();

		calendarEventModelList.add(calendarEventModel1);
		calendarEventModelList.add(calendarEventModel2);

		when(calendarEventDao.getAllEvent()).thenReturn(calendarEventModelList);

		List<CalendarEventModel> calendarEventModelListReturn = this.calendarEventService
				.getAllEvent();

		assertThat(calendarEventModelListReturn.size(), is(notNullValue()));
		assertEquals(2, calendarEventModelListReturn.size());
		assertEquals("Test0", calendarEventModelListReturn.get(0).getTitle());
	}

	@Test
	public void addEvent() {
		try {
			calendarEventService.addEvent(new CalendarEventModel());
			verify(calendarEventDao, times(1)).addEvent(
					any(CalendarEventModel.class));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

}
