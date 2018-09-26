package org.usfirst.frc.team5427.robot.subsystems;

import org.usfirst.frc.team5427.robot.Robot;


import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Tilt extends Subsystem {

	public PWMVictorSPX tiltMtr;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Tilt(PWMVictorSPX tiltMtr) {
		// TODO Auto-generated constructor stub
    	this.tiltMtr = tiltMtr;
	}
    
    public void setSpeed(double speed) {
    	tiltMtr.set(speed);
    }
    

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

