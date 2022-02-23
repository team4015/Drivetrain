package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Match extends TimedRobot
{
  private Robot robot;

  @Override
  public void robotInit()
  {
    robot = new Robot();
  }

  @Override
  public void robotPeriodic()
  {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void teleopInit()
  {
    robot.stop();
  }

  @Override
  public void teleopPeriodic()
  {
    robot.drive();
  }

  @Override
  public void disabledInit()
  {
    robot.stop();
  }

  @Override
  public void disabledPeriodic()
  {
    robot.stop();
  }
}
