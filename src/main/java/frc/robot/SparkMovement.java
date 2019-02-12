package frc.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Encoder;

public class SparkMovement{
/*
    private Spark bL = new Spark(PinConstants.BL_MOTOR);
	private Spark bR = new Spark(PinConstants.BR_MOTOR);
	private Spark fL = new Spark(PinConstants.FL_MOTOR);
    private Spark fR = new Spark(PinConstants.FR_MOTOR);

    private double forwardInput = 0;
	private double lateralInput = 0;
    private double rotaionInput = 0;    
    
    Controller controller;
    boolean useThresh;
    Rotaion rotaion;
 
    private Encoder fL_Enc = new Encoder(PinConstants.FL_ENC_A, PinConstants.FR_ENC_B);
    private Encoder fR_Enc = new Encoder(PinConstants.FR_ENC_A, PinConstants.FR_ENC_B);
    private Encoder bL_Enc = new Encoder(PinConstants.BL_ENC_A, PinConstants.BL_ENC_B);
    private Encoder bR_Enc = new Encoder(PinConstants.BR_ENC_A, PinConstants.BR_ENC_B);

	private double thresh = 0.3;

    public SparkMovement (Controller newController, Rotaion newRotaion){
		controller = newController; //controller 1 used for driving
		rotaion = newRotaion; //object used for gyro stuff
    }
    
    public double getFrontLeft(){
		if(useThresh)
		{
			if(-1 * (forwardInput - lateralInput - rotaion.update(rotaionInput)) > thresh || -1 * (forwardInput - lateralInput - rotaion.update(rotaionInput)) < -thresh)
				return -1 * (forwardInput - lateralInput - rotaion.update(rotaionInput)); 
			else
				return 0; 
		}
		else
			return -1 * (forwardInput - lateralInput - rotaion.update(rotaionInput)); 

    }
	
	public void setFrontLeft(double speed){
		fL.set(speed);
	}
	
	public double getFrontRight(){
		
		if(useThresh)
		{
			if((forwardInput + lateralInput + rotaion.update(rotaionInput)) > thresh || (forwardInput + lateralInput + rotaion.update(rotaionInput)) < -thresh)
				return (forwardInput + lateralInput + rotaion.update(rotaionInput)); 
			else
				return 0; 
		}
		else
			return (forwardInput + lateralInput + rotaion.update(rotaionInput)); 


	}
    
    public void setFrontRight(double speed){
		fR.set(speed);
	}
	
	public double getBackLeft(){
		if(useThresh)
		{
			if((-1 * (forwardInput + lateralInput - rotaion.update(rotaionInput)) > thresh || -1 * (forwardInput + lateralInput - rotaion.update(rotaionInput)) < -thresh))
				return -1 * (forwardInput + lateralInput - rotaion.update(rotaionInput));
			else
				return 0;
		}
		else
		{
			return -1 * (forwardInput + lateralInput - rotaion.update(rotaionInput));
		}
		
	}
	
	public void setBackLeft(double speed){
		bL.set(speed);
	}
	
	public double getBackRight(){
		if(useThresh)
		{	
			if((forwardInput - lateralInput + rotaion.update(rotaionInput)) > thresh || (forwardInput - lateralInput + rotaion.update(rotaionInput)) < -thresh)
				return (forwardInput - lateralInput + rotaion.update(rotaionInput));
			else
				return 0;
		}
		else
			return (forwardInput - lateralInput + rotaion.update(rotaionInput));


	}
	
	public void setBackRight(double speed){
		bR.set(speed);
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
    
    public void encReset()
 	{
        fL_Enc.reset();
        fR_Enc.reset();
        bL_Enc.reset();
        bR_Enc.reset();
    }
     
     public double getFLEncDist()
 	{
 		return fL_Enc.getDistance();
     }
     
     public double getFREncDist()
 	{
 		return fR_Enc.getDistance();
     }
     
     public double getBLEncDist()
 	{
 		return bL_Enc.getDistance();
     }
     
     public double getBREncDist()
 	{
 		return bR_Enc.getDistance();
     }
     
    
     public boolean getFLEncDirection()
     {
        return fL_Enc.getDirection();
     }

     public boolean getFREncDirection()
     {
        return fR_Enc.getDirection();
     }

     public boolean getBLEncDirection()
     {
        return bL_Enc.getDirection();
     }

     public boolean getBREncDirection()
     {
        return bR_Enc.getDirection();
     }

    public double getFLEncRate()
    {
        return fL_Enc.getRate();
    }

    public double getFREncRate()
    {
        return fR_Enc.getRate();
    }

    public double getBLEncRate()
    {
        return bL_Enc.getRate();
    }

    public double getBREncRate()
    {
        return bR_Enc.getRate();
    }

    public void display(){
        
        double FLEncoderDist = this.getFLEncDist();
    	double FREncoderDist = this.getFREncDist();
    	double BLEncoderDist = this.getBLEncDist();
    	double BREncoderDist = this.getBREncDist();

    	SmartDashboard.putNumber("Front Left Encoder Dist", FLEncoderDist);
    	SmartDashboard.putNumber("Front Right Encoder Dist", FREncoderDist);
    	SmartDashboard.putNumber("Back Left Encoder Dist", BLEncoderDist);
    	SmartDashboard.putNumber("Back Right Encoder Dist", BREncoderDist);
    	
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

 	public void update()
 {

 }



*/
}


