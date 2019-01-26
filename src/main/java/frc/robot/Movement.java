package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * This is the drive code
 */
public class Movement {
	
	private TalonSRX bL = new TalonSRX(PinConstants.BL_MOTOR);
	private TalonSRX bR = new TalonSRX(PinConstants.BR_MOTOR);
	private TalonSRX fL = new TalonSRX(PinConstants.FL_MOTOR);
	private TalonSRX fR = new TalonSRX(PinConstants.FR_MOTOR);
	private double forwardInput = 0;
	private double lateralInput = 0;
	private double rotaionInput = 0;
	
	Controller controller;
	Rotaion rotaion;

	public Movement (Controller newController, Rotaion newRotaion){
		controller = newController; //controller 1 used for driving
		rotaion = newRotaion; //object used for gyro stuff
	}
	
	/*
	 * get methods get what is supposed to be input into the motor controllers for each wheel from the controller
	 * combines multiple axes so that they can be used to drive forward, backward, right, left and rotate left and right.
	 * 
	 * set methods set the talon motor controllers to some double
	 */
	public double getFrontLeft(){
		if(-1 * (forwardInput - lateralInput - rotaion.update(rotaionInput)) > 0.3 || -1 * (forwardInput - lateralInput - rotaion.update(rotaionInput)) < -0.3)
			return -1 * (forwardInput - lateralInput - rotaion.update(rotaionInput)); 
		else
			return 0; 

	}
	
	public void setFrontLeft(double speed){
		fL.set(ControlMode.PercentOutput, speed);
	}
	
	public double getFrontRight(){
		if((forwardInput + lateralInput + rotaion.update(rotaionInput)) > 0.3 || (forwardInput + lateralInput + rotaion.update(rotaionInput)) < -0.3)
			return (forwardInput + lateralInput + rotaion.update(rotaionInput)); 
		else
			return 0; 
	}
	
	public void setFrontRight(double speed){
		fR.set(ControlMode.PercentOutput, speed);
	}
	
	public double getBackLeft(){
		if((-1 * (forwardInput + lateralInput - rotaion.update(rotaionInput)) > 0.3 || -1 * (forwardInput + lateralInput - rotaion.update(rotaionInput)) < -0.3))
			return -1 * (forwardInput + lateralInput - rotaion.update(rotaionInput));
		else
			return 0;
	}
	
	public void setBackLeft(double speed){
		bL.set(ControlMode.PercentOutput, speed);
	}
	
	public double getBackRight(){
		if((forwardInput - lateralInput + rotaion.update(rotaionInput)) > 0.3 || (forwardInput - lateralInput + rotaion.update(rotaionInput)) < -0.3)
			return (forwardInput - lateralInput + rotaion.update(rotaionInput));
		else
			return 0;
	}
	
	public void setBackRight(double speed){
		bR.set(ControlMode.PercentOutput, speed);
	}
	
	// sets all wheels to the same values
	public void setAll(double x)
	{
		setFrontLeft(x);
		setFrontRight(x);
		setBackLeft(x);
		setBackRight(x);
	}
	
	// sets only the right wheels to some value
	public void setRight(double x)
	{
		setFrontRight(x);
		setBackRight(x);
	}
	
	// sets only the left wheels to some value
	public void setLeft(double x)
	{
		setFrontLeft(x);
		setBackLeft(x);
	}
	
	// resets encoder distances
	public void resetEncoder()
 	{
 		bL.getSensorCollection().setQuadraturePosition(0, 0);
 		bR.getSensorCollection().setQuadraturePosition(0, 0);
 		fL.getSensorCollection().setQuadraturePosition(0, 0);
 		fR.getSensorCollection().setQuadraturePosition(0, 0);	
 	}
 	
	// these methods get encoder readings from each wheel so the distance traveled and the rate of each wheel is known
 	public double getFLEncDist()
 	{
 		return fL.getSensorCollection().getQuadraturePosition();
 	}
 	
 	public double getFREncDist()
 	{
 		return fR.getSensorCollection().getQuadraturePosition();
 	}
 	
 	public double getBLEncDist()
 	{
 		return bL.getSensorCollection().getQuadraturePosition();
 	}
 	
 	public double getBREncDist()
 	{
 		return bR.getSensorCollection().getQuadraturePosition();
 	}
 	
 	public double getFLEncRate()
 	{
 		return fL.getSensorCollection().getQuadratureVelocity();
 	}
 	
 	public double getFREncRate()
 	{
 		return fR.getSensorCollection().getQuadratureVelocity();
 	}
 	
 	public double getBLEncRate()
 	{
 		return bL.getSensorCollection().getQuadratureVelocity();
 	}
 	
 	public double getBREncRate()
 	{
 		return bR.getSensorCollection().getQuadratureVelocity();
 	}
 	
	
	// run during teleop
 	public void update(){
 		
 		rotaion.reset();
		 
		//added 
		forwardInput = controller.getAxis("forward");
		lateralInput = controller.getAxis("right");
		rotaionInput = controller.getAxis("turnRight");

 		this.setFrontRight(this.getFrontRight());
 		this.setFrontLeft(this.getFrontLeft());
 		this.setBackRight(this.getBackRight());
 		this.setBackLeft(this.getBackLeft());	
    	    	
 	}
 	
 	// run to display encoder values, input values and gyro values
 	public void display()
	{
		
		double FLEncoderDist = this.getFLEncDist();
    	double FREncoderDist = this.getFREncDist();
    	double BLEncoderDist = this.getBLEncDist();
    	double BREncoderDist = this.getBREncDist();
    	
    	SmartDashboard.putNumber("Front Left Encoder Distance", FLEncoderDist);
    	SmartDashboard.putNumber("Front Right Encoder Distance", FREncoderDist);
    	SmartDashboard.putNumber("Back Left Encoder Distance", BLEncoderDist);
    	SmartDashboard.putNumber("Back Right Encoder Distance", BREncoderDist);
    	
    	double FLEncoderRate = this.getFLEncRate();
    	double FREncoderRate = this.getFREncRate();
    	double BLEncoderRate = this.getBLEncRate();
    	double BREncoderRate = this.getBREncRate();
    	
    	SmartDashboard.putNumber("Front Left Encoder Rate", FLEncoderRate);
    	SmartDashboard.putNumber("Front Right Encoder Rate", FREncoderRate);
    	SmartDashboard.putNumber("Back Left Encoder Rate", BLEncoderRate);
    	SmartDashboard.putNumber("Back Right Encoder Rate", BREncoderRate);
    	
    	SmartDashboard.putNumber("Controller1 Y Axis Right", controller.getAxis("forward"));
    	SmartDashboard.putNumber("Controller1 X Axis Right", controller.getAxis("right"));
    	SmartDashboard.putNumber("Controller1 Trigger Axis", controller.getAxis("turnRight"));
    	
    	SmartDashboard.putNumber("FR Input", this.getFrontRight());
    	SmartDashboard.putNumber("FL Input", this.getFrontLeft());
    	SmartDashboard.putNumber("BR Input", this.getBackRight());
    	SmartDashboard.putNumber("BL Input", this.getBackLeft());
    	
    	
    	    	
    	rotaion.display();
    	
	}
	
	public void autonomousUpdate(double forward, double right, double turnRight){
		 
		rotaion.reset();

		forwardInput = forward;
		lateralInput = right;
		rotaionInput = turnRight;

 		
 		this.setFrontRight(this.getFrontRight());
 		this.setFrontLeft(this.getFrontLeft());
 		this.setBackRight(this.getBackRight());
 		this.setBackLeft(this.getBackLeft());	
	 }


	
	
	
}
