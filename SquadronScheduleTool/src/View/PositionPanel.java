package View;

import javax.swing.JPanel;

import Model.Aircrew;
import Model.Position;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JComboBox;
import java.awt.event.ActionEvent;

import javax.swing.JToggleButton;

import java.awt.Font;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class PositionPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<Aircrew> comboBox;
	private JToggleButton tglbtnLock;
	private JToggleButton tglbtnRemove;
	private final Action action = new SwingAction();
	private Position position;
	private final Action action_1 = new SwingAction_1();
	
	/**
	 * Create the panel.
	 */
	public PositionPanel() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("165px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("60px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("115px"),},
			new RowSpec[] {
				RowSpec.decode("24px"),}));
		
		comboBox = new JComboBox<Aircrew>();
		add(comboBox, "2, 1, fill, center");
		
		tglbtnLock = new JToggleButton("Lock");
		tglbtnLock.setAction(action);
		
		tglbtnLock.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		add(tglbtnLock, "4, 1");
		
		tglbtnRemove = new JToggleButton("Remove");
		tglbtnRemove.setAction(action_1);
		tglbtnRemove.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		add(tglbtnRemove, "6, 1, fill, default");

	}
	
	private void lockClicked(){
		if(tglbtnLock.isSelected()){
			this.position.setAssignedAircrew((Aircrew) this.comboBox.getSelectedItem());
			this.position.setLocked(true);
			
			this.tglbtnRemove.setEnabled(false);
		}
		
		else{
			this.position.setLocked(false);
			this.tglbtnRemove.setEnabled(true);
		}
	}
	private class SwingAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public SwingAction() {
			putValue(NAME, "Lock");
			putValue(SHORT_DESCRIPTION, "Lock Aircrew in Place");
		}
		public void actionPerformed(ActionEvent e) {
			lockClicked();
		}
	}
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	public void update(){
		this.comboBox.removeAllItems();
		
		if(this.position.isLocked()){
			this.tglbtnLock.setSelected(true);
			this.comboBox.addItem(position.getAssignedAircrew());
		}
		
		else{
			for(Aircrew ac : position.getAvailableAircrewList()){
				this.comboBox.addItem(ac);
			}
			this.comboBox.setSelectedItem(position.getAssignedAircrew());
		}
		
	}
	
	
	private class SwingAction_1 extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public SwingAction_1() {
			putValue(NAME, "Remove");
			putValue(SHORT_DESCRIPTION, "Prevent this Aircrew from being scheduled in this position");
		}
		public void actionPerformed(ActionEvent e) {
			removeClicked();
		}
	}
	
	public void resetRemoveClicked(){
		this.tglbtnRemove.setSelected(false);
		this.tglbtnRemove.setText("Remove");
		this.tglbtnLock.setEnabled(true);
	}
	
	private void removeClicked(){
		Aircrew ac = this.position.getAssignedAircrew();
		
		if(!this.tglbtnRemove.isSelected()){
			if(this.tglbtnRemove.getText().endsWith("Remove Position")){
				this.tglbtnRemove.setSelected(true);
				this.tglbtnRemove.setText("Remove Event");
				
				//Remove the current exclusion - because we're going to add one to each position in the event
				this.position.removeExclusion(ac);
				//Iterate over all positions in the event, and set an exclusion for the aircrew
				for(Position pos : this.position.parentEvent.getPositionList()){
					pos.excludeAircrew(ac);
				}
				
			}
			else{
				this.tglbtnRemove.setText("Remove");
				this.tglbtnLock.setEnabled(true);
				
				//Remove all exclusions for this aircrew
				for(Position pos : this.position.parentEvent.getPositionList()){
					pos.excludeAircrew(ac);
				}
			}
		}
		else{
			this.tglbtnRemove.setText("Remove Position");
			this.tglbtnLock.setEnabled(false);
			
			
			this.position.excludeAircrew(ac);
		}
	}
}
