package croissant.source.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Resizable {
	
	@Column(name = "beforeStartResizable")
	private Boolean beforeStart;
	@Column(name = "afterEndResizable")
	private Boolean afterEnd;
}