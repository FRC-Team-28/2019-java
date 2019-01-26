package frc.robot;

import edu.wpi.first.wpilibj.*;

public class Zucc {
	
	private Controller controller;
	private DigitalInput vacSwitch = new DigitalInput(PinConstants.VAC_SWITCH);
	private Spark motor = new Spark(PinConstants.VAC_MOTOR);
	private boolean isZuccing = false;
	
	public Zucc(Controller newController)
	{
		controller = newController;
	}
	
	public void update()
	{
		doZucc();
	}
		
	public void doZucc(){
			if(controller.getButton("Zucc"))
			{
				isZuccing = true;
			}

			if(controller.getButton("UnZucc"))
			{
				motor.set(-1.0);
				isZuccing = false;
			}

			if(isZuccing)
			{
				motor.set(1.0);
				if(vacSwitch.get())
				{
					motor.set(.1);
				}
			}
			else
				motor.set(0);
	}



}
