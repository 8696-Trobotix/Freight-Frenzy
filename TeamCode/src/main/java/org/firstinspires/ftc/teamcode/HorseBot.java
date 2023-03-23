/*
HorseBot

Current Status: For the outreach horse-head robot.

*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Horse Bot", group="Linear Opmode")

public class HorseBot extends LinearOpMode {

    private DcMotor     leftMotor, rightMotor;
    private Servo       head;
    private ElapsedTime runtime = new ElapsedTime ();

    // Constant
    final double INC    = 0.1;
    final int    DELAY  = 30;
    final int    RUMBLE = 1000;

    @Override
    public void runOpMode() {
        // Connect Motors
        leftMotor = hardwareMap.get(DcMotor.class, "left");
        rightMotor = hardwareMap.get(DcMotor.class, "right");

        // Connect Head
        head = hardwareMap.get(Servo.class, "head");

        // Set Motor Directions
        leftMotor.setDirection(DcMotor.Direction.FORWARD);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        // Set Motors to Brake
        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        // Mutable Variables
        double leftPower, rightPower;
        double headpos = head.getPosition();

        while (opModeIsActive()) {
            // Controller
            leftPower = -gamepad1.left_stick_y;
            rightPower = -gamepad1.right_stick_y;
            if (gamepad1.left_bumper) {
                headpos -= INC;
                telemetry.speak("Nay!");
                while (gamepad1.left_bumper) idle(); // Crude way to make it increment only once.
            } else if (gamepad1.right_bumper) {
                headpos += INC;
                telemetry.speak("Yay!");
                while (gamepad1.right_bumper) idle(); // Here too. Not going to bother with extra logic.
            }

            // Act
            leftMotor.setPower(leftPower);
            rightMotor.setPower(rightPower);
            head.setPosition(headpos);
            if (runtime.seconds() > DELAY) {
                runtime.reset();
                telemetry.speak("Whoo!");
                gamepad1.rumble(RUMBLE);
            }
        }
    }
}
