package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Wrist {

    private TalonSRX wrist = new TalonSRX(PinConstants.WRIST_MOTOR);
    Controller controller1;

    public Wrist(Controller newController)
    {
        controller1 = new Controller();    
    }

    public double getWrist()
    {
        return controller1.getAxis("wrist");  
    }

    public void setWrist(double x)
    {
        wrist.set(ControlMode.PercentOutput, x);

    }

    public void update()
    {
        this.setWrist(this.getWrist());
    }
}