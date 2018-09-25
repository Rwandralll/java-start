package croissant.source.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class CalendarEventColorModel {
	@Column(name = "primaryColor")
	private String primary;
	@Column(name = "secondaryColor")
	private String secondary;
}
