package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * This class uses a PID function to correct gyro error
 * It is experimental right now and it might need some work
 * (not entirely sure how it works)osmosis
 */

public class PID {
	double kP;
	double kI;
	double kD;
	double kF;
	double setpoint;
	double integral = 0.0;
	double derivitive = 0.0;
	double prevError = 0.0;
	double error = 0.0;
	
	public PID(double kP, double kI, double kD, double kF, double setpoint) {
		this.kP = kP;
		this.kI = kI;
		this.kD = kD;
		this.kF = kF;
		this.setpoint = setpoint;
	
		SmartDashboard.putNumber("kP", kP);
		SmartDashboard.putNumber("kI", kI);
		SmartDashboard.putNumber("kD", kD);
		SmartDashboard.putNumber("kF", kF);
		// epic gays only LOL XD
	}
	
	public double getSetpoint() {
		return setpoint;
	}
	
	public void setSetpoint(double setpoint) {
		this.setpoint = setpoint;
	}
	
	public double update(double processVariable) {
		
		prevError = error;
		error = setpoint - processVariable;
		integral += error*(0.02);
		
		kF = SmartDashboard.getNumber("kF", kF);
		kP = SmartDashboard.getNumber("kP", kP);
		kI = SmartDashboard.getNumber("kI", kI);
		kD = SmartDashboard.getNumber("kD", kD);
		

		return kP * error + kI * integral + kD * (error - prevError);
	}

	
	
}

  