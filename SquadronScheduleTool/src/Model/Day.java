package Model;

import java.util.Date;
import java.util.List;

public class Day {
	private Date dayDate;
	private List<Event> eventList;
	
	public Date getDayDate() {
		return dayDate;
	}
	public void setDayDate(Date dayDate) {
		this.dayDate = dayDate;
	}
	public List<Event> getEventList() {
		return eventList;
	}
	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}

}
