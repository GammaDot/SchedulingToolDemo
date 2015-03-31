package View;
import javax.swing.JPanel;
import javax.swing.JLabel;
import Control.Control;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;


public class SchedulePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private List<PositionPanel> positionPanelList;
	private Control control;
		
	/**
	 * Create the panel.
	 */
	public SchedulePanel() {
		positionPanelList = new ArrayList<PositionPanel>();
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblxOca = new JLabel("4x OCA");
		add(lblxOca, "2, 4");
		
		PositionPanel pos1 = new PositionPanel();
		positionPanelList.add(pos1);
		add(pos1, "2, 6");
		
		PositionPanel pos2 = new PositionPanel();
		positionPanelList.add(pos2);
		add(pos2, "2, 8");
		
		PositionPanel pos3 = new PositionPanel();
		positionPanelList.add(pos3);
		add(pos3, "2, 10");
		
		PositionPanel pos4 = new PositionPanel();
		positionPanelList.add(pos4);
		add(pos4, "2, 12");
		
		
		JLabel lblxRed1 = new JLabel("2x Red");
		add(lblxRed1, "2, 16");
		
		PositionPanel pos5 = new PositionPanel();
		positionPanelList.add(pos5);
		add(pos5, "2, 18");
		
		PositionPanel pos6 = new PositionPanel();
		positionPanelList.add(pos6);
		add(pos6, "2, 20");
		
		
		JLabel lblNewLabel = new JLabel("2x BFM");
		add(lblNewLabel, "4, 4");
		
		PositionPanel pos7 = new PositionPanel();
		positionPanelList.add(pos7);
		add(pos7, "4, 6");
		
		PositionPanel pos8 = new PositionPanel();
		positionPanelList.add(pos8);
		add(pos8, "4, 8");
		
		
		JLabel lblxSes = new JLabel("4x SES");
		add(lblxSes, "6, 4");
		
		PositionPanel pos9 = new PositionPanel();
		positionPanelList.add(pos9);
		add(pos9, "6, 6");
		
		PositionPanel pos10 = new PositionPanel();
		positionPanelList.add(pos10);
		add(pos10, "6, 8");
		
		PositionPanel pos11 = new PositionPanel();
		positionPanelList.add(pos11);
		add(pos11, "6, 10");
		
		PositionPanel pos12 = new PositionPanel();
		positionPanelList.add(pos12);
		add(pos12, "6, 12");
		
		
		JLabel lblxRed2 = new JLabel("2x Red");
		add(lblxRed2, "6, 16");
		
		PositionPanel pos13 = new PositionPanel();
		positionPanelList.add(pos13);
		add(pos13, "6, 18");
		
		PositionPanel pos14 = new PositionPanel();
		positionPanelList.add(pos14);
		add(pos14, "6, 20");
		
		JButton btnGenerateSchedule = new JButton("Generate Schedule");
		btnGenerateSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateScheduleClicked();
			}
		});
		add(btnGenerateSchedule, "4, 22");
	
	}

	public List<PositionPanel> getPositionPanelList() {
		return positionPanelList;
	}
	
	private void generateScheduleClicked(){
		this.control.generateSchedule();
		
		for(PositionPanel panel : this.positionPanelList){
			panel.resetRemoveClicked();
		}
	}

	public void setControl(Control control) {
		this.control = control;
	}
	
	
	
	
	
}
