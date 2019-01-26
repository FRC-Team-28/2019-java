package frc.robot;

import edu.wpi.first.wpilibj.Spark;

public class Winch
{

    Controller controller2;
        
private Spark winch = new Spark(PinConstants.WINCH);    

    public Winch(Controller newController2)
    {
        controller2 = newController2;
    }

    public void setWinch(double x)
    {
        winch.set(x);
    }

    public double getWinch()
    {
        return controller2.getAxis("winch");
    }

    public void update()
    {
        this.setWinch(this.getWinch());
    }

        
}