package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

/*
 * This class uses the gyro to correct natural error that the wheels cause
 */

public class Rotaion{

	private double header;
	private PID pid;
	private ADXRS450_Gyro gyro;
	
	
	public Rotaion(){
		gyro = new ADXRS450_Gyro();
		header = gyro.getAngle();
		pid = new PID(0, 0, 0, gyro.getAngle());
	}
	
	/*
	 * resets the header to the current gyro angle
	 */
	public void reset(){
		header = gyro.getAngle(); 
	}
	
	/*
	 * resets the gyro to 0
	 */
	public void gyroReset()
	{
		gyro.reset();
	}
	
	/*
	 * calibrates the gyro
	 */
	public void gyroCalibrate()
	{
		gyro.calibrate();
	}
	
	/*
	 * returns the gyro angle
	 */
	public double getGyro()
	{
		return Math.abs(gyro.getAngle() % 360);
	}
	
	/*
	 * displays gyro stuff
	 */
	public void display()
	{
		SmartDashboard.putNumber("gyroAngle", gyro.getAngle());
		
		SmartDashboard.putNumber("Gyro", Math.abs(gyro.getAngle() % 360));
		
		SmartDashboard.putNumber("Header", header);

	}
	
	public double update(double turnRight){
//		SmartDashboard.putNumber("gyroAngle", gyro.getAngle());
//		
//		SmartDashboard.putNumber("Gyro", Math.abs(gyro.getAngle() % 360));
		
		if (turnRight == 0) {
			
			try{
				return pid.update((header - gyro.getAngle()) % 180);
			} catch(Exception e){
				e.printStackTrace();
				return 0;
			}
			
		} else {
			return turnRight;
		}
		
	}
	
	public static double DiffAngle(int current, int target){
		return Math.floorMod(target - current + 180, 360)-180;
	}
}

