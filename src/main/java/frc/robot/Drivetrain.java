package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.Talon;

public class Drivetrain
{
  private final int LEFT_MOTORS_PWM_CHANNEL = 0;
  private final int RIGHT_MOTORS_PWM_CHANNEL = 1;

  private final boolean LEFT_MOTORS_INVERTED = false;
  private final boolean RIGHT_MOTORS_INVERTED = false;

  private Talon leftMotors;
  private Talon rightMotors;

  public Drivetrain()
  {
    leftMotors = new Talon(LEFT_MOTORS_PWM_CHANNEL);
    rightMotors = new Talon(RIGHT_MOTORS_PWM_CHANNEL);
    initialize();
  }

  private void initialize()
  {
    leftMotors.setInverted(LEFT_MOTORS_INVERTED);
    rightMotors.setInverted(RIGHT_MOTORS_INVERTED);
    stop();
  }

  public void drive(double throttle, double steering)
  {
    leftMotors.set(throttle + steering);
    rightMotors.set(throttle - steering);
  }

  public void stop()
  {
    leftMotors.set(0);
    rightMotors.set(0);
  }
}
