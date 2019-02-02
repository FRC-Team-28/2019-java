package frc.robot;

/*
 * This class just makes changing PID values easier
 * This is just saying where each device is plugged into the roboRIO
 */

public class PinConstants {
	
		//ANALOG
		public static final int GYRO_PIN = 1, ARM_POT = 2, ELEVATOR_SWITCH = 3;
		
		//CAN
		// public static final int FL_MOTOR = 2, FR_MOTOR = 3, BR_MOTOR = 4, BL_MOTOR = 1;

		public static final int FL_MOTOR = 3, FR_MOTOR = 1, BR_MOTOR = 2, BL_MOTOR = 0, WINCH_TALON = 4;

		
		//PWM 
		public static final int ARM = 1, VAC_MOTOR = 1, WINCH_SPARK = 0, ELEVATOR_MOTOR = 4;
		
		//DIO
		public static final int  VAC_SWITCH = 1, UP_LIM = 5, DOWN_LIM = 6; 
		
		
	
}
