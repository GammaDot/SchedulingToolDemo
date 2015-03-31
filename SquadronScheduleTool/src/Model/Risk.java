package Model;

public class Risk {
	private String title;
	private Aircrew targetAircrew;
	private Aircrew restrictionAircrew;
	private String eventType;
	private String restrictionType;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Aircrew getTargetAircrew() {
		return targetAircrew;
	}
	public void setTargetAircrew(Aircrew aircrew) {
		this.targetAircrew = aircrew;
	}
	
	public Aircrew getRestrictionAircrew() {
		return restrictionAircrew;
	}
	public void setRestrictionAircrew(Aircrew restrictionAircrew) {
		this.restrictionAircrew = restrictionAircrew;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getRestrictionType() {
		return restrictionType;
	}
	public void setRestrictionType(String restrictionType) {
		this.restrictionType = restrictionType;
	}
	
	
	
}
