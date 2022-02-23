package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.Talon;

public class Robot
{
  private final int LEFT_MOTORS_PWM_CHANNEL = 0;
  private final int RIGHT_MOTORS_PWM_CHANNEL = 1;

  private final int THROTTLE_USB_PORT = 0;
  private final int STEERING_USB_PORT = 1;

  private final double DEADZONE = 0.15;

  private Talon leftMotors;
  private Talon rightMotors;

  private Joystick throttle;
  private Joystick steering;

  public Robot()
  {
    leftMotors = new Talon(LEFT_MOTORS_PWM_CHANNEL);
    rightMotors = new Talon(RIGHT_MOTORS_PWM_CHANNEL);

    throttle = new Joystick(THROTTLE_USB_PORT);
    steering = new Joystick(STEERING_USB_PORT);

    stop();
  }

  private double deadzone(double value)
  {
    if (Math.abs(value) < DEADZONE)
    {
      return 0;
    }
    else
    {
      return value;
    }
  }

  private double getThrottle()
  {
    return -deadzone(throttle.getY());
  }

  private double getSteering()
  {
    return deadzone(steering.getX());
  }

  private void drive(double throttleSpeed, double steeringSpeed)
  {
    leftMotors.set(throttleSpeed + steeringSpeed);
    rightMotors.set(throttleSpeed - steeringSpeed);
  }

  public void stop()
  {
    leftMotors.set(0);
    rightMotors.set(0);
  }

  public void run()
  {
    drive(getThrottle(), getSteering());
  }
}
