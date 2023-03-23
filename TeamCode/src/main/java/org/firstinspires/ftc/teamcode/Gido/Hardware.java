/*
This class is meant for hardware stuff so that instead of making the same objects over and over
I can just get them from here.
*/

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="Hardware", group="Linear Opmode")
public class Hardware extends LinearOpMode { 

    private DcMotor rearLeft, rearRight, frontRight, frontLeft, slideMotor;
    private ElapsedTime     runtime = new ElapsedTime();
}
public void runOpMode() {
    // Connect Motors
    rearLeft = hardwareMap.get(DcMotor.class, "rearLeft");
    rearRight = hardwareMap.get(DcMotor.class, "rearRight");
    frontRight = hardwareMap.get(DcMotor.class, "frontRight");
    frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
    slideMotor = hardwareMap.get(DcMotor.class, "slideMotor");

    // Set Motor Directions
    rearLeft.setDirection(DcMotor.Direction.FORWARD);
    rearRight.setDirection(DcMotor.Direction.FORWARD);
    frontRight.setDirection(DcMotor.Direction.FORWARD);
    frontLeft.setDirection(DcMotor.Direction.FORWARD);
    slideMotor.setDirection(DcMotor.Direction.FORWARD);

    // Set Motors to Brake
    rearLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    rearRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.Brake);
    slideMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.Brake);

    // Non-timed methods
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

        frontRight.setPower(power);
        frontLeft.setPower(power);
        rearRight.setPower(power);
        rearLeft.setPower(power);

        runtime.reset();
    } // Moves all of the wheels
    public void slideMotor(double power) {

        slideMotor.setPower(power);
    } // sets the power of the slide motor

    // Timed methods
    public void timeRearRightWheel(double power, double timeSecond) {

        rearRight.setPower(power);
        runtime.reset();
        while(opModeIsActive() && runtime.seconds() < timeSecond); 
        rearRight.setPower(0);
    } // Moves the rear right wheel for a certain amount of time
    public void timeFrontRightWheel(double power, double timeSecond) {

        frontRight.setPower(power);
        runtime.reset();
        while(opModeIsActive() && runtime.seconds() < timeSecond); 
        frontRight.setPower(0);
    } // Moves the front right wheel for a certain amount of time
    public void timeRearLeftWheel(double power, double timeSecond) {

        rearLeft.setPower(power);
        runtime.reset();
        while(opModeIsActive() && runtime.seconds() < timeSecond); 
        rearLeft.setPower(0);
    } // Moves the rear left wheel for a certain amount of time
    public void timeFrontLeftWheel(double power, double timeSecond) {

        frontLeft.setPower(power);
        runtime.reset();
        while(opModeIsActive() && runtime.seconds() < timeSecond); 
        frontLeft.setPower(0);
    } // Moves the front left wheel for a certain amount of time
    public void timeAllWheels(double power, double timeSecond) {

        rearLeft.setPower(power);
        rearRight.setPower(power);
        frontLeft.setPower(power);
        frontRight.setPower(power);
        runtime.reset();
        while(opModeIsActive() && runtime.seconds() < timeSecond); 
        rearLeft.setPower(0);
        rearRight.setPower(0);
        frontLeft.setPower(0);
        frontRight.setPower(0);
    } // Moves all of the wheels for a certain amount of time   
}