
package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CameraServer;



import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
// import edu.wpi.first.wpilibj.DigitalInput;
/* This is our main or robot class. 
 *  Up to date as of 3/8/19
 */

public class Robot extends IterativeRobot {
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	boolean dshdsh = true;

	Controller controller1;
	Controller controller2;
	Rotaion rotaion;
	SparkMovement sparkMovement;
	Arm arm;
	Elevator e;
	Vision vis;
	Lift lift;
	//Wrist wrist;
	Zucc zucc;
	boolean isZuccing;

	private TalonSRX wrist = new TalonSRX(PinConstants.WRIST_MOTOR);

	/*
	 * This is the method that runs right as the code runs on the robot. This is
	 * where we construct our objects
	 */
	@Override
	public void robotInit() {
		m_chooser.addDefault("Default Auto", kDefaultAuto);
		m_chooser.addObject("My Auto", kCustomAuto);
		SmartDashboard.putData("Auto choices", m_chooser);

		controller1 = new Controller(); // object for the driver controller
		controller2 = new Controller();
		rotaion = new Rotaion(); // object for rotaion class
		// move = new Movement(controller1, rotaion); // movement object for drive code
		// winch = new Winch(controller2); //WINCH time
		e = new Elevator(controller2);
		vis = new Vision();
		lift = new Lift(controller1, controller2);
		// lime = new Limelight(move, controller2, vis);
		sparkMovement = new SparkMovement(controller1, rotaion);
		arm = new Arm(controller2);
		// wrist = new Wrist(controller1);
		zucc = new Zucc(controller1);
		CameraServer.getInstance().startAutomaticCapture(); 
		isZuccing = false;
		e.init();
		// smoothing = 0;

	}

	/*
	 * This runs once as soon as auto starts
	 */
	@Override
	public void autonomousInit() {
		m_autoSelected = m_chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);
		// move.resetEncoder();
		// zucc.setZucc(true); //EXPERIMENTAL
	}

	/*
	 * This runs in a loop while in auto
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
			controller1.update();
			controller2.update();

			arm.update();

			sparkMovement.update(1);

			zucc.update();
			e.update();

			doWrist();
			lift.update();
			e.Display();
			break;
		}
	}

	/*
	 * Runs as soon as teleop starts
	 */
	@Override
	public void teleopInit() {
		rotaion.gyroReset();

		// move.resetEncoder();
	}

	/*
	 * Runs in a loop during teleop
	 */
	@Override
	public void teleopPeriodic() {

		controller1.update();
		controller2.update();

		arm.update();
		// move.display();
		// move.update();

		sparkMovement.update(1);

		zucc.update();
		e.update();
		// lime.update();

		doWrist();
		lift.update();
		e.Display();
	}

	public void doWrist()
	{
		wrist.set(ControlMode.PercentOutput, controller2.getAxis("wrist") / 2);
	}

}
