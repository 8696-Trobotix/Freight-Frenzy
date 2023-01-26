/*
This program will automatically pick up cones, score cones, and park during auto.
*/

package org.firstinspires.ftc.teamcode.Gido;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime; // Autonomous 

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor; // Motors, distance and color sensors

@Autonomous(name="AutoConeAuto", group="Linear Opmode")
public class AutoConeAuto extends LinearOpMode {

    private DcMotor rearLeft, rearRight, frontRight, frontLeft;
    private ElapsedTime     runtime = new ElapsedTime();
    private ColorSensor colorSensor;
    private DistanceSensor distanceSensor;
}
@Override
public void runOpMode() {

    // Connect Motors
    rearLeft = hardwareMap.get(DcMotor.class, "rearLeft");
    rearRight = hardwareMap.get(DcMotor.class, "rearRight");
    frontRight = hardwareMap.get(DcMotor.class, "frontRight");
    frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");

    // Set Motor Directions
    rearLeft.setDirection(DcMotor.Direction.FORWARD);
    rearRight.setDirection(DcMotor.Direction.FORWARD);
    frontRight.setDirection(DcMotor.Direction.FORWARD);
    frontLeft.setDirection(DcMotor.Direction.FORWARD);

    // Set Motors to Brake
    rearLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    rearRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.Brake);

    // Wait
    waitForStart();

    boolean run = true;

    while(run) {

        moveAllWheels(0.5);

        if(pblue > pblue && pred && pgreen) {

            if(getDistance(500)) {

                
            }
        } // Moves until it sees a blue cone


    // Gets the amount of color and then adds together for the total
       double  red = colorSensor.red();
       double green = colorSensor.green();
       double blue = colorSensor.blue();
       double total = red + green + blue; 

       double pred = red / total;
       double pgreen = green / total;
       double pblue = blue / total;
    
    public void rearRightWheel(double power) {

        rearRight.setPower(power);

        runtime.reset();
    } // Moves the rear right wheel
    public void frontLeftWheel(double power) {

        rearLeft.setPower(power);

        runtime.reset(); 
    } // Moves the front left wheel
    public void rearLeftWheel(double power) {

        frontLeft.setPower(power);

        runtime.setPower(power)
    } // Moves the rear left wheel
    public void frontRightWheel(double power) {

        frontRight.setPower(power);

        runtime.reset();
    } // Moves the front right wheel
    public void moveAllWheels(double power) {


    } // Moves all of the wheels
    public double getDistance(DistanceUnit du) {

        return distanceSensor.getDistance(du);
    } // Gets the distance
    }
}