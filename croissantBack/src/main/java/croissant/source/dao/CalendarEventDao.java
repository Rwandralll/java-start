package croissant.source.dao;

import java.util.List;

import croissant.source.model.CalendarEventModel;

public interface CalendarEventDao {
	List<CalendarEventModel> getAllEvent();
	void addEvent(CalendarEventModel calendarEventModel);
	void updateEvent(CalendarEventModel calendarEventModel);
	void deleteEvent(CalendarEventModel calendarEventModel);
}
