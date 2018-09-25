package croissant.source.enumeration;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ColorEnumeration {

	red("#ad2121", "#FAE3E3"), 
	blue("#1e90ff", "#D1E8FF"), 
	yellow("#e3bc08", "#FDF1BA");

	private String primary;
	private String secondary;

	ColorEnumeration(String primary, String secondary) {
		this.primary = primary;
		this.secondary = secondary;
	}

	public String getPrimary() {
		return this.primary;
	}

	public String getSecondary() {
		return this.secondary;
	}
}
