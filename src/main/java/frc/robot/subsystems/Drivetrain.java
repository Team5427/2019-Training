package frc.robot.subsystems;

import frc.robot.OI;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends Subsystem
{
	private static PWMVictorSPX frontLeft;
	private static PWMVictorSPX rearLeft;
	private static SpeedControllerGroup leftMotor;
	private static PWMVictorSPX frontRight;
	private static PWMVictorSPX rearRight;
	private static SpeedControllerGroup rightMotor;
	private static DifferentialDrive drive;

	public Drivetrain()
	{
		frontLeft = new PWMVictorSPX(RobotMap.FRONT_LEFT_MOTOR);
		rearLeft = new PWMVictorSPX(RobotMap.REAR_LEFT_MOTOR);
		leftMotor = new SpeedControllerGroup(frontLeft, rearLeft);
		frontRight = new PWMVictorSPX(RobotMap.FRONT_RIGHT_MOTOR);
		rearRight = new PWMVictorSPX(RobotMap.REAR_RIGHT_MOTOR);
		rightMotor = new SpeedControllerGroup(frontRight, rearRight);
		drive = new DifferentialDrive(leftMotor, rightMotor);
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
