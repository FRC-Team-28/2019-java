package frc.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.AnalogTrigger;



public class Elevator
{
        
    //This class makes it go like up or something 
    
    Controller controller;

    private Spark elevator = new Spark(PinConstants.ELEVATOR_MOTOR);
    private AnalogTrigger limit = new AnalogTrigger(PinConstants.ELEVATOR_SWITCH);        
    
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


    
}