/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.PWMVictorSPX;

import java.util.concurrent.TimeUnit;

import org.usfirst.frc.team5427.robot.commands.DriveForward;
import org.usfirst.frc.team5427.robot.commands.ElevatorDown;
import org.usfirst.frc.team5427.robot.commands.ElevatorUp;
import org.usfirst.frc.team5427.robot.commands.ElevatorUpAuto;
import org.usfirst.frc.team5427.robot.commands.IntakeOutSlow;
import org.usfirst.frc.team5427.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5427.robot.subsystems.Elevator;
import org.usfirst.frc.team5427.robot.subsystems.Intake;
import org.usfirst.frc.team5427.robot.subsystems.Tilt;
import org.usfirst.frc.team5427.util.Config;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot 
{	
	//DriveTrain subsystem 
	public static DriveTrain driveTrain;
	
	//SpeedController for front left motor of drive train
	public static SpeedController motor_pwm_frontLeft;
	//SpeedController for rear left motor of drive train
	public static SpeedController motor_pwm_rearLeft;
	//links together SpeedController frontLeft and rearLeft
	SpeedControllerGroup speedcontrollergroup_left;
	
	//SpeedController for front right motor of drive train
	public static SpeedController motor_pwm_frontRight;
	//SpeedController for rear right motor of drive train
	public static SpeedController motor_pwm_rearRight;
	//links together SpeedController front and rear right
	SpeedControllerGroup speedcontrollergroup_right;
	
	//handles the differential drive train configuration
	public DifferentialDrive drive;
	
	//SpeedController for the left intake motor
	public static SpeedController motorPWM_IntakeLeft;
	//SpeedController for the right intake motor
	public static SpeedController motorPWM_IntakeRight;
	
	//Intake subsystem
	public static Intake intake;
	
	//SpeedController for the left elevator motor
	public static SpeedController motorPWM_ElevatorLeft;
	//SpeedController for the right elevator motor
	public static SpeedController motorPWM_ElevatorRight;
	
	public static Elevator elevator;//might be deleted
	
	//DigitalInput that handles upper limit swtich
	public static DigitalInput elevatorLimitUp;
	//DigitalInput that handles lower limit swtich
	public static DigitalInput elevatorLimitDown;
	
	//?? Commands for elevator function
	public static ElevatorUp mou;
	public static ElevatorDown mod;
	
	public static SpeedController motorPWM_Tilt;
	
	public static Tilt tilt;
	
	public static boolean tiltUpNext;
	
	//operator interface
	public static OI m_oi;

	DriveForward m_driveForward;
	
	ElevatorUpAuto m_elevatorUp;
	
	IntakeOutSlow m_intakeOut;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() 
	{	
		//sets to DigitalInputs, used for limit switch up and down
		elevatorLimitUp = new DigitalInput(Config.ELEVATOR_LIMIT_UP);
		elevatorLimitDown = new DigitalInput(Config.ELEVATOR_LIMIT_DOWN);
		
		//PWMVictorSPX speed controller used for front and rear left motors of drive train
		motor_pwm_frontLeft = new PWMVictorSPX(Config.FRONT_LEFT_MOTOR);
		motor_pwm_rearLeft = new PWMVictorSPX(Config.REAR_LEFT_MOTOR);
		//links both left motors of drive train
		speedcontrollergroup_left = new SpeedControllerGroup(motor_pwm_frontLeft, motor_pwm_rearLeft);
		
		//PWMVictorSPX speed controller used for front and rear right motors of drive train
		motor_pwm_frontRight = new PWMVictorSPX(Config.FRONT_RIGHT_MOTOR);
		motor_pwm_rearRight = new PWMVictorSPX(Config.REAR_RIGHT_MOTOR);
		//links both right motors of drive train
		speedcontrollergroup_right = new SpeedControllerGroup(motor_pwm_frontRight, motor_pwm_rearRight);
		
		//uses both left and right side speed controllers of drive train to create DifferentialDrive
		drive = new DifferentialDrive(speedcontrollergroup_left, speedcontrollergroup_right);
		//??disables motor safety
		drive.setSafetyEnabled(false);
		//initializes DriveTrain subsystem using both left and right speed controller groups
		driveTrain = new DriveTrain(speedcontrollergroup_left, speedcontrollergroup_right, drive);
		
		
		//PWMVictorSPX speed controller used for left intake motor
		motorPWM_IntakeLeft = new PWMVictorSPX(Config.INTAKE_MOTOR_LEFT);
		//PWMVictorSPX speed controller used for right intake motor
		motorPWM_IntakeRight = new PWMVictorSPX(Config.INTAKE_MOTOR_RIGHT);
		//initializes Intake subsystem using both left and right speed controllers 
		intake = new Intake(motorPWM_IntakeLeft, motorPWM_IntakeRight);
		
		motorPWM_ElevatorLeft = new PWMVictorSPX(Config.ELEVATOR_MOTOR_LEFT);
		motorPWM_ElevatorRight = new PWMVictorSPX(Config.ELEVATOR_MOTOR_RIGHT);
		elevator = new Elevator(motorPWM_ElevatorLeft, motorPWM_ElevatorRight);//might be deleted
		mou = new ElevatorUp();
		mod = new ElevatorDown();
		
		
		motorPWM_Tilt = new PWMVictorSPX(Config.TILT_MOTOR);
		tilt = new Tilt(motorPWM_Tilt);
		
//		m_chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		m_oi = new OI();
		m_driveForward = new DriveForward(2.00);
		m_elevatorUp = new ElevatorUpAuto(1.50);
		m_intakeOut = new IntakeOutSlow(2.00);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() 
	{
		Scheduler.getInstance().removeAll();
	}

	@Override
	public void disabledPeriodic() 
	{
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
	@Override
	public void autonomousInit() 
	{
		Scheduler.getInstance().run();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		//m_driveForward.start();
		
		m_driveForward.start();
		m_elevatorUp.start();
		
		m_intakeOut.start();
		
		
		
		
		
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() 
	{
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() 
	{
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		/*if (m_autonomousCommand != null) 
		{
			m_autonomousCommand.cancel();
		}*/
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() 
	{
		Scheduler.getInstance().run();
		mou.isFinished();
		mod.isFinished();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() 
	{
	}
}
