
package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/* This is our main or robot class. 
 * 
 */


public class Robot extends IterativeRobot 
{
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	boolean dshdsh = true;

	Controller controller1;
	Controller controller2;
	Rotaion rotaion;
	// Movement move;
	SparkMovement sparkMovement;
	Lift arm;
	//Winch winch;
	Elevator e;
	// Lime`ight lime; 
	Vision vis;
	Wrist wrist;
	
	/* This is the method that runs right as the code runs on the robot.
	 * This is where we construct our objects
	 */
	@Override
	public void robotInit() 
	{
		m_chooser.addDefault("Default Auto", kDefaultAuto); 
		m_chooser.addObject("My Auto", kCustomAuto);
		SmartDashboard.putData("Auto choices", m_chooser);
		
		controller1 = new Controller(); // object for the driver controller
		controller2 = new Controller();
		rotaion = new Rotaion(); // object for rotaion class
		// move = new Movement(controller1, rotaion); // movement object for drive code
		//winch = new Winch(controller2); //WINCH time 
		e = new Elevator(controller2);
		vis = new Vision();
		//lime = new Limelight(move, controller2, vis);
		sparkMovement = new SparkMovement(controller1, rotaion);
		arm = new Lift(controller2);
		wrist = new Wrist(controller1);
		
		
	}

	/* This runs once as soon as auto starts 
	 */
	@Override
	public void autonomousInit() 
	{
		m_autoSelected = m_chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);
	//	move.resetEncoder();
	}

	/* This runs in a loop while in auto
	 */
	@Override
	public void autonomousPeriodic() 
	{
		switch (m_autoSelected) 
		{
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
	public void teleopInit() 
	{
		rotaion.gyroReset();
		//move.resetEncoder();
	}
	
	/* Runs in a loop during teleop
	 */
	@Override
	public void teleopPeriodic() 
	{
		
		controller1.update();
		controller2.update();

		arm.update();
		
		// move.display();
		// move.update();-
		
		sparkMovement.update();
		
		e.update();	
		
		arm.update();
		//lime.update();

		wrist.update();
		

		



			
	}
}


