package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveWithJoystick extends Command {

	public DriveWithJoystick() {
		requires(Robot.drivetrain);
	}
	protected void execute() {
		Robot.drivetrain.takeJoystickInputs(Robot.m_oi.getJoy());
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	protected void end() {
		Robot.drivetrain.stop();
	}
	protected void interrupted() {
		end();
	}
}
