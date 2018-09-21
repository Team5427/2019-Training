package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveElev extends Command {
	Dir dir;

	public enum Dir {
		Up, Down
	}

	public MoveElev(Dir dir) {
		requires(Robot.elevator);
		this.dir = dir;
	}

	protected void initialize() {
		setInterruptible(true);
	}

	protected void execute() {
		switch (dir) {
		case Up:
			Robot.elevator.setSpeed(.8f);
			break;
		case Down:
			Robot.elevator.setSpeed(-.5f);
			break;
		}
	}

	protected boolean isFinished() {
		switch(dir) {
		case Up:
			return !Robot.elevLimitUp.get();
		case Down:
			return !Robot.elevLimitDown.get();
		}
		return false;
	}

	protected void end() {
		Robot.elevator.setSpeed(0);
	}

	protected void interrupted() {
		end();
	}
}
