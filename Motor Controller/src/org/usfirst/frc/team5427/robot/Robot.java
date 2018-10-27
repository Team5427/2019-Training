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
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Spark;

/**
 * This sample program shows how to control a motor using a joystick. In the
 * operator control part of the program, the joystick is read and the value is
 * written to the motor.
 *
 * <p>Joystick analog values range from -1 to 1 and speed controller inputs also
 * range from -1 to 1 making it easy to work together.
 */
public class Robot extends TimedRobot {
	private static final int frontRightPort = 6;
	private static final int frontLeftPort = 3;
	private static final int backLeftPort = 1;
	private static final int backRightPort = 0;
	public static SpeedControllerGroup spgRight;
	public static SpeedControllerGroup spgLeft;
	public static DifferentialDrive drive;
	private SpeedController fr_motor, fl_motor, br_motor, bl_motor;
	private Joystick m_joystick;
	public static DriveTrain driveTrain;
	public static Intake intake;
	public static OI oi;
	public static ElevatorUp mou;
	public static ElevatorDown mod;
	public static Elevator elevator;
	public static DigitalInput elevLimSwiUp, elevLimSwiDown;
	@Override
	public void robotInit() {
		elevLimSwiUp = new DigitalInput(5);
		elevLimSwiDown = new DigitalInput(4);
		elevator = new Elevator(new PWMVictorSPX(4), new PWMVictorSPX(9));
		intake = new Intake(new PWMVictorSPX(7), new PWMVictorSPX(8));
		oi = new OI();
		fr_motor = new PWMVictorSPX(frontRightPort);
		br_motor = new PWMVictorSPX(backRightPort);
		fl_motor = new PWMVictorSPX(frontLeftPort);
		bl_motor = new PWMVictorSPX(backLeftPort);
		m_joystick = new Joystick(0);
		spgRight = new SpeedControllerGroup(fr_motor, br_motor);
		spgLeft = new SpeedControllerGroup(fl_motor, bl_motor);
		drive = new DifferentialDrive(spgLeft, spgRight);
		driveTrain = new DriveTrain(spgLeft, spgRight, drive);
		drive.setSafetyEnabled(false);
	}
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		
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
	public void autonomousInit() {

	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {

	}


	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.		
	}

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