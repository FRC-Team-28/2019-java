package frc.robot;


 import edu.wpi.first.wpilibj.AnalogPotentiometer;
 import edu.wpi.first.wpilibj.*;

public class ArmMovement {

	private AnalogPotentiometer analogPot = new AnalogPotentiometer(PinConstants.ARM_POT);
	private Controller controller2;
	private PID pid = new PID(0,0,0,0,0);
	private Spark motor1 = new Spark(PinConstants.ARM_1);
	private Spark motor2 = new Spark(PinConstants.ARM_2);
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
			return controller2.getAxis("winch");
	}

	public void setArm(double x)
	{
		motor1.set(x * sped);
		motor2.set(-x * sped);
	}
	

	public void update(){
		setArm(getArm());		
	}
	
	
	
	
	
}
