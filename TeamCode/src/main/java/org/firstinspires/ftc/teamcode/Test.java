/*

Test

Current Status: Just a Mecanum drive.

*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name="Test", group="Linear Opmode")
// @Autonomous(name="Test", group="Linear Opmode")

public class Test extends LinearOpMode {

    private DcMotor frontLeft, frontRight, rearLeft, rearRight;

    @Override
    public void runOpMode() {
        // Connect Motors
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        rearLeft = hardwareMap.get(DcMotor.class, "rearLeft");
        rearRight = hardwareMap.get(DcMotor.class, "rearRight");

        // Set Motor Directions
        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        rearLeft.setDirection(DcMotor.Direction.FORWARD);
        rearRight.setDirection(DcMotor.Direction.FORWARD);

        // Set Motors to Brake
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Wait
        waitForStart();

        // Mutable Variables
        double drive, strafe, turn;
        double fl, fr, rl, rr, max;

        // Constants
        final double turnSpeedMax = 0.64, imperfect = 1.1;

        while (opModeIsActive()) {
            // Controller
            drive = -gamepad1.left_stick_y;
            strafe = gamepad1.left_stick_x * imperfect;
            turn = gamepad1.right_stick_x * turnSpeedMax;

            // Calculations
            fl = drive + strafe + turn;
            fr = drive - strafe - turn;
            rl = drive - strafe + turn;
            rr = drive + strafe - turn;
            
            max = Math.max(Math.abs(fl), Math.abs(fr));
            max = Math.max(Math.abs(rl), max);
            max = Math.max(Math.abs(rr), max);
            if (max > 1) {
                fl /= max;
                fr /= max;
                rl /= max;
                rr /= max;
            }

            // Act
            frontLeft.setPower(fl);
            frontRight.setPower(fr);
            rearLeft.setPower(rl);
            rearRight.setPower(rr);
        }
    }
}
