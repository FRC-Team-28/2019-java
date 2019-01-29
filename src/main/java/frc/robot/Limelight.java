package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;


public class Limelight {

	Controller controller2;
	Movement move;
	PID rotationPID;
	PID leftRightPID;
	PID distancePID;
	NetworkTable table;
	NetworkTableEntry tv;
	NetworkTableEntry ts;
	NetworkTableEntry tx;
	NetworkTableEntry ta;
	NetworkTableEntry ledMode;
	boolean limelightSwitch = false;
	Vision light; 
	boolean toggle;
	
	
	
	public Limelight(Movement newMovement, Controller newController, Vision newVision)
	{
		toggle = false;
		controller2 = newController;
		move = newMovement;
		light = newVision;
		rotationPID = new PID(
			SmartDashboard.getNumber("rotation_P", 0),
			SmartDashboard.getNumber("rotation_I", 0),
			SmartDashboard.getNumber("rotation_D", 0),
			SmartDashboard.getNumber("rotation_SetPoint", 0)
			);

			
		leftRightPID = new PID(
			SmartDashboard.getNumber("leftRight_P", 0),
			SmartDashboard.getNumber("leftRight_I", 0),
			SmartDashboard.getNumber("leftRight_D", 0),
			SmartDashboard.getNumber("leftRight_SetPoint", 0)
			);
		distancePID = new PID(
			SmartDashboard.getNumber("distance_P", 0),
			SmartDashboard.getNumber("distance_I", 0),
			SmartDashboard.getNumber("distance_D", 0),
			SmartDashboard.getNumber("distance_SetPoint", 0)
			);
		
		table = NetworkTableInstance.getDefault().getTable("limelight");
		tx = table.getEntry("tx");
		tv = table.getEntry("tv");
		ta = table.getEntry("ta");
		ledMode = table.getEntry("ledMode");

	}

	//This is the method used to chase a target.
	public void chase()
	{
		if (tv.getDouble(0) == 1){
			//added this method to movement so that we can use it autonomously more easily
			
			 move.autonomousUpdate(
			 		distancePID.update(ta.getDouble(distancePID.getSetpoint())),
			 		leftRightPID.update(tx.getDouble(leftRightPID.getSetpoint())),
			 		rotationPID.update(ts.getDouble(rotationPID.getSetpoint()))
			);

			move.autonomousUpdate(0, 0, -0.31);

		}
		else {
			move.autonomousUpdate(0, 0, 0.31); //Just spin slowly until we find a target
		}

	}
	
	public void blink()
	{
		ledMode.setDouble(2);
	}

	public void update()
	{
		if(tv.getDouble(4) == 1)
			System.out.println("TARGET DETECTED!!");
		else if( tv.getDouble(4) == 4)
			System.out.println("NO NETWORK TABLE");
		else if (tv.getDouble(4) == 0)
		{
			System.out.println("TARGET NOT FOUND");

		}
		

	}

	public void display()
	{
		SmartDashboard.putNumber("tv", tv.getDouble(4));
		SmartDashboard.putNumber("tx", tx.getDouble(0));
		SmartDashboard.putNumber("ts", ts.getDouble(0));
		SmartDashboard.putNumber("ta", ta.getDouble(0));
		
	}

	public void SwitchLimelight()
	{
		if(toggle)
		{
			light.setLEDMode(3);						
		}
		else
		{
			light.setLEDMode(1);					
		}
		if (controller2.getButton("light"))
		{
			toggle = !toggle;
		}
	}	
	
		
}