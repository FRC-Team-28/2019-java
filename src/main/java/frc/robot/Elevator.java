package frc.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.AnalogTrigger;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;




public class Elevator
{
        
    //This class makes it go like up or something 
    
    Controller controller;

    private AnalogTrigger limit = new AnalogTrigger(PinConstants.ELEVATOR_SWITCH); 
       
    private TalonSRX elevator = new TalonSRX(PinConstants.ELEV_TALON);

    
    public Elevator(Controller newController)
    {
        controller = newController;
    }
    
    public void update()
    {
        
        // if (limit.getTriggerState() == false) 
        // {
        //     this.setElevator(this.getElevator());
        // }
        // else   
        //     this.setElevator(0);

        this.setElevator(this.getElevator());
                                                                                   
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
            double ElevEncDist = this.getElevEncDist();
            SmartDashboard.putNumber("Elevator Encoder Dist", ElevEncDist);

            double ElevEncRate = this.getElevEncRate();
            SmartDashboard.putNumber("Elevator Encoder Rate", ElevEncRate);

            SmartDashboard.putNumber("", controller.getAxis(""));
            SmartDashboard.putNumber("Elevator Input", this.getElevator());
    }

    


    
}