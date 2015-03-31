package Model;

import java.util.ArrayList;
import java.util.List;

public class Position {
	private Aircrew assignedAircrew;
	private List<Aircrew> availableAircrewList;
	private List<Aircrew> aircrewExclusionList;
	private List<Qualification> requiredQualificationList;
		
	//Make these private
	public Position next;
	public Position previous;
	public Event parentEvent;
	private boolean isLocked = false;
	
	
	
	public boolean isLocked() {
		return isLocked;
	}
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	public Aircrew getAssignedAircrew() {
		return assignedAircrew;
	}
	public void setAssignedAircrew(Aircrew assignedAircrew) {
		if(this.assignedAircrew != null){
			this.assignedAircrew.getEventList().remove(this.parentEvent);
		}
		this.assignedAircrew = assignedAircrew;
		assignedAircrew.addEvent(this.parentEvent);
	}
	public List<Aircrew> getAvailableAircrewList() {
		return availableAircrewList;
	}
	public void setAvailableAircrewList(List<Aircrew> availableAircrewList) {
		this.availableAircrewList = availableAircrewList;
	}
	public List<Qualification> getRequiredQualificationList() {
		return requiredQualificationList;
	}
	public void setRequiredQualificationList(
			List<Qualification> requiredQualificationList) {
		this.requiredQualificationList = requiredQualificationList;
	}
	public void addQualification(Qualification qual){
		if(requiredQualificationList == null)
			requiredQualificationList = new ArrayList<Qualification>();
		
		requiredQualificationList.add(qual);
	}
	
	public void computeAvailableAircrew(List<Aircrew> aclist){
		ArrayList<Aircrew> aircrewList = (ArrayList<Aircrew>) aclist;
		
		availableAircrewList = new ArrayList<Aircrew>();
		
		//If event assigned and locked - we're done
		if(this.isLocked){
			availableAircrewList.add(this.assignedAircrew);
			return;
		}
		
		//Copy the total list to the available list as a starting point
		for(Aircrew aircrew : aircrewList){
			this.availableAircrewList.add(aircrew);
		}
		
		//Whittle down the available list based on constraints
		for(Aircrew aircrew : aircrewList){
			System.out.println(aircrew.getName());
			//Qualification
			if(requiredQualificationList != null){
				for(Qualification qual : this.requiredQualificationList){
					if(aircrew.getQualificationList() == null){
						availableAircrewList.remove(aircrew);
						System.out.println(aircrew.getName() + " removed for qual.");
					}
					else if(!aircrew.getQualificationList().contains(qual)){
						availableAircrewList.remove(aircrew);
						System.out.println(aircrew.getName() + " removed for qual.");
					}
				}
			}
			
			if(aircrew.getEventList() != null){
				for(Event event : aircrew.getEventList()){
					if(event.doesConflict(this.parentEvent))
						availableAircrewList.remove(aircrew);
						System.out.println(aircrew.getName() + " removed for Availability.");
				}
			}
			
			//Currency
			
			//Available
			
			//Risk
			
			//Manual
			if(aircrewExclusionList != null){
				for(Aircrew ac : this.aircrewExclusionList){
					this.availableAircrewList.remove(ac);
				}
			}
		}
		
		//Prioritize list based on flight hour or T&R Matrix (we only use flight hours for this demo)
		this.availableAircrewList.sort(new AircrewComparator());
		
			
	}
	
	public void removeAssignedAircrew(){
		if(this.isLocked){
			System.out.println(this.assignedAircrew.getName() + " is locked.");
			return;
		}
		if(this.assignedAircrew != null){
			this.assignedAircrew.removeEvent(this.parentEvent);
			this.assignedAircrew = null;
		}
	}
	
	public boolean assignAircrew(Aircrew aircrew){
		if(this.isLocked){
			return true;
		}
			
		
		if(this.assignedAircrew != null){
			this.assignedAircrew.removeEvent(parentEvent);
			this.assignedAircrew = null;
		}
		
		boolean available = true;
		for(Event event : aircrew.getEventList()){
			if(event.doesConflict(parentEvent)){
				available = false;
				break;
			}
		}
		
		if(available){
			this.assignedAircrew = aircrew;
			aircrew.addEvent(parentEvent);
			return true;
		}
		return false;
	}
	
	public void excludeAircrew(Aircrew aircrew){
		if(this.aircrewExclusionList == null)
			this.aircrewExclusionList = new ArrayList<Aircrew>();
		
		this.aircrewExclusionList.add(aircrew);
	}
	
	public void removeExclusion(Aircrew aircrew){
		if(this.aircrewExclusionList != null)
			this.aircrewExclusionList.remove(aircrew);
	}
	
	

}
