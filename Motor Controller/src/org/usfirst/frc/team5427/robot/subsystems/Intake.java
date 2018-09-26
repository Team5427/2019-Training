package org.usfirst.frc.team5427.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

		private SpeedController leftFlywheel;
		private SpeedController rightFlywheel;
		public static final double LEFT_FLYWHEEL_BIAS_FORWARD = 1;
		public static final double LEFT_FLYWHEEL_BIAS_BACKWARD = 1;
		public static final double RIGHT_FLYWHEEL_BIAS_FORWARD = 1;
		public static final double RIGHT_FLYWHEEL_BIAS_BACKWARD = 1;
		public static final double LEFT_FLYWHEEL_OFFSET_FORWARD = 0;
		public static final double LEFT_FLYWHEEL_OFFSET_BACKWARD = 0;
		public static final double RIGHT_FLYWHEEL_OFFSET_FORWARD = 0;
		public static final double RIGHT_FLYWHEEL_OFFSET_BACKWARD = 0;

		public Intake(SpeedController leftFlywheel, SpeedController rightFlywheel) {
			this.leftFlywheel = leftFlywheel;
			this.rightFlywheel = rightFlywheel;
		}

		public void setSpeed(double speed) {
			if (speed < 0) {
				leftFlywheel.set(speed * LEFT_FLYWHEEL_BIAS_BACKWARD + LEFT_FLYWHEEL_OFFSET_BACKWARD);
				rightFlywheel.set(speed * RIGHT_FLYWHEEL_BIAS_FORWARD + RIGHT_FLYWHEEL_OFFSET_FORWARD);
			}
			else if (speed > 0) {
				leftFlywheel.set(speed * LEFT_FLYWHEEL_BIAS_FORWARD + LEFT_FLYWHEEL_OFFSET_FORWARD);
				rightFlywheel.set(speed * RIGHT_FLYWHEEL_BIAS_BACKWARD + RIGHT_FLYWHEEL_OFFSET_BACKWARD);
			}
			else {
				leftFlywheel.set(0);
				rightFlywheel.set(0);
			}
		}

		@Override
		public void initDefaultCommand() {
		}

		public void stop() {
			setSpeed(0);
		}
}

