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
		public static final int VAC_MOTOR = 1, WINCH_SPARK = 0, ELEVATOR_MOTOR = 4, ARM_1 = 5, ARM_2 = 6;
		
		//DIO
		public static final int FL_ENC_A = 0, FL_ENC_B = 1, FR_ENC_A = 2, FR_ENC_B = 3,
								BL_ENC_A = 4, BL_ENC_B = 5, BR_ENC_A = 6, BR_ENC_B = 7,
								ELEV_ENC_A = 8, ELEV_ENC_B = 9, 
		VAC_SWITCH = 10, 
		UP_LIM = 11, DOWN_LIM = 12; 
		
	
}
