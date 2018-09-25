package croissant.source.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import croissant.source.dao.CalendarEventDao;
import croissant.source.model.CalendarEventModel;

@Service
@Transactional
public class CalendarEventServiceImpl implements CalendarEventService {
	
	@Autowired
	private CalendarEventDao calendarEventDao;
	
	private static final Logger logger = Logger.getLogger(CalendarEventServiceImpl.class);

	@Override
	public List<CalendarEventModel> getAllEvent() {
		logger.info("getAllEvent");
		return this.calendarEventDao.getAllEvent();
	}

	@Override
	public void addEvent(CalendarEventModel calendarEventModel) throws Exception {
		logger.info("addEvent");
		if(calendarEventModel.getCalendarEventId()==null){
			this.calendarEventDao.addEvent(calendarEventModel);
		} else {
			throw new Exception("The model already exist.");
		}
	}

	@Override
	public void updateEvent(CalendarEventModel calendarEventModel) throws Exception {
		logger.info("updateEvent");
		if(calendarEventModel.getCalendarEventId()!=null){
			this.calendarEventDao.updateEvent(calendarEventModel);
		} else {
			throw new Exception("The model doesn't exist.");
		}
	}

	@Override
	public void deleteEvent(CalendarEventModel calendarEventModel) throws Exception {
		logger.info("deleteEvent");
		if(calendarEventModel.getCalendarEventId()!=null){
			this.calendarEventDao.deleteEvent(calendarEventModel);
		} else {
			throw new Exception("The model doesn't exist.");
		}
	}

}
