package frc.robot;

import java.util.*;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class Controller {
	
	private Map<String,Double> axisMap;
	private Map<String, Boolean> buttonMap;
	private XboxController Controller1;
	private XboxController Controller2;
	
	public Controller()
	{
		
		axisMap = new HashMap <>();
		buttonMap = new HashMap<>();
		Controller1 = new XboxController(0);
		Controller2 = new XboxController(1);
		update();
		
	}
	
	/* This method runs during teleop.
	 * It gives names to the inputs from each controller such as "forward"
	 * These can be used in the get methods
	 */
	public void update()
	{

		axisMap.put("forward", Controller1.getY(GenericHID.Hand.kLeft)); 
		axisMap.put("right", Controller1.getX(GenericHID.Hand.kLeft));
		axisMap.put("turnRight", Controller1.getTriggerAxis(GenericHID.Hand.kRight) - (Controller1.getTriggerAxis(GenericHID.Hand.kLeft)));
		buttonMap.put("Zucc", Controller1.getAButtonPressed());
		buttonMap.put("partialZucc", Controller1.getBButtonPressed());
		buttonMap.put("StopLiftMotor", Controller1.getYButtonPressed());
		axisMap.put("arm", Controller2.getY(GenericHID.Hand.kLeft)); 
		axisMap.put("elevator", Controller2.getY(GenericHID.Hand.kRight)); 
		//buttonMap.put("chase", Controller1.getAButton());
		//buttonMap.put("light", Controller2.getYButton());
		//buttonMap.put("blink", Controller2.getXButton());
		//buttonMap.put("stopLime", Controller2.getAButton());
		//buttonMap.put("limelight Test", Controller1.getBButton());
		//  axisMap.put("wrist", Controller1.getY(GenericHID.Hand.kRight));

		axisMap.put("wrist", Controller2.getTriggerAxis(GenericHID.Hand.kRight) - (Controller2.getTriggerAxis(GenericHID.Hand.kLeft)));

		buttonMap.put("motionMagic", Controller2.getXButton());
		// buttonMap.put("increaseSmoothing", Controller2.getBumper(GenericHID.Hand.kRight));
		// buttonMap.put("decreaseSmoothing", Controller2.getBumper(GenericHID.Hand.kLeft));
		buttonMap.put("hold", Controller2.getAButton());

		buttonMap.put("stopArm", Controller2.getBButton());


		buttonMap.put("GigaZucc", Controller1.getXButton());

		// buttonMap.put("LiftUp", Controller2.getBumper(GenericHID.Hand.kRight));
		// buttonMap.put("LiftDown", Controller2.getBumper(GenericHID.Hand.kLeft));

		axisMap.put("lift", Controller1.getY(GenericHID.Hand.kRight)); 

		

		



	}
	
	/* These next methods are used in other classes to get the input values from the controllers
	 * 
	 */
	
	//Returns Axis value of Controller
	public double getAxis(String name)
	{
		return axisMap.get(name);
	}
	
	//Returns the state of a button
	public boolean getButton(String name)
	{
		return buttonMap.get(name);
	}

	

	




	
}


 
