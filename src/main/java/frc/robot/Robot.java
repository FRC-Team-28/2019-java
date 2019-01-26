
package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/* This is our main or robot class. 
 * 
 */

//this is a test

public class Robot extends IterativeRobot {
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	
	Controller controller1;
	Rotaion rotaion;
	Movement move;
	ArmMovement arm;

	/* This is the method that runs right as the code runs on the robot.
	 * This is where we construct our objects
	 */
	@Override
	public void robotInit() {
		m_chooser.addDefault("Default Auto", kDefaultAuto); 
		m_chooser.addObject("My Auto", kCustomAuto);
		SmartDashboard.putData("Auto choices", m_chooser);
		
		controller1 = new Controller(); // object for the driver controller
		rotaion = new Rotaion(); // object for rotaion class
		move = new Movement(controller1, rotaion); // movement object for drive code
		
		
	}

	/* This runs once as soon as auto starts 
	 */
	@Override
	public void autonomousInit() {
		m_autoSelected = m_chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);
		move.resetEncoder();
	}

	/* This runs in a loop while in auto
	 */
	@Override
	public void autonomousPeriodic() {
		switch (m_autoSelected) {
			case kCustomAuto:
				// Put custom auto code here
				break;
			case kDefaultAuto:
			default:
				// Put default auto code here
				break;
		}
	}

	/* Runs as soon as teleop starts
	 */
	@Override
	public void teleopInit() {
		
		System.out.println("YEETED");

		rotaion.gyroReset();
		move.resetEncoder();
	}
	
	/* Runs in a loop during teleop
	 */
	@Override
	public void teleopPeriodic() {
		
		controller1.update();
		move.update();
		move.display();
		// arm.update();
		
		
	}

}
