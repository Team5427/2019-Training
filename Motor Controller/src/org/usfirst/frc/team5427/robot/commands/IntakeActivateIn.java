package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeActivateIn extends Command {

    public IntakeActivateIn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.setInterruptible(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.setSpeed(0.3);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !Robot.oi.getJoy().getRawButton(7);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
