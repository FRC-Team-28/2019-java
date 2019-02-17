package frc.robot;

import edu.wpi.first.wpilibj.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Zucc {
	
	private Controller controller;
	private DigitalInput vacSwitch = new DigitalInput(PinConstants.VAC_SWITCH);
	private TalonSRX motor = new TalonSRX(PinConstants.VAC_MOTOR);

	private boolean isZuccing = false;
	public Zucc(Controller newController)
	{
		controller = newController;
	}
	
	public void update()
	{
		if(controller.getButton("Zucc"))
			{
				isZuccing = true;
			}

		if(controller.getButton("UnZucc"))
		{

			isZuccing = false;
		}

			if(isZuccing)
			{
				motor.set(ControlMode.PercentOutput, -1);
			}
			else
				motor.set(ControlMode.PercentOutput, 0);
	}

}
