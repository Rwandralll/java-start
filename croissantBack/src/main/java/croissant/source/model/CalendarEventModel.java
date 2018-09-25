package croissant.source.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author root
 *
 */
@Entity
@Table(name = "CalendarEvent")
@Data
public class CalendarEventModel {

	@Id
	@GeneratedValue
	@Column(name = "idCalendarEvent")
	private Integer calendarEventId;
	@Column(name = "startDate")
	private Date start;
	@Column(name = "endDate")
	private Date end;
	@Column(name = "title")
	private String title;
	@Embedded
	private CalendarEventColorModel color;
	@Embedded
	private Resizable resizable;
	@Column(name = "draggable")
	private Boolean draggable;
}
