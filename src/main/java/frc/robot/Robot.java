package frc.robot;

public class Robot
{
  private Drivetrain drivetrain;
  private Driver driver;

  public Robot()
  {
    drivetrain = new Drivetrain();
    driver = new Driver();

    drivetrain.stop();
  }

  public void run()
  {
    drivetrain.drive(driver.getThrottle(), driver.getSteering());
  }

  public void stop()
  {
    drivetrain.stop();
  }
}
