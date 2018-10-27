package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TimedForward extends Command {

    public TimedForward(double time) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        this.setTimeout(time);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.spgLeft.set(0.3);
    	Robot.spgRight.set(-0.3);
    }
    
    // Called once after isFinished returns true
    protected void end() {
    	Robot.spgLeft.set(0);
    	Robot.spgRight.set(0);
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut();
    }

   

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
