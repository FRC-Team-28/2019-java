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
		

		public static final int  ELEV_TALON = 4, ARM_1 = 1, ARM_2 = 2, WRIST = 0;


		
		//PWM 
		public static final int FL_MOTOR = 3, FR_MOTOR = 2, BR_MOTOR = 0, BL_MOTOR = 1, VAC_MOTOR = 4;
		

		//DIO
		public static final int FL_ENC_A = 0, FL_ENC_B = 1, FR_ENC_A = 2, FR_ENC_B = 3,
								BL_ENC_A = 4, BL_ENC_B = 5, BR_ENC_A = 6, BR_ENC_B = 7, 
		VAC_SWITCH = 10, 
		UP_LIM = 11, DOWN_LIM = 12; 
		
	
}
