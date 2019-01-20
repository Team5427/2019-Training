package frc.robot.subsystems;

import frc.robot.OI;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends Subsystem
{
	public static final int FRONT_RIGHT_MOTOR = 3;
	public static final int REAR_RIGHT_MOTOR = 6;
	public static final int FRONT_LEFT_MOTOR = 1;
	public static final int REAR_LEFT_MOTOR = 0;

	private static PWMVictorSPX frontLeft;
	private static PWMVictorSPX rearLeft;
	private static SpeedControllerGroup leftMotor;
	private static PWMVictorSPX frontRight;
	private static PWMVictorSPX rearRight;
	private static SpeedControllerGroup rightMotor;
	private static DifferentialDrive drive;

	public Drivetrain()
	{
		frontLeft = new PWMVictorSPX(FRONT_LEFT_MOTOR);
		rearLeft = new PWMVictorSPX(REAR_LEFT_MOTOR);
		leftMotor = new SpeedControllerGroup(frontLeft, rearLeft);
		frontRight = new PWMVictorSPX(FRONT_RIGHT_MOTOR);
		rearRight = new PWMVictorSPX(REAR_RIGHT_MOTOR);
		rightMotor = new SpeedControllerGroup(frontRight, rearRight);
		drive = new DifferentialDrive(leftMotor, rightMotor);
	}

	public void tankDrive(double leftSpeed, double rightSpeed)
	{
		leftMotor.set(leftSpeed);
		rightMotor.set(rightSpeed);
	}

	public void setLeft(double speed)
	{
		leftMotor.set(speed);
	}

	public void setRight(double speed)
	{
		rightMotor.set(speed);
	}

	public void joystickDrive()
	{
		drive.arcadeDrive(-OI.getY(), OI.getZ() * .75);
	}

	public void stop()
	{
		drive.stopMotor();
	}

	@Override
	public void initDefaultCommand()
	{
	}
}
