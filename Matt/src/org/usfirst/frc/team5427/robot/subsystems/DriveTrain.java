package org.usfirst.frc.team5427.robot.subsystems;

import org.usfirst.frc.team5427.robot.commands.Drive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {
	DifferentialDrive diffDrive;
	SpeedControllerGroup leftMotors;
	SpeedControllerGroup rightMotors;

	public DriveTrain(DifferentialDrive diffDrive, SpeedControllerGroup leftMotors, SpeedControllerGroup rightMotors) {
		super();
		this.diffDrive = diffDrive;
		this.leftMotors = leftMotors;
		this.rightMotors = rightMotors;
	}

	protected void initDefaultCommand() {
		setDefaultCommand(new Drive());
	}
	
	public void updateSpeeds(Joystick joy) {
		diffDrive.arcadeDrive(-joy.getY(), joy.getZ() * .75);
	}

	public void updateSpeeds() {
		//	auto only
	}

	public void stop() {
		diffDrive.stopMotor();
	}
}
