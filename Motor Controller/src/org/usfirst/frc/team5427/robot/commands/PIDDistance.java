package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.util.Config;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 */
public class PIDDistance extends Command {

	public static double speed;
	//public static boolean timeStarted;
	public static double setPoint;
	public static double p, i, d;
    public PIDDistance(double setPoint) {
    	this.setPoint = setPoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//timeStarted = false;
    	Robot.driveTrain.setSetpoint(setPoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double distFromSetpoint = Math.abs(Robot.driveTrain.getSetpoint()- Robot.driveTrain.getPosition());
		boolean inRange = distFromSetpoint < 10f;
		return inRange;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.spgLeft.set(0);
    	Robot.spgRight.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }


}
