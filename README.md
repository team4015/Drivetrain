# Drivetrain
This repository contains basic code for an FRC robot drivetrain, as well as instructions on how to wire the drivetrain correctly.  Everyone should read this guide, regardless if you are new to FRC or are a veteran.  This code is a great resource to easily test your drivetrain.

## Mechanical
This code will work best with an AndyMark drivetrain that has two **brushed** DC motors on either side.  The left motors work together to drive the left wheels, and similarly for the right motors.  **CIM** motors are most commonly used for drivetrains.

## Electrical
Wiring the motors correctly is very important.  Accidentally wiring some motors backwards could cause them to damage each other and the gearbox!  To wire the drivetrain correctly, follow these steps:

**NOTE:** Make sure to complete these steps **individually** for each motor.  Do not wire the motors to the motor controllers until you have completed these steps for each motor separately.  Only power **one** motor at a time!

1. Connect the motor to a battery.
2. Check if the robot wheels turn forward.
3. If the wheels turn backward, flip the motor wires when you connect it to the battery and check again.
4. Write down the polarity of the motor wires that make the wheels spin forwards.  For example, if you connected the red motor wire to the red battery wire, and the black motor wire to the black battery wire, then the red motor wire is positive `+` and the black wire is negative `-`.  Sometimes you may need to flip the wires to get the wheels to spin forwards.  In this case, black is positive `+` and red is negative `-`.  Don't worry if the motor wire colours don't match the battery!  Switching the wires just switches the direction.  A brushed motor is basically a coil and will work both ways.  Sometimes the factory will accidentally switch the wire colours, which means that the colours will be flipped.
5. Repeat steps 1-4 for each motor.  Make sure to record the polarity for each one.
6. Wire the motors to the **output** of your motor controllers.  You need one motor controller for each motor.  The motor controller output is ususally labelled `M+` and `M-` or something similar.  You should wire the motors so that the positive `+` wire is attached to `M+` and the negative `-` wire to `M-`.  All of the wiring does not need to be identical, meaning that red does not always go to `M+` and black to `M-`.  The goal is to wire the motor controllers so that when they tell their motor to move forward, it will spin the wheels forward.  Pay extra attention when wiring motors from the same side!  These motors must always spin together in the same direction so that they don't fight each other!  Double check with the battery if you are not sure.
7. After wiring the motors, connect the power **input** of the motor controllers to the PDP ports.  These are usually labelled `+` (red) and `-` (black) instead of `M+` and `M-`. Make sure to use the large ports PDP with 40 A circuit breakers, since the drivetrain motors will draw a lot of current.  Be extra sure to connect the red wire (12 V) to the positive input of the motor controller and the black wire (0 V) to the negative (GND) input.  In other words, red and black must match with `+` and `-`!  Wiring these backwards will permanently destroy the motor controller.  I've totally NOT done that before....
8. Next, connect the motor controllers using PWM Y-cables.  A Y-cable is used to split a PWM signal to two different motor controllers.  This allows the roboRIO to send the exact same speed to to motors without needing extra code!  You should use one Y-cable for each side of the robot.  Connect one pair to the left motor controllers and another to the right motor controllers.  Double check that you wired the motors correctly.  The motor controllers can only tell the motors to spin in the same direction, but they have no way of knowing if they actually do!
9. Finally, connect the other end of the left and right PWM Y-cables to the roboRIO PWM channels.  Traditionally, we use channel 0 for the left motors and channel 1 for the right motors.  You can use different channels, just remember to change it in the code.

## Programming
This code is designed to work with any drivetrain that uses **Talon SR** motor controllers that were wired with the procedure described above.  You can easily modify the code to work with any other PWM motor controller.  The left and right motor controllers must be Y-cabled, with left motors on channel 0 and right motors on channel 1.  You will also need two joysticks to drive the robot.  One stick is the throttle, which moves the robot forwards and backwards.  The other is the steering, which spins the robot clockwise and counter-clockwise.  You can drive the robot by moving the throttle forwards and backwards and the steering left and right.

It is not advised to drive with one stick, because it becomes really difficult to move forwards and backwards without accidentally turning.  Note that the code applies deadzones to the joysticks, which avoid "phantom sticks" from moving the robot even when you don't touch the stick.  This is a common pnenomenon due to electrical noise and dust inside the joystick.

You can drive the robot by enabling teleop mode from the driver station.
