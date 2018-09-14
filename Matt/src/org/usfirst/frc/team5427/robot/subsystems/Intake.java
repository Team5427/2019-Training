package org.usfirst.frc.team5427.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	Talon intakeLeft, intakeRight;

	public Intake(Talon intakeLeft, Talon intakeRight) {
		super();
		this.intakeLeft = intakeLeft;
		this.intakeRight = intakeRight;
	}

	public enum Dir {
		In, Out, None
	}

	public void setDir(Dir dir) {
		switch (dir) {
		case In:
			System.out.println("INTAKE**********************************************************");
			intakeRight.set(1);
			intakeLeft.set(1);
			break;
		case Out:
			intakeRight.set(-1);
			intakeLeft.set(-1);
			break;
		case None:
			intakeRight.stopMotor();
			intakeLeft.stopMotor();
			break;
		}
	}

	public void initDefaultCommand() {
	}
}
