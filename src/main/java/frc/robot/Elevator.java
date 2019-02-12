package frc.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.AnalogTrigger;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class Elevator
{
        
    //This class makes it go like up or something 
    
    Controller controller;

    private Spark elevator = new Spark(PinConstants.ELEVATOR_MOTOR);
    private AnalogTrigger limit = new AnalogTrigger(PinConstants.ELEVATOR_SWITCH); 
    private Encoder elev_Enc = new Encoder(PinConstants.ELEV_ENC_A, PinConstants.FR_ENC_B);
       
    
    public Elevator(Controller newController)
    {
        controller = newController;
    }
             public void update()
    {
        
        if (limit.getTriggerState() == false) 
        {
            this.setElevator(this.getElevator());
        }
        else   
            this.setElevator(0);
                                                                                   
    }   
    public double getElevator()
    {
        return controller.getAxis("elevator");
    }

    public void setElevator(double x)
    {
        elevator.set(x);
    }

    public void encReset()
    {
       elev_Enc.reset();
   }

   public double getElevEncDist()
   {
       return elev_Enc.getDistance();
   }
   
   public boolean getElevEncDirection()
     {
        return elev_Enc.getDirection();
     }

     public double getElevEncRate()
     {
         return elev_Enc.getRate();
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