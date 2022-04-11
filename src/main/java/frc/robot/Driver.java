package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Driver
{
  private static final int THROTTLE_USB_PORT = 0;
  private static final int STEERING_USB_PORT = 1;

  private static final double DEADZONE = 0.05;

  private Joystick throttle;
  private Joystick steering;

  public Driver()
  {
    throttle = new Joystick(THROTTLE_USB_PORT);
    steering = new Joystick(STEERING_USB_PORT);
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

  public double getThrottle()
  {
    return -deadzone(throttle.getY());
  }

  public double getSteering()
  {
    return deadzone(steering.getX());
  }
}
