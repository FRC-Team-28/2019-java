package frc.robot;


import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


//THIS CONTROLS THE ARM!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! very observant
public class Arm {

	private AnalogPotentiometer analogPot = new AnalogPotentiometer(PinConstants.ARM_POT);
	private Controller controller2;
	


	private TalonSRX motor1 = new TalonSRX(PinConstants.RIGHT_ARM_MOTOR);
	private TalonSRX motor2 = new TalonSRX(PinConstants.LEFT_ARM_MOTOR);



	public boolean dshdsh = false;
	Movement move;
	
	//TODO tune PID and set starting position
	
	public Arm(Controller c)
	{
		controller2 = c;
	}
	
	
	public double getArm()
	{
			return controller2.getAxis("arm");
	}

	public void setArm(double x)
	{

		if(controller2.getButton("stopArm"))
		{
			motor1.set(ControlMode.PercentOutput, 0);
			motor2.set(ControlMode.PercentOutput, 0);
		}
		
		else
		{
			motor1.set(ControlMode.PercentOutput, (-0.25 * x) + 0.15 );
			motor2.set(ControlMode.PercentOutput, (0.25 * x) - 0.15);
		}

		
	}

	public void update()
	{	
			this.setArm(Math.pow(this.getArm(), 3));
	}
	
	
	
	
	
}
