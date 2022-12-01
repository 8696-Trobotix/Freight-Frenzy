package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name="Test", group="Linear Opmode")
@Autonomous(name="Test", group="Linear Opmode")

public class Wheels extends LinearOpMode {

    private DcMotor rearLeft, rearRight;

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

        // Mutable Variables
        double drive
        double rl, rr, max;

        // Constants
        final double turnSpeedMax = 0.64, imperfect = 1.1;

        while (opModeIsActive()) {

            // Calculations
            rl = drive
            rr = drive
            
            max = Math.max(Math.abs(rl), max);
            max = Math.max(Math.abs(rr), max);
            if (max > 1) {

                rl /= max;
                rr /= max;
            }

            // Act
            rearLeft.setPower(rl);
            rearRight.setPower(rr);
        }
    }
}