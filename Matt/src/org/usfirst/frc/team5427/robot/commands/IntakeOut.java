package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.RobotMap;
import org.usfirst.frc.team5427.robot.subsystems.Intake.Dir;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeOut extends Command {
	public IntakeOut() {
		requires(Robot.intake);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		this.setInterruptible(true);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.intake.setDir(Dir.Out);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.m_oi.joy.getRawButtonReleased(RobotMap.INTAKE_BUTTON_OUT);
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.intake.setDir(Dir.None);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
