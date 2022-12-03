/*
This class detects color and drives the robot forward for a certain amount of seconds.
I plan to make it move until it is a certain distance away from the color.

List of things to do:
    1. Get the robot to move when it sees a particular color
    2. Get the robot to stop moving when it is in a range of distance away from that color
    3. Make the robot move back until it is in the correct range of distance if it is to close to the color

    Bonus: Spin.
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import com.qualcomm.robotcore.util.ElapsedTime;

// Motor and Color sensor imports
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ColorSensor;

// Distance sensor import
import com.qualcomm.robotcore.util.Range;


@Autonomous(name="DriveColor", group="Linear Opmode")
public class DriveColor extends LinearOpMode {

    private DcMotor rearLeft, rearRight;
    private ElapsedTime     runtime = new ElapsedTime();
    private ColorSensor colorSensor;
    private DistanceSensor distanceSensor;

    @Override
    public void runOpMode() {

        // Connect Motors
        rearLeft = hardwareMap.get(DcMotor.class, "rearLeft");
        rearRight = hardwareMap.get(DcMotor.class, "rearRight");
        
        // Connects the color and distance sensors
        colorSensor = hardwareMap.get(ColorSensor.class, "colorSensor");
        distanceSensor= hwMap.get(DistanceSensor.class, "sensor_color_distance");

        // Set Motor Directions
        rearLeft.setDirection(DcMotor.Direction.FORWARD);
        rearRight.setDirection(DcMotor.Direction.FORWARD);

        // Set Motors to Brake
        rearLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Wait
        waitForStart();

        // Moves to show the program is active
        moveRightWheel(0.5, 0.1);
        moveLeftWheel(0.5, 0.1); 

        // Gets the amount of color and then adds together for the total
       double  red = colorSensor.red();
       double green = colorSensor.green();
       double blue = colorSensor.blue();
       double total = red + green + blue; 

       double pred = red / total;
       double pgreen = green / total;
       double pblue = blue / total;

        // Moves in different ways depending on which color the color sensor sees
       if(pred > pgreen && pblue) {

            moveRightWheel(0.5, 3);
            moveLeftWheel(0.5, 3);
       }
        else if(pgreen > pred && pblue) {

            moveRightWheel(-0.5, 0.2);
            moveLeftWheel(-0.5, 0.2);
        }
        else if(pblue > pgreen && pred) {

            moveRightWheel(-0.5, 0.2);
            moveLeftWheel(0.5, 0.2);
        }

    }
    public void moveRightWheel(double power, double timeSecond) {

        rearRight.setPower(power);

        runtime.reset();
        while(opModeIsActive() && runtime.seconds() < timeSecond); 
        rearRight.setPower(0);
    }
    public void moveLeftWheel(double power, double timeSecond) {

        rearLeft.setPower(power);

        runtime.reset();
        while(opModeIsActive() && runtime.seconds() < timeSecond); 
        rearLeft.setPower(0);
    }

    // Gets the distance
    public double getDistance(DistanceUnit du) {

            return distanceSensor.getDistance(du);
    }
}