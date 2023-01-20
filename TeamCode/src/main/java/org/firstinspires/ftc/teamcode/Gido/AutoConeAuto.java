// Currently only the motors and 4 wheels are programmed

package org.firstinspires.ftc.teamcode.Gido;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime; // Autonomous 

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ColorSensor; // Motor and color

@Autonomous(name="AutoConeAuto", group="Linear Opmode")
public class AutoConeAuto extends LinearOpMode {

    private DcMotor rearLeft, rearRight, frontRight, frontLeft;
    private ElapsedTime     runtime = new ElapsedTime();
    private DigitalChannel colorSensor;
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

    // Moves to show the program is active
    moveRightWheel(0.5, 0.1);
    moveLeftWheel(0.5, 0.1); 
    
    public void moveRightWheel(double power, double timeSecond) {

        rearRight.setPower(power);
        frontRight.setPower(power);

        runtime.reset();
        while(opModeIsActive() && runtime.seconds() < timeSecond); 
        rearRight.setPower(0);
        frontRight.setPower(0);
    }
    public void moveLeftWheel(double power, double timeSecond) {

        rearLeft.setPower(power);
        frontLeft.setPower(power);

        runtime.reset();
        while(opModeIsActive() && runtime.seconds() < timeSecond); 
        rearLeft.setPower(0);
        frontLeft.setPower(0);
    }
}