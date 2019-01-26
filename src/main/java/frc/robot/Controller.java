package frc.robot;

import java.util.*;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

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
		buttonMap.put("Zucc", Controller2.getAButton());
		buttonMap.put("UnZucc", Controller2.getBButton());

	}
	
	/* These next methods are used in other classes to get the input values from the controllers
	 * 
	 */
	
	public double getAxis(String name)
	{
		return axisMap.get(name);
	}
	
	public boolean getButton(String name)
	{
		return buttonMap.get(name);
	}
	
}
 
