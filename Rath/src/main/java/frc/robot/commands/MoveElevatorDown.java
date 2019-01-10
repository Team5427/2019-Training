/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.commands;

import frc.robot.Robot;
import frc.util.Config;
import edu.wpi.first.wpilibj.command.Command;

public class MoveElevatorDown extends Command {
	public MoveElevatorDown() {}
	@Override
	protected void initialize() {
		this.setInterruptible(true);
		Robot.elevator_Left.set(-Config.ELEVATOR_MOTOR_SPEED_DOWN);
		Robot.elevator_Right.set(Config.ELEVATOR_MOTOR_SPEED_DOWN);
	}

	@Override
	protected void execute() {}

	@Override
	public boolean isFinished() {
		Robot.elevatorLimitSwitchDown.get();
		return (!Robot.oi.getJoy().getRawButton(Config.BUTTON_ELEVATOR_DOWN) || !Robot.elevatorLimitSwitchDown.get());
	}

	@Override
	protected void end()
	{
		Robot.elevator_Left.set(0);
		Robot.elevator_Right.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() 
	{
		end();
	}
}
