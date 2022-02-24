package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.Talon;

public class Drivetrain
{
  private final int LEFT_MOTORS_PWM_CHANNEL = 0;
  private final int RIGHT_MOTORS_PWM_CHANNEL = 1;

  private Talon leftMotors;
  private Talon rightMotors;

  public Drivetrain()
  {
    leftMotors = new Talon(LEFT_MOTORS_PWM_CHANNEL);
    rightMotors = new Talon(RIGHT_MOTORS_PWM_CHANNEL);

    stop();
  }

  private void setLeftMotors(double speed)
  {
    leftMotors.set(speed);
  }

  private void setRightMotors(double speed)
  {
    rightMotors.set(-speed);
  }

  public void drive(double throttleSpeed, double steeringSpeed)
  {
    setLeftMotors(throttleSpeed + steeringSpeed);
    setRightMotors(throttleSpeed - steeringSpeed);
  }

  public void stop()
  {
    setLeftMotors(0);
    setRightMotors(0);
  }
}
