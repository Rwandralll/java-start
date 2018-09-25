package croissant.source.entryPoint;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import croissant.source.model.CalendarEventModel;
import croissant.source.service.CalendarEventService;

@Controller
@RequestMapping("/event")
public class CalendarEventEntryPoint {

	@Autowired
	private CalendarEventService calendarEventService;
	
	private static final Logger logger = Logger.getLogger(CalendarEventEntryPoint.class);
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	@ResponseBody
	public List<CalendarEventModel> getAllEvent(ModelMap model) {
		logger.info("getAllEvent");
		return this.calendarEventService.getAllEvent();
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public ResponseEntity<Void> addEvent(@RequestBody CalendarEventModel calendarEventModel) {
		logger.info("addEvent "+calendarEventModel);
		HttpHeaders headers = new HttpHeaders();
		try {
			this.calendarEventService.addEvent(calendarEventModel);
			logger.info("addEvent: Done");
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("addEvent: Fail");
			logger.error(e.getMessage());
			return new ResponseEntity<Void>(headers, HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public ResponseEntity<Void> updateEvent(@RequestBody CalendarEventModel calendarEventModel) {
		logger.info("updateEvent "+calendarEventModel);
		HttpHeaders headers = new HttpHeaders();
		try {
			this.calendarEventService.updateEvent(calendarEventModel);
			logger.info("updateEvent: Done");
			return new ResponseEntity<Void>(headers, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateEvent: Fail");
			logger.error(e.getMessage());
			return new ResponseEntity<Void>(headers, HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public ResponseEntity<Void> deleteEvent(@RequestBody CalendarEventModel calendarEventModel) {
		logger.info("deleteEvent "+calendarEventModel);
		HttpHeaders headers = new HttpHeaders();
		try {
			this.calendarEventService.deleteEvent(calendarEventModel);
			logger.info("deleteEvent: Done");
			return new ResponseEntity<Void>(headers, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteEvent: Fail");
			logger.error(e.getMessage());
			return new ResponseEntity<Void>(headers, HttpStatus.CONFLICT);
		}
	}
	
}
