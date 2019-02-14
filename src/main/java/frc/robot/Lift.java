package frc.robot;


 import edu.wpi.first.wpilibj.AnalogPotentiometer;
 import edu.wpi.first.wpilibj.*;
 import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Lift {

	private AnalogPotentiometer analogPot = new AnalogPotentiometer(PinConstants.ARM_POT);
	private Controller controller2;
	private PID pid = new PID(0,0,0,0,0);
	


	private TalonSRX motor1 = new TalonSRX(PinConstants.ARM_1);
	private TalonSRX motor2 = new TalonSRX(PinConstants.ARM_2);



	private double sped = 0.25;

	public boolean dshdsh = false;
	Movement move;
	
	//TODO tune PID and set starting position
	
	public ArmMovement(Controller c){
		controller2 = c;
	}
	
	public void setPosition(double position) {
		pid.setSetpoint(position);
	}
	
	public double getArm()
	{
			return controller2.getAxis("arm");
	}

	public void setArm(double x)
	{
		motor1.set(ControlMode.PercentOutput, x/4);
		motor2.set(ControlMode.PercentOutput, -x/4);
	}
	

	public void update(){
		this.setArm(this.getArm());		
	}
	
	
	
	
	
}
