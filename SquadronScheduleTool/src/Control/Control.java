package Control;

import java.util.ArrayList;

import Model.Event;
import Model.Position;
import Model.Schedule;
import View.PositionPanel;
import View.SchedulePanel;

public class Control {
	Schedule schedule;
	SchedulePanel panel;
	
	public void initControl(SchedulePanel panel){
		this.panel = panel;
		panel.setControl(this);
	}
	
	public void initializeSchedule(){
		schedule = new Schedule();
		schedule.initialize();
		
		//Attach positions to positionPanels
		ArrayList<PositionPanel> posPanelList = (ArrayList<PositionPanel>) panel.getPositionPanelList();
		
		int index = 0;
		
		for(Event event : schedule.getDayList().get(0).getEventList()){
			for(Position pos : event.getPositionList()){
				PositionPanel posPanel = posPanelList.get(index);
				//Add position to posPanel
				posPanel.setPosition(pos);
				index++;
			}
				
		}
		
		
		//Generate Schedule
		
		//Update Interface
		updateInterface();
		
	}
	
	public void generateSchedule(){
		//Generate schedule option
		schedule.completeSchedule();
		
		//Update boxes
		updateInterface();
	}
	
	
	
	private void updateInterface(){
		ArrayList<PositionPanel> posPanelList = (ArrayList<PositionPanel>) panel.getPositionPanelList();
		
		for(PositionPanel positionPanel : posPanelList){
			positionPanel.update();
		}
	}
}
