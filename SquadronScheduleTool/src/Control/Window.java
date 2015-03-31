package Control;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

import View.SchedulePanel;

public class Window {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					SchedulePanel panel = new SchedulePanel();
					Control control = new Control();
					control.initControl(panel);
					control.initializeSchedule();
					
					window.frame.add(panel);
					window.frame.setMinimumSize(new Dimension(1200,350));
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
