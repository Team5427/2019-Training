package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Sensor extends Subsystem
{
    public static final int LEFT_A = 0;
	public static final int LEFT_B = 1;
	public static final int WHEEL_CIRCUMFERENCE_INCHES = 1;

    public Encoder encoder;
    public AHRS ahrs;

    public Sensor()
    {
        encoder = new Encoder(LEFT_A, LEFT_B, false, Encoder.EncodingType.k4X);
        ahrs = new AHRS(SPI.Port.kMXP);
    }

	public int getDistance()
	{
		return encoder.get() * WHEEL_CIRCUMFERENCE_INCHES;
	}

    @Override
    public void initDefaultCommand()
    {
    }
}