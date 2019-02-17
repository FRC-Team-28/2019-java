package frc.robot;

/*
 * This class just makes changing PID values easier
 * This is just saying where each device is plugged into the roboRIO
 */

public class PinConstants {
	
		//ANALOG
		public static final int GYRO_PIN = 1, ARM_POT = 2, ELEVATOR_SWITCH = 3;
		
		//TALONS
		public static final int
		    LEFT_HAB_MOTOR = 0,
			VAC_MOTOR = 1,
			ARM_MOTOR = 2,
			RIGHT_HAB_MOTOR = 3,
			ELEVATOR_MOTOR = 4, 
			HAB_VACUUM_MOTOR = 5,
			WRIST_MOTOR = 6;


		
		//SPARK/PWM 
		public static final int FL_MOTOR = 3, FR_MOTOR = 2, BR_MOTOR = 0, BL_MOTOR = 1;
		

		//DIO
		public static final int FL_ENC_A = 0, FL_ENC_B = 1, FR_ENC_A = 2, FR_ENC_B = 3,
								BL_ENC_A = 4, BL_ENC_B = 5, BR_ENC_A = 6, BR_ENC_B = 7, 
		VAC_SWITCH = 10, 
		UP_LIM = 11, DOWN_LIM = 12; 




		//ELEVATOR PID

		public static final int TIMEOUT_MS = 30, PID_LOOP_IDX = 0, SLOT_IDX = 0;

		static final Gains Gains = new Gains(0.2, 0.0, 0.0, 0.2, 0, 1.0);
		
	
}
