package frc.robot;


 import edu.wpi.first.wpilibj.AnalogPotentiometer;
 import edu.wpi.first.wpilibj.*;

public class ArmMovement {

	private AnalogPotentiometer analogPot = new AnalogPotentiometer(PinConstants.ARM_POT);
	private Controller controller2;
	private PID pid = new PID(0,0,0,0);
	private Spark motor = new Spark(PinConstants.ARM);
	
	//TODO tune PID and set starting position
	
	public ArmMovement(Controller c){
		controller2 = c;
	}
	
	public void setPosition(double position) {
		pid.setSetpoint(position);
	}
		
	
	public void update(){
		motor.set(pid.update(analogPot.get()));
	}
	
	
	
	
	
}
