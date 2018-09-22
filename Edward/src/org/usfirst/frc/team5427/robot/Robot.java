/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5427.robot.commands.ExampleCommand;
import org.usfirst.frc.team5427.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5427.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team5427.robot.subsystems.Intake;
import org.usfirst.frc.team5427.robot.commands.DriveWithJoystick;
import org.usfirst.frc.team5427.robot.commands.ElevatorDown;
import org.usfirst.frc.team5427.robot.commands.ElevatorUp;
import org.usfirst.frc.team5427.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5427.util.Config;

import autoCommands.moveForward;
import edu.wpi.cscore.AxisCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot 
{
	Command autoCommandForward;
	public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
	public static OI m_oi;
	public static DriveTrain drivetrain;
	public static Intake intake;
	SpeedControllerGroup speedcontrollergroup_left;
	SpeedControllerGroup speedcontrollergroup_right;
	public DifferentialDrive drive;
	DriveWithJoystick dwj;
	public static SpeedController motor_pwm_frontLeft;
	public static SpeedController motor_pwm_rearLeft;
	public static SpeedController motor_pwm_frontRight;
	public static SpeedController motor_pwm_rearRight;
	public static SpeedController motor_pwm_Tilt;
	public static SpeedController Intake_Right;
	public static SpeedController Intake_Left;
	public static SpeedController ElevatorRightSide;
	public static SpeedController ElevatorLeftSide;
	public static DigitalInput ElevatorLimitUp;
	public static DigitalInput ElevatorLimitDown;
	public static ElevatorUp eu = new ElevatorUp();
	public static ElevatorDown ed = new ElevatorDown();
	
	
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	
	public void robotInit() 
	{		
		autoCommandForward = new moveForward();
		//                         Driving
		
		motor_pwm_frontLeft = new PWMVictorSPX(Config.FRONT_LEFT_MOTOR);
		motor_pwm_rearLeft = new PWMVictorSPX(Config.REAR_LEFT_MOTOR);
		motor_pwm_frontRight = new PWMVictorSPX(Config.FRONT_RIGHT_MOTOR);
		motor_pwm_rearRight = new PWMVictorSPX(Config.REAR_RIGHT_MOTOR);
		
		speedcontrollergroup_left = new SpeedControllerGroup(motor_pwm_frontLeft, motor_pwm_rearLeft);
		speedcontrollergroup_right = new SpeedControllerGroup(motor_pwm_frontRight, motor_pwm_rearRight);
		drive = new DifferentialDrive(speedcontrollergroup_left, speedcontrollergroup_right);
		drive.setSafetyEnabled(false);
		drivetrain = new DriveTrain(speedcontrollergroup_left, speedcontrollergroup_right, drive);
		
		//                         Intake
		
		Intake_Right = new PWMVictorSPX(Config.INTAKE_MOTOR_RIGHT);
		Intake_Left = new PWMVictorSPX(Config.INTAKE_MOTOR_LEFT);		
		intake = new Intake(Intake_Right, Intake_Left);
		
		//                         Elevator
		
		ElevatorLimitUp = new DigitalInput(Config.ELEVATOR_LIMIT_SWITCH_UP);
		ElevatorLimitDown = new DigitalInput(Config.ELEVATOR_LIMIT_SWITCH_DOWN);
		ElevatorLeftSide = new PWMVictorSPX(Config.ELEVATOR_MOTOR_LEFT);
		ElevatorRightSide = new PWMVictorSPX(Config.ELEVATOR_MOTOR_RIGHT);
		
		//						   Tilt
		
		motor_pwm_Tilt = new PWMVictorSPX(Config.TILT_INTAKE_MOTOR);
		
		//                         OI at the end
		
		m_oi = new OI();
		


	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */

	public void disabledInit() 
	{
		Scheduler.getInstance().removeAll();
	}
	public void disabledPeriodic() 
	{
		
	}
	public void autonomousInit() 
	{
		
	}
	public void autonomousPeriodic() 
	{
		if(autoCommandForward!=null)
			autoCommandForward.start();
	}
	public void teleopInit() 
	{
		
	}
	public void teleopPeriodic()
	{
		Scheduler.getInstance().run();
		eu.isFinished();
		ed.isFinished();
	}
	public void testPeriodic() 
	{
		
	}
}
