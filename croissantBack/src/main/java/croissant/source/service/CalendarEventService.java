package croissant.source.service;

import java.util.List;

import croissant.source.model.CalendarEventModel;

public interface CalendarEventService {

	List<CalendarEventModel> getAllEvent();
	void addEvent(CalendarEventModel calendarEventModel) throws Exception;
	void updateEvent(CalendarEventModel calendarEventModel) throws Exception;
	void deleteEvent(CalendarEventModel calendarEventModel) throws Exception;
}
