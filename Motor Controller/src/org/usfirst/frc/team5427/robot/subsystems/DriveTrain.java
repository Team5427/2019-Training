/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5427.robot.subsystems;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends PIDSubsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	private SpeedControllerGroup m_left;
	private SpeedControllerGroup m_right;
	private DifferentialDrive m_drive;
	
	/**
	 * Assigns each of the components of the drive train based off of the
	 * subsystem's parameters.
	 * 
	 * @param drive_Left
	 *            the SpeedControllers on the left side of the robot's drive train.
	 * @param drive_Right
	 *            the SpeedControllers on the right side of the robot's drive train.
	 * @param drive
	 *            the Drive Train that is created inside of Robot.java.
	 */
	public DriveTrain(SpeedControllerGroup drive_Left, SpeedControllerGroup drive_Right, DifferentialDrive drive, double p, double i, double d) {
		super(p,i,d);
		
		this.m_drive = drive;
		this.m_left = drive_Left;
		this.m_right = drive_Right;
		getPIDController().setContinuous(false);
	}
	
	/**
	 * Initializes the DriveWithJoystick command. It runs when nothing is
	 * else is controlling the subsystem.
	 */
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new DriveWithJoystick());
	}
	
	
	
	/**
	 * Receives information from the joy stick and uses it to control the robot's
	 * speed and direction
	 * 
	 * @param joy
	 *            the joystick we utilize to drive the robot.
	 */

	public void takeJoystickInputs(Joystick joy) {
		double speed = Math.abs(joy.getY()) > 0.05 ? joy.getY() : 0f;
		m_drive.arcadeDrive(-joy.getY(), joy.getZ() * .75);
	}

	/**
	 * Stops the robot's motors.
	 */
	public void stop() {
		m_drive.stopMotor();
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return Robot.encLeft.getDistance();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		m_left.pidWrite(output);
		m_right.pidWrite(output);
	}
}
