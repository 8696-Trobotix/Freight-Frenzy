package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name="Wheels", group="Linear Opmode")

public class Wheels extends LinearOpMode {

    private DcMotor rearLeft, rearRight;

    private ElapsedTime     runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        // Connect Motors
        rearLeft = hardwareMap.get(DcMotor.class, "rearLeft");
        rearRight = hardwareMap.get(DcMotor.class, "rearRight");

        // Set Motor Directions
        rearLeft.setDirection(DcMotor.Direction.FORWARD);
        rearRight.setDirection(DcMotor.Direction.FORWARD);

        // Set Motors to Brake
        rearLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Wait
        waitForStart();

        moveRightWheel(0.5, 2);
        moveLeftWheel(0.5, 2);

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
}