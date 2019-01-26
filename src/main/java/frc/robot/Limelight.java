package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;


public class Limelight {

	
	Movement move;
	PID pid;
	
	
	public Limelight(Movement newMovement, PID newPID)
	{
		move = newMovement;
		pid = newPID;
	}
	
	NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
	NetworkTableEntry tx = table.getEntry("tx");
	NetworkTableEntry ty = table.getEntry("ty");
	NetworkTableEntry tv = table.getEntry("tv");
	NetworkTableEntry ta = table.getEntry("ta");
	
	

	

	
	public void display()
	{
		
	}
	

	double left;
	double right;
	
	public void seek()
	{
		double v = tv.getDouble(0.0);
		double x = tx.getDouble(0.0);
		
		double kP = 0.0;
		double kI = 0.0;
		double kD = 0.0;
		double setpoint = 0.0;
		
		
		
		

		double steering_adjust = 0.0f;
		if (v == 0.0f)
		{
		        // We don't see the target, seek for the target by spinning in place at a safe speed.
		        steering_adjust = 0.3f;
		}
		else
		{
		        steering_adjust = pid.update(setpoint);
		}

		left += steering_adjust;
		right -= steering_adjust;
	}
		
	
	
}
