package frc.robot;

/*
 * This class just makes changing PID values easier
 * This is just saying where each device is plugged into the roboRIO
 */

public class PinConstants {
	
		//ANALOG
		public static final int GYRO_PIN = 1, ARM_POT = 2;
		
		//CAN
		public static final int FL_MOTOR = 3, FR_MOTOR = 4, BR_MOTOR = 2, BL_MOTOR = 1;
		
		//PWM 
		public static final int ARM = 1, VAC_MOTOR = 1;
		
		//DIO
		public static final int  VAC_SWITCH = 1, UP_LIM = 5, DOWN_LIM = 6; 
		
		
	
}
