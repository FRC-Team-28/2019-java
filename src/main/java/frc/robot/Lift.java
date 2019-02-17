package frc.robot;


import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


//THIS CONTROLS THE ARM!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class Lift {

	private AnalogPotentiometer analogPot = new AnalogPotentiometer(PinConstants.ARM_POT);
	private Controller controller2;
	private PID pid = new PID(0,0,0,0,0);
	


	private TalonSRX motor1 = new TalonSRX(PinConstants.LEFT_HAB_MOTOR);
	private TalonSRX motor2 = new TalonSRX(PinConstants.ARM_MOTOR);



	private double sped = 0.25;

	public boolean dshdsh = false;
	Movement move;
	
	//TODO tune PID and set starting position
	
	public Lift(Controller c)
	{
		controller2 = c;
	}
	
	public void setPosition(double position) 
	{
		pid.setSetpoint(position);
	}
	
	public double getArm()
	{
			return controller2.getAxis("arm");
	}

	public void setArm(double x)
	{
		motor1.set(ControlMode.PercentOutput, x/2);
		motor2.set(ControlMode.PercentOutput, -x/2);
	}

	
	

	public void update()
	{
		this.setArm(this.getArm());

	}
	
	
	
	
	
}
