package autoCommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class moveForward extends CommandGroup {
	
	public moveForward()
	{
		addSequential(new forward( int time));)
	}

	@Override
	protected boolean isFinished() 
	{
		return false;
	}
	public void forward(int time)
	{
		
	}

}
