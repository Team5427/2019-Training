/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5427.robot;


import org.usfirst.frc.team5427.robot.commands.DriveWithJoystick;
import org.usfirst.frc.team5427.robot.commands.ElevatorDown;
import org.usfirst.frc.team5427.robot.commands.ElevatorUp;
import org.usfirst.frc.team5427.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5427.robot.subsystems.Elevator;
import org.usfirst.frc.team5427.robot.subsystems.Intake;
import org.usfirst.frc.team5427.util.Config;

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
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5427.robot.commands.ElevatorDown;
import org.usfirst.frc.team5427.robot.commands.ElevatorUp;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
//	public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
	public static OI oi;
	
	public SpeedController drive_left_front;
	public SpeedController drive_left_back;
	public SpeedControllerGroup drive_left;
	
	public SpeedController drive_right_front;
	public SpeedController drive_right_back;
	public SpeedControllerGroup drive_right;
	
	public static SpeedController inTake_Left;
	public static SpeedController inTake_Right;
	
	public static SpeedController elevator_Left;
	public static SpeedController elevator_Right;
	
	public static Intake intakeSubsystem;

	public static DriveTrain driveTrain;
	
	public static Elevator elevator;
	
	

//	Command m_autonomousCommand;
//	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit()
	{
		drive_left_front = new PWMVictorSPX(1);
		drive_left_back = new PWMVictorSPX(0);
		drive_left = new SpeedControllerGroup(drive_left_front, drive_left_back);
		
		drive_right_front = new PWMVictorSPX(3);
		drive_right_back = new PWMVictorSPX(6);
		drive_right = new SpeedControllerGroup(drive_right_front, drive_right_back);
		
		inTake_Left = new PWMVictorSPX(Config.INTAKE_MOTOR_LEFT);
		inTake_Right = new PWMVictorSPX(Config.INTAKE_MOTOR_RIGHT);
		intakeSubsystem = new Intake(inTake_Left, inTake_Right);

		driveTrain = new DriveTrain(drive_left, drive_right);
		
		oi = new OI();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
//	@Override
//	public void autonomousInit() {
//		m_autonomousCommand = m_chooser.getSelected();
//
//		/*
//		 * String autoSelected = SmartDashboard.getString("Auto Selector",
//		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
//		 * = new MyAutoCommand(); break; case "Default Auto": default:
//		 * autonomousCommand = new ExampleCommand(); break; }
//		 */
//
//		// schedule the autonomous command (example)
//		if (m_autonomousCommand != null) {
//			m_autonomousCommand.start();
//		}
//	}

	/**
	 * This function is called periodically during autonomous.
	 */
//	@Override
//	public void autonomousPeriodic() {
//		Scheduler.getInstance().run();
//	}

//	@Override
//	public void teleopInit() {
//		// This makes sure that the autonomous stops running when
//		// teleop starts running. If you want the autonomous to
//		// continue until interrupted by another command, remove
//		// this line or comment it out.
//		if (m_autonomousCommand != null) {
//			m_autonomousCommand.cancel();
//		}
//	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
