package Model;

import java.util.ArrayList;
import java.util.List;

public class Aircrew {
	private String name;
	private List<Qualification> qualificationList = null;
	private List<Currency> currencyList = null;
	private List<Risk> riskList = null;
	private List<Event> eventList = null;
	private double totalFYFlightHours;
	private int rank;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Qualification> getQualificationList() {
		return qualificationList;
	}
	public void setQualificationList(List<Qualification> qualificationList) {
		this.qualificationList = qualificationList;
	}
	public List<Currency> getCurrencyList() {
		return currencyList;
	}
	public void setCurrencyList(List<Currency> currencyList) {
		this.currencyList = currencyList;
	}
	public List<Risk> getRiskList() {
		return riskList;
	}
	public void setRiskList(List<Risk> riskList) {
		this.riskList = riskList;
	}
	public List<Event> getEventList() {
		if(eventList == null)
			eventList = new ArrayList<Event>();
		return eventList;
	}
	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}
	public double getTotalFYFlightHours() {
		return totalFYFlightHours;
	}
	public void setTotalFYFlightHours(double totalFYFlightHours) {
		this.totalFYFlightHours = totalFYFlightHours;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public void addEvent(Event event){
		if (eventList == null)
			eventList = new ArrayList<Event>();
		
		eventList.add(event);
	}
	
	public void removeEvent(Event event){
		if (eventList != null)
			eventList.remove(event);
	}
	
	public void addQualification(Qualification qual){
		if(qualificationList == null)
			qualificationList = new ArrayList<Qualification>();
		
		qualificationList.add(qual);
	}
	
	public void addCurrency(Currency curr){
		if(currencyList == null)
			currencyList = new ArrayList<Currency>();
		
		currencyList.add(curr);
	}
	
	public void addRisk(Risk risk){
		if(riskList == null)
			riskList = new ArrayList<Risk>();
		
		riskList.add(risk);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return this.name + " " + this.totalFYFlightHours;
	}
	
	
	
}
