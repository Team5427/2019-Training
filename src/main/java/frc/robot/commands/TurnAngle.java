package frc.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Sensor;

public class TurnAngle extends Command implements PIDOutput
{
    public static final double kp = 0.03;
    public static final double ki = 0;
    public static final double kd = 0;
    public static final double kToleranceDegrees = 5;

    private PIDController controller;
    private double leftSpeed;
    private double rightSpeed;

	public TurnAngle(double angleDegrees)
	{
        controller = new PIDController(kp, ki, kd, Sensor.ahrs, this);
        controller.setSetpoint(angleDegrees);
        controller.setInputRange(-180, 180);
        controller.setOutputRange(-1, 1);
        controller.setAbsoluteTolerance(kToleranceDegrees);
        controller.setContinuous(true);
	}

	@Override
	protected void initialize()
	{
        controller.enable();
	}

	@Override
	protected void execute()
	{
        Robot.drivetrain.tankDrive(leftSpeed, rightSpeed);
	}

	@Override
	protected boolean isFinished()
	{
		return controller.onTarget();
	}

	@Override
	protected void end()
	{
        this.controller.disable();
	}

	@Override
	protected void interrupted()
	{
        this.end();
    }

    @Override
    public void pidWrite(double output)
    {
        leftSpeed = output;
        rightSpeed = output;
    }
}
