package frc.robot;


import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.NeutralMode;


public class Lift {

	private Controller controller1;
    private Controller controller2;



	private TalonSRX liftMotor1 = new TalonSRX(PinConstants.HAB_MOTOR_1); //right 1
	private TalonSRX liftMotor2 = new TalonSRX(PinConstants.HAB_MOTOR_2); //right 2
	private TalonSRX liftMotor3 = new TalonSRX(PinConstants.HAB_MOTOR_3); //left 1
	private TalonSRX liftMotor4 = new TalonSRX(PinConstants.HAB_MOTOR_4); //left 2
    
    private Spark vac = new Spark(PinConstants.HAB_VAC_MOTOR);

    private boolean succ = false;
    private boolean stopMotor = false;


	
	//TODO tune PID and set starting position
	
	public Lift(Controller newController1, Controller newController2)
	{
        controller1 = newController1;

        controller2 = newController2;
	}
	
	
    public double getLift()
    {
        return controller1.getAxis("lift");
    }

	public void setLift(double x)
	{
       
        liftMotor1.set(ControlMode.PercentOutput, x/2);
        liftMotor2.set(ControlMode.PercentOutput, x/2);
        liftMotor3.set(ControlMode.PercentOutput, x/2);
        liftMotor4.set(ControlMode.PercentOutput, x/2);
        
      
      
        // if(controller2.getButton("LiftUp"))
        // {
        //     liftMotor1.set(ControlMode.PercentOutput, x);
        //     liftMotor2.set(ControlMode.PercentOutput, x);
        //     liftMotor3.set(ControlMode.PercentOutput, x);
        //     liftMotor4.set(ControlMode.PercentOutput, x);
        // }
        // else if(controller2.getButton("LiftDown"))
        // {
        //     liftMotor1.set(ControlMode.PercentOutput, -x);
        //     // liftMotor2.set(ControlMode.PercentOutput, -x);
        //     // liftMotor3.set(ControlMode.PercentOutput, -x);
        //     // liftMotor4.set(ControlMode.PercentOutput, -x);
        // }


	}

	
	

	public void update()
	{
        this.setLift(this.getLift());
        
        if(controller1.getButton("GigaZucc") && !succ)
		{
			succ = true;
		}
		else if(controller1.getButton("GigaZucc") && succ)
		{
			succ = false;
		}

        if(succ)
		{
			vac.set(-1);
        }
        else
		{
			vac.set(0);
		}
			
        SmartDashboard.putBoolean("GigaZucc", succ);


        //Stops motors from walking backwards after lifting above platform
        if(controller1.getButton("StopLiftMotor") && !stopMotor)
        {
            stopMotor = true;
            liftMotor1.setNeutralMode(NeutralMode.Brake);
            liftMotor2.setNeutralMode(NeutralMode.Brake);
            liftMotor3.setNeutralMode(NeutralMode.Brake);
            liftMotor4.setNeutralMode(NeutralMode.Brake);
        }
        else if(controller1.getButton("StopLiftMotor") && stopMotor)
        {
            stopMotor = false;
            liftMotor1.setNeutralMode(NeutralMode.Coast);
            liftMotor2.setNeutralMode(NeutralMode.Coast);
            liftMotor3.setNeutralMode(NeutralMode.Coast);
            liftMotor4.setNeutralMode(NeutralMode.Coast);
        }
        else
            return;

        SmartDashboard.putBoolean("StopLift", stopMotor);

	}
	
    
    
}
