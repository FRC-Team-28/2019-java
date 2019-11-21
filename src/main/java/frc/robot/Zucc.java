package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Zucc {

	private Controller controller;
	private DigitalInput vacSwitch = new DigitalInput(PinConstants.VAC_SWITCH);
	private TalonSRX motor = new TalonSRX(PinConstants.VAC_MOTOR);

	private boolean isZuccing = false;
	private boolean partialZucc = false;
	public Zucc(Controller newController)
	{
		controller = newController;
	}

	public void setZucc(boolean zucc)
	{
		isZuccing = zucc;
	}

	public void update()
	{

		if(controller.getButton("Zucc") && !isZuccing)
		{
			isZuccing = true;
			partialZucc = false;
		}
		else if(controller.getButton("Zucc") && isZuccing)
		{
			isZuccing = false;
		}

		if(controller.getButton("partialZucc") && !partialZucc)
		{
			partialZucc = true;
			isZuccing = false;
		}
		else if(controller.getButton("partialZucc") && partialZucc)
		{
			partialZucc = false;
		}

		if(isZuccing)
		{
			motor.set(ControlMode.PercentOutput, -1);
			SmartDashboard.putBoolean("Big Zucc", true);
			SmartDashboard.putBoolean("Partial Zucc", false);
			SmartDashboard.putBoolean("No Zucc", false);


		}
		else if(partialZucc)
		{
			motor.set(ControlMode.PercentOutput, -0.65);
			SmartDashboard.putBoolean("Big Zucc", false);
			SmartDashboard.putBoolean("Partial Zucc", true);
			SmartDashboard.putBoolean("No Zucc", false);

		}
		else
		{
			motor.set(ControlMode.PercentOutput, 0);
			SmartDashboard.putBoolean("Big Zucc", false);
			SmartDashboard.putBoolean("Partial Zucc", false);
			SmartDashboard.putBoolean("No Zucc", true);

		}

	}
}
