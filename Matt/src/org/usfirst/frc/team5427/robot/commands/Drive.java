package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive extends Command {

	public Drive() {
		requires(Robot.driveTrain);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.driveTrain.updateSpeeds(Robot.m_oi.joy);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.driveTrain.stop();
	}

	protected void interrupted() {
		end();
	}
}
