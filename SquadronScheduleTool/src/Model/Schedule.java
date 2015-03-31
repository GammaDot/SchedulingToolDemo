package Model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Schedule {
	private List<Day> dayList;
	
	private List<Aircrew> aircrewList;
	private List<Event> tomorrowSchedule;
	

	//public static void main(String[] args) {
	public void initialize(){
		// TODO Auto-generated method stub
		
		aircrewList = new ArrayList<Aircrew>();
		ArrayList<Qualification> qualificationList = new ArrayList<Qualification>();
		ArrayList<Currency> currencyList = new ArrayList<Currency>();
		ArrayList<Risk> riskList = new ArrayList<Risk>();
		
		//Brute force population of required initial state
		
		//Aircrew List
		Aircrew co = new Aircrew();
		co.setName("CDR Albert");
		co.setRank(1);
		co.setTotalFYFlightHours(10.2);
		aircrewList.add(co);
		
		Aircrew xo = new Aircrew();
		xo.setName("CDR Baker");
		xo.setRank(2);
		xo.setTotalFYFlightHours(8.6);
		aircrewList.add(xo);
		
		Aircrew opso = new Aircrew();
		opso.setName("Collier");
		opso.setRank(3);
		opso.setTotalFYFlightHours(5.3);
		aircrewList.add(opso);
		
		Aircrew mo = new Aircrew();
		mo.setName("Deter");
		mo.setRank(4);
		mo.setTotalFYFlightHours(10.4);
		aircrewList.add(mo);
		
		Aircrew admin = new Aircrew();
		admin.setName("Ellington");
		admin.setRank(5);
		admin.setTotalFYFlightHours(2.1);
		aircrewList.add(admin);
		
		Aircrew safety = new Aircrew();
		safety.setName("Flores");
		safety.setRank(6);
		safety.setTotalFYFlightHours(12.3);
		aircrewList.add(safety);
	
		Aircrew training = new Aircrew();
		training.setName("Gregory");
		training.setRank(7);
		training.setTotalFYFlightHours(10.7);
		aircrewList.add(training);
		
		Aircrew aops = new Aircrew();
		aops.setName("Hines");
		aops.setRank(8);
		aops.setTotalFYFlightHours(8.6);
		aircrewList.add(aops);
		
		Aircrew aawto = new Aircrew();
		aawto.setName("Inoye");
		aawto.setRank(9);
		aawto.setTotalFYFlightHours(6.8);
		aircrewList.add(aawto);
		
		Aircrew agwto = new Aircrew();
		agwto.setName("Jones");
		agwto.setRank(10);
		agwto.setTotalFYFlightHours(4.5);
		aircrewList.add(agwto);
		
		Aircrew avarm = new Aircrew();
		avarm.setName("Kilmer");
		avarm.setRank(11);
		avarm.setTotalFYFlightHours(12.4);
		aircrewList.add(avarm);
	
		Aircrew line = new Aircrew();
		line.setName("Lincoln");
		line.setRank(12);
		line.setTotalFYFlightHours(8.4);
		aircrewList.add(line);
		
		Aircrew airframe = new Aircrew();
		airframe.setName("Moss");
		airframe.setRank(13);
		airframe.setTotalFYFlightHours(2.1);
		aircrewList.add(airframe);
		
		Aircrew sked1 = new Aircrew();
		sked1.setName("Naylor");
		sked1.setRank(14);
		sked1.setTotalFYFlightHours(1.2);
		aircrewList.add(sked1);
		
		Aircrew sked2 = new Aircrew();
		sked2.setName("Olmyer");
		sked2.setRank(15);
		sked2.setTotalFYFlightHours(1.3);
		aircrewList.add(sked2);
		
		//Qualification Constraint List
		Qualification divi = new Qualification();
		divi.setTitle("Division Lead Instructor");
		qualificationList.add(divi);
		co.addQualification(divi);
		xo.addQualification(divi);
		opso.addQualification(divi);
		mo.addQualification(divi);
		admin.addQualification(divi);
		
		Qualification div = new Qualification();
		div.setTitle("Division Lead");
		qualificationList.add(div);
		co.addQualification(div);
		xo.addQualification(div);
		opso.addQualification(div);
		mo.addQualification(div);
		admin.addQualification(div);
		safety.addQualification(div);
		training.addQualification(div);
		aops.addQualification(div);
		aawto.addQualification(div);
		agwto.addQualification(div);
		
		Qualification divui = new Qualification();
		divui.setTitle("Division Lead Under Instructon");
		qualificationList.add(divui);
		avarm.addQualification(divui);
		
		Qualification seci = new Qualification();
		seci.setTitle("Section Lead Instructor");
		qualificationList.add(seci);
		
		Qualification sec = new Qualification();
		sec.setTitle("Section Lead");
		qualificationList.add(sec);
		co.addQualification(sec);
		xo.addQualification(sec);
		opso.addQualification(sec);
		mo.addQualification(sec);
		admin.addQualification(sec);
		safety.addQualification(sec);
		training.addQualification(sec);
		aops.addQualification(sec);
		aawto.addQualification(sec);
		agwto.addQualification(sec);
		avarm.addQualification(sec);
		line.addQualification(sec);
		airframe.addQualification(sec);
		
		Qualification secui = new Qualification();
		secui.setTitle("Section Lead Under Instruction");
		qualificationList.add(secui);
		
		//Currency Constraint List
		//Note that these items only need the title - not an expiration (which is used
		//for individual aircrew currency constraints
		Currency curr = new Currency();
		curr.setTitle("BFM Currency");
		
		//Add BFM Currency for aircrew
		
		//Add aircrew total flight time
		
		//Risk Constraint List
		
		//Require that the new guy fly with the training officer and senior
		Risk risk = new Risk();
		risk.setEventType(null);
		risk.setRestrictionType("Fly with X and above");
		risk.setTargetAircrew(sked2);
		risk.setRestrictionAircrew(training);
		
		//Build schedule constraints (events are used to contain snivs also)
		Event sniv = new Event();
		sniv.setTitle("Scheduled Leave");
		
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(2015, 3, 16, 7, 0);
		sniv.setEventStart(cal.getTime());
		cal.set(2015,  3, 20, 23, 0);
		sniv.setEventEnd(cal.getTime());
		
		sked1.addEvent(sniv);
		
		//Build Schedule Events and Positions
		tomorrowSchedule = new ArrayList<Event>();
		
		Event oca = new Event();
		Event red1 = new Event();
		Event bfm = new Event();
		Event ses = new Event();
		Event red2 = new Event();
		
		
		//4x OCA
		GregorianCalendar start = new GregorianCalendar();
		start.set(2015,  3, 20, 10, 0);
		
		GregorianCalendar end = new GregorianCalendar();
		end.set(2015,  3, 20, 12, 0);
		
		oca.setEventStart(start.getTime());
		oca.setEventEnd(end.getTime());
		oca.setTitle("4x OCA");

		Position oca1 = new Position();
		oca1.parentEvent = oca;
		oca1.addQualification(div);
		
		Position oca2 = new Position();
		oca2.parentEvent = oca;
		//oca2.addQualification(divi);
		
		Position oca3 = new Position();
		oca3.parentEvent = oca;
		oca3.addQualification(sec);
		
		Position oca4 = new Position();
		oca4.parentEvent = oca;
		
		oca.addPosition(oca1);
		oca.addPosition(oca2);
		oca.addPosition(oca3);
		oca.addPosition(oca4);			
		
		//2x Red
		red1.setEventStart(start.getTime());
		red1.setEventEnd(end.getTime());
		red1.setTitle("2x Red Air");
		
		Position red11 = new Position();
		red11.parentEvent = red1;
		//red11.addQualification(sec);
		
		Position red12 = new Position();
		red12.parentEvent = red1;
		
		red1.addPosition(red11);
		red1.addPosition(red12);

		//2x BFM
		start.set(2015,  3, 20, 11, 0);
		end.set(2015,  3, 20, 14, 0);
		
		bfm.setEventStart(start.getTime());
		bfm.setEventEnd(end.getTime());
		bfm.setTitle("2x BFM");
		
		Position bfm1 = new Position();
		bfm1.parentEvent = bfm;
		//bfm1.addQualification(sec);
		
		Position bfm2 = new Position();
		bfm2.parentEvent = bfm;
		//bfm2.assignAircrew(sked2);
		//bfm2.setLocked(true);
		
		bfm.addPosition(bfm1);
		bfm.addPosition(bfm2);
		
		//4x SES
		start.set(2015, 3, 20, 11, 0);
		end.set(2015, 3, 20, 17, 0);
		
		ses.setEventStart(start.getTime());
		ses.setEventEnd(end.getTime());
		ses.setTitle("4x SES");
		
		Position ses1 = new Position();
		ses1.parentEvent = ses;
		ses1.addQualification(divui);
		//ses1.assignAircrew(avarm);
		//ses1.setLocked(true);
		
		Position ses2 = new Position();
		ses2.parentEvent = ses;
		
		Position ses3 = new Position();
		ses3.parentEvent = ses;
		ses3.addQualification(sec);
		
		Position ses4 = new Position();
		ses4.parentEvent = ses;
		
		ses.addPosition(ses1);
		ses.addPosition(ses2);
		ses.addPosition(ses3);
		ses.addPosition(ses4);	
		
		red2.setEventStart(start.getTime());
		red2.setEventEnd(end.getTime());
		red2.setTitle("2x Red Air");
		
		Position red21 = new Position();
		red21.parentEvent = red2;
		//red11.addQualification(sec);
		
		Position red22 = new Position();
		red22.parentEvent = red2;
		
		red2.addPosition(red21);
		red2.addPosition(red22);
		
		oca1.next = oca2;
		oca1.previous = null;
		
		oca2.next = oca3;
		oca2.previous = oca1;
		
		oca3.next = oca4;
		oca3.previous = oca2;
		
		oca4.next = red11;
		oca4.previous = oca3;
		
		red11.next = red12;
		red11.previous = oca4;
		
		red12.next = bfm1;
		red12.previous = red11;
		
		bfm1.next = bfm2;
		bfm1.previous = oca4;
		
		bfm2.next = ses1;
		bfm2.previous = bfm1;
		
		ses1.next = ses2;
		ses1.previous = bfm2;
		
		ses2.next = ses3;
		ses2.previous = ses1;
		
		ses3.next = ses4;
		ses3.previous = ses2;
		
		ses4.next = red21;
		ses4.previous = ses3;
		
		red21.next = red22;
		red21.previous = ses4;
		
		red22.next = null;
		red22.previous = red21;
				
		
		tomorrowSchedule.add(oca);
		tomorrowSchedule.add(red1);
		tomorrowSchedule.add(bfm);
		tomorrowSchedule.add(ses);
		tomorrowSchedule.add(red2);
		
		Day day = new Day();
		day.setEventList(tomorrowSchedule);
		dayList = new ArrayList<Day>();
		dayList.add(day);
		
		//Generate the initial lists
		computeAvailableAircrew();
		
		//Generate the schedule
		//completeSchedule();
		
	}
	
	//CompleteSchedule 
	public void completeSchedule(){
		//Clear existing unlocked positions
		for(Event event : tomorrowSchedule){
			for(Position pos : event.getPositionList()){
				pos.removeAssignedAircrew();
			}
		}
		
		
		computeAvailableAircrew();
		
		Event firstEvent = this.tomorrowSchedule.get(0);
		Position firstPosition = firstEvent.getPositionList().get(0);
		
		//Kick-off recursive scheduling process by assigning aircrew to the first position
		if(placePosition(firstPosition, aircrewList) == false){
			System.out.println("Schedule not possible with these constraints");
			
			for(Aircrew ac : this.aircrewList){
				System.out.println(ac.getName() + " " + ac.getEventList().size());
			}
			
			
		}
		
		else{
			
			//Print results when finished
			System.out.println("Schedule Results");
			for(Event event : tomorrowSchedule){
				System.out.println("Event: " + event.getTitle());
				for(Position pos : event.getPositionList()){
					System.out.println(pos.getAssignedAircrew().getName());
				}
			}
		}
		
	}
	
	//Place Position
	private boolean placePosition(Position position, List<Aircrew> aircrewList){
		
		//Try the first aircrew in the list
		for(Aircrew aircrew : position.getAvailableAircrewList()){
			
			System.out.print(position.parentEvent.getTitle() + " - Placing - " + aircrew.getName());
			
			//If we succeed in assigning them
			if(position.assignAircrew(aircrew)){
				
				System.out.println(" - Succeeded!");
				
				//And there this is the last position in the list
				if(position.next == null)
					return true; //Success - Exit the recursion process
				
				//Otherwise, recursively call placePosition on the next position to continue down the tree
				if(placePosition(position.next, aircrewList))
					return true; //If this worked at a lower level, bubble up the "success" result
				
				//Otherwise - go back up to the top of the for loop - try assigning the next aircrew on the list,
				//and start the process over.
			}
			//else
				System.out.println(" - Failed.");
			
		}
		return false;
		
	}

	
	public List<Day> getDayList() {
		return dayList;
	}

	public void setDayList(List<Day> dayList) {
		this.dayList = dayList;
	}
	
	public void computeAvailableAircrew(){
		Event firstEvent = this.tomorrowSchedule.get(0);
		
		//For each position - compute available aircrew
		for(Event event : tomorrowSchedule){
			for(Position pos : event.getPositionList()){
				pos.computeAvailableAircrew(aircrewList);
			}
		}
	}

}
