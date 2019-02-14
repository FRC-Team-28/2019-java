// package frc.robot;

// import edu.wpi.first.wpilibj.Spark;
// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX;

// public class Winch

// {

//     Controller controller2;
        
//     private TalonSRX winchTalon = new TalonSRX(PinConstants.WINCH_TALON);

//     public Winch(Controller newController2)
//     {
//         controller2 = newController2;
//     }

//     //Sets Winch's Talon to X
//     public void setWinch(double x)
//     {
//         winchTalon.set(ControlMode.PercentOutput, x);
//     }

//     //Gets Controllers value to set to Talon
//     public double getWinch()
//     {
//         if(controller2.getAxis("winch") > 0.3)
//             return 0.6 * controller2.getAxis("winch");
//         else if(controller2.getAxis("winch") < -0.3)
//             return 0.4 * controller2.getAxis("winch");
//         else
//             return 0;
            
//         //return 0.3 * controller2.getAxis("winch");
//     }

//     //Updates Talon's value to that of the controller
//     public void update()
//     {
//         this.setWinch(this.getWinch());
//         System.out.println();
//     }

        
// }