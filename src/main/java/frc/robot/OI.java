/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.ElevUp;
import frc.robot.commands.ElevDown;
import frc.robot.commands.IntakeIn;
import frc.robot.commands.IntakeOut;
import frc.robot.commands.IntakeSlow;
import frc.robot.commands.TiltUp;
import frc.robot.commands.TiltDown;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
	public static final int BUTTON_INTAKE_IN = 7;
	public static final int BUTTON_INTAKE_OUT = 1;
	public static final int BUTTON_INTAKE_SLOW = 2;
	public static final int BUTTON_ELEVATOR_UP = 5;
	public static final int BUTTON_ELEVATOR_DOWN = 3;
	public static final int BUTTON_TOGGLE_TILTER = 8;
	public static final int BUTTON_TILTER_UP = 6;
	public static final int BUTTON_TILTER_DOWN = 4;
	public static final int BUTTON_ELEVATOR_DOWN_MANUAL = 11;

	public static final int JOYSTICK_PORT = 0;
	public static final int ALT_JOYSTICK_PORT = 0;
	public static final int ONE_JOYSTICK = 0;
	public static final int TWO_JOYSTICKS = 1;
	public static final int JOYSTICK_MODE = ONE_JOYSTICK;

	public static Joystick joystick;
	private static JoystickButton intakeIn;
	private static JoystickButton intakeOut;
	private static JoystickButton intakeSlow;
	private static JoystickButton elevUp;
	private static JoystickButton elevDown;
	private static JoystickButton tiltUp;
	private static JoystickButton tiltDown;

	public OI()
	{
		joystick = new Joystick(JOYSTICK_PORT);
		elevUp = new JoystickButton(joystick, BUTTON_ELEVATOR_UP);
		elevDown = new JoystickButton(joystick, BUTTON_ELEVATOR_DOWN);
		intakeIn = new JoystickButton(joystick, BUTTON_INTAKE_IN);
		intakeOut = new JoystickButton(joystick, BUTTON_INTAKE_OUT);
		intakeSlow = new JoystickButton(joystick, BUTTON_INTAKE_SLOW);
		tiltUp = new JoystickButton(joystick, BUTTON_TILTER_UP);
		tiltDown = new JoystickButton(joystick, BUTTON_TILTER_DOWN);

		elevUp.whileHeld(new ElevUp(0));
		elevDown.whileHeld(new ElevDown(0));
		intakeIn.whileHeld(new IntakeIn(0));
		intakeOut.whileHeld(new IntakeOut(0));
		intakeSlow.whileHeld(new IntakeSlow(0));
		tiltUp.whileHeld(new TiltUp(0));
		tiltDown.whileHeld(new TiltDown(0));
	}

	public static double getX()
	{
		return joystick.getX();
	}

	public static double getY()
	{
		return joystick.getY();
	}

	public static double getZ()
	{
		return joystick.getZ();
	}
}
