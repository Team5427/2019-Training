package org.usfirst.frc.team5427.robot.subsystems;

//import org.usfirst.frc.team5427.util.SameLine;

import edu.wpi.first.wpilibj.SpeedController;
public class Elevator {
	
	private SpeedController leftElevatorMotor;
	private SpeedController rightElevtorMotor;
	
	public Elevator(SpeedController leftElevatorMotor, SpeedController rightElevatorMotor)
	{
		this.leftElevatorMotor = leftElevatorMotor;
		this.rightElevtorMotor = rightElevatorMotor;
	}

}
