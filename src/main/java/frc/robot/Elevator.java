package frc.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.AnalogTrigger;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;





public class Elevator
{
        
    //This class makes it go like up or something 
    
    Controller controller;

    private AnalogTrigger limit = new AnalogTrigger(PinConstants.ELEVATOR_SWITCH); 
       
    private TalonSRX elevator = new TalonSRX(PinConstants.ELEVATOR_MOTOR);

    private int smoothing;


    public Elevator(Controller newController)
    {
        controller = newController;
        smoothing = 0;
    }
    
    public void init(){

        /* Factory default hardware to prevent unexpected behavior */
		elevator.configFactoryDefault();

		/* Configure Sensor Source for Pirmary PID */
		elevator.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,
											PinConstants.PID_LOOP_IDX, 
											PinConstants.TIMEOUT_MS);

		/**
		 * Configure Talon SRX Output and Sesnor direction accordingly
		 * Invert Motor to have green LEDs when driving Talon Forward / Requesting Postiive Output
		 * Phase sensor to have positive increment when driving Talon Forward (Green LED)
		 */
		elevator.setSensorPhase(true);
		elevator.setInverted(true);

		/* Set relevant frame periods to be at least as fast as periodic rate */
		elevator.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, PinConstants.TIMEOUT_MS);
		elevator.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, PinConstants.TIMEOUT_MS);

		/* Set the peak and nominal outputs */
		elevator.configNominalOutputForward(0, PinConstants.TIMEOUT_MS);
		elevator.configNominalOutputReverse(0, PinConstants.TIMEOUT_MS);
		elevator.configPeakOutputForward(1, PinConstants.TIMEOUT_MS);
		elevator.configPeakOutputReverse(-1, PinConstants.TIMEOUT_MS);

		/* Set Motion Magic gains in slot0 - see documentation */
		elevator.selectProfileSlot(PinConstants.SLOT_IDX, PinConstants.PID_LOOP_IDX);
		elevator.config_kF(PinConstants.SLOT_IDX, PinConstants.Gains.kF, PinConstants.TIMEOUT_MS);
		elevator.config_kP(PinConstants.SLOT_IDX, PinConstants.Gains.kP, PinConstants.TIMEOUT_MS);
		elevator.config_kI(PinConstants.SLOT_IDX, PinConstants.Gains.kI, PinConstants.TIMEOUT_MS);
		elevator.config_kD(PinConstants.SLOT_IDX, PinConstants.Gains.kD, PinConstants.TIMEOUT_MS);

		/* Set acceleration and vcruise velocity - see documentation */
		elevator.configMotionCruiseVelocity(15000, PinConstants.TIMEOUT_MS);
		elevator.configMotionAcceleration(6000, PinConstants.TIMEOUT_MS);

		/* Zero the sensor */
		elevator.setSelectedSensorPosition(0, PinConstants.PID_LOOP_IDX, PinConstants.TIMEOUT_MS);


    }


    public void update()
    {
        
        // if (limit.getTriggerState() == false) 
        // {
        //     this.setElevator(this.getElevator());
        // }
        // else   
        //     this.setElevator(0);

        //this.setElevator(this.getElevator());


        double leftYstick = -0.5 * controller.getAxis("elevator");
        if (Math.abs(leftYstick) < 0.10)
        {
            leftYstick = 0;
        } /* deadband 10% */

		/* Get current Talon SRX motor output */
        double motorOutput = elevator.getMotorOutputPercent();
        
        if (controller.getButton("motionMagic")) 
        {
			/* Motion Magic */ 
			
			/*4096 ticks/rev * 10 Rotations in either direction */
			double targetPos = 4096 * 0.5;
			elevator.set(ControlMode.MotionMagic, targetPos);
			
        } 
        else 
        {
			/* Percent Output */
			elevator.set(ControlMode.PercentOutput, leftYstick);
        }
        
                                                         
    }   
    public double getElevator()
    {
        return controller.getAxis("elevator");
    }

    public void setElevator(double x)
    {
        elevator.set(ControlMode.PercentOutput, x);
    }

    public void encReset()
    {
        elevator.getSensorCollection().setQuadraturePosition(0,0);
    }

   public double getElevEncDist()
   {
       return elevator.getSensorCollection().getQuadraturePosition();
   }
   
    public double getElevEncRate()
    {
        return elevator.getSensorCollection().getQuadratureVelocity();
    }
 
    
    public void Display()
    {
        SmartDashboard.putNumber("P", PinConstants.Gains.kP);
        SmartDashboard.putNumber("I", PinConstants.Gains.kI);
        SmartDashboard.putNumber("D", PinConstants.Gains.kD);
        SmartDashboard.putNumber("Elevator Encoder Distance", this.getElevEncDist());
    }

    


    
}