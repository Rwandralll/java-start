package croissant.source.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import croissant.source.model.CalendarEventModel;

@Repository
@Transactional
public class CalendarEventDaoImpl extends AbstractDao implements CalendarEventDao {
	
	private static final Logger logger = Logger.getLogger(CalendarEventDaoImpl.class);

	@Override
	public List<CalendarEventModel> getAllEvent() {
		logger.info("getAllEvent");
		return this.getAll(CalendarEventModel.class);
	}

	@Override
	public void addEvent(CalendarEventModel calendarEventModel) {
		logger.info("addEvent");
		this.saveOrUpdate(calendarEventModel);
	}

	@Override
	public void updateEvent(CalendarEventModel calendarEventModel) {
		logger.info("updateEvent");
		this.saveOrUpdate(calendarEventModel);
	}

	@Override
	public void deleteEvent(CalendarEventModel calendarEventModel) {
		logger.info("deleteEvent");
		this.delete(calendarEventModel);
	}

}
