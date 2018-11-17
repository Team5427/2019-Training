package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.util.Config;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 */
public class PIDDistance extends PIDCommand {

	public static double speed;
	public static boolean timeStarted;
    public PIDDistance(double p, double i, double d, double setPoint, double speed) {
    	super(p, i, d);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.speed = speed;
    	requires(Robot.driveTrain);
    	getPIDController().setOutputRange(-1f, 1f);
		getPIDController().setSetpoint(setPoint);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	super.getPIDController().enable();
    	timeStarted = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.spgRight.set(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double distFromSetpoint = Math.abs(getPIDController().getSetpoint()- (Math.abs(Robot.encLeft.getDistance())));
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

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return Math.abs(Robot.encLeft.getDistance());
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		Robot.spgLeft.pidWrite(output);
	}
}
