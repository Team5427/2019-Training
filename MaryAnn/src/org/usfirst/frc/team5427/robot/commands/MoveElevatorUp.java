/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.util.Config;
import edu.wpi.first.wpilibj.command.Command;

/**
 * An example command.  You can replace me with your own command.
 */
public class MoveElevatorUp extends Command {
	public MoveElevatorUp() {}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {this.setInterruptible(true);}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.elevator_Left.set(-Config.ELEVATOR_MOTOR_SPEED_UP);
		Robot.elevator_Right.set(Config.ELEVATOR_MOTOR_SPEED_UP);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	public boolean isFinished() {
		Robot.elevatorLimitSwitchUp.get();
		return (!Robot.oi.getJoy().getRawButton(Config.BUTTON_ELEVATOR_UP) || !Robot.elevatorLimitSwitchUp.get());
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.elevator_Left.set(0);
		Robot.elevator_Right.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
