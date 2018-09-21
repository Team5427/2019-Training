package org.usfirst.frc.team5427.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	Talon elevLeft,elevRight;
	
    public Elevator(Talon elevLeft, Talon elevRight) {
		super();
		this.elevLeft = elevLeft;
		this.elevRight = elevRight;
	}

	public void setSpeed(float newSpeed) {
		elevRight.set(newSpeed);
		elevLeft.set(-newSpeed);
    }

    public void initDefaultCommand() {
    }
}

