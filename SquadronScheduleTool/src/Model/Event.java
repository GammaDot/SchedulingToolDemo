package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Event {
	private String title;
	private Date eventStart;
	private Date eventEnd;
	private List<Position> positionList;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public Date getEventStart() {
		return eventStart;
	}
	public void setEventStart(Date eventStart) {
		this.eventStart = eventStart;
	}
	public Date getEventEnd() {
		return eventEnd;
	}
	public void setEventEnd(Date eventEnd) {
		this.eventEnd = eventEnd;
	}
	public List<Position> getPositionList() {
		return positionList;
	}
	public void setPositionList(List<Position> positionList) {
		this.positionList = positionList;
	}
	
	public boolean doesConflict(Date startDate, Date endDate){
		if (this.eventEnd.after(startDate))
			return true;
		
		if (this.eventStart.before(endDate))
			return true;
		
		return false;
	}
	
	public boolean doesConflict(Event evt){
		return doesConflict(evt.getEventStart(), evt.getEventEnd());
	}
	
	public void addPosition(Position pos){
		if(positionList == null)
			positionList = new ArrayList<Position>();
		
		positionList.add(pos);
	}
	
	
	
	
}
