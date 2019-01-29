package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Vision {

        
    NetworkTable table;
    NetworkTableEntry entry;
    double ledMode;

    public Vision()
    {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        entry = table.getEntry("ledMode");
        ledMode = entry.getDouble(0);
    }

    public double getLEDMode()
	{
        return entry.getDouble(0);
    }

    public void setLEDMode(double m)
	{
        entry.setDouble(m);
    }

    public void update()
	{
        SmartDashboard.putNumber("LED Mode = ", this.getLEDMode());
    }
} 
