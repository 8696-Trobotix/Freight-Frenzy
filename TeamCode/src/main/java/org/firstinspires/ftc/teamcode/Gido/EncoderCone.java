package org.firstinspires.ftc.teamcode.Gido;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
 // Autonomous 

import com.qualcomm.robotcore.hardware.DcMotor;
// Motor

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AngularVelocity;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles
// Pretty sure this is angle stuff I need for turning

@Autonomous(name="EncoderCone", group="Linear Opmode")
public class AutoConeAuto extends LinearOpMode {

    private ElapsedTime     runtime = new ElapsedTime(); 


    }
@Override
public void runOpMode() {

    Motors motor = new Motors();

    motor.rearLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    motor.rearRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    motor.frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    motor.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    // Puts motors in encoder mode

    motor.rearLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    motor.rearRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    motor.frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    motor.frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    telemetry.addData("Starting at",  "%7d :%7d",n motor.rearLeft.getCurrentPosition(), 
    motor.rearRight.getCurrentPosition(), 
    motor.frontLeft.getCurrentPosition(), motor.frontRight.getCurrentPosition());
    telemetry.update();

    // Wait
    waitForStart();

        public void encoderDrive(double speed, double leftInches, 
        double rightInches, double timeoutS) {

        int newLeftTarget;
        int newRightTarget;

        // Ensure that the opmode is still active
        if (opModeIsActive()) {

            // Determine new target position, and pass to motor controller
            newLeftTarget = motor.rearLeft.getCurrentPosition() && motor.frontLeft.getCurrentPosition()
             + (int)(leftInches * COUNTS_PER_INCH);
            newRightTarget = motor.rearRight.getCurrentPosition() && motor.frontRight.getCurrentPosition()
             + (int)(rightInches * COUNTS_PER_INCH);
            motor.rearRight.setTargetPosition(newLeftTarget);
            motor.rearLeft.setTargetPosition(newRightTarget);
            motor.frontRight.setTargetPosition(newLeftTarget);
            motor.frontLeft.setTargetPosition(newRightTarget);

            // Turn On RUN_TO_POSITION
            motor.rearRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motor.rearLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motor.frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motor.frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // reset the timeout time and start motion.
            runtime.reset();
            motor.rearRight.setPower(Math.abs(speed));
            motor.rearLeft.setPower(Math.abs(speed));
            motor.frontRight.setPower(Math.abs(speed));
            motor.frontLeft.setPower(Math.abs(speed));

            while (opModeIsActive() && (runtime.seconds() < timeoutS) &&
            (motor.rearRight.isBusy() && motor.rearLeft.isBusy() && motor.frontRight.isBusy()
            && motor.frontLeft.isBusy())) {

                // Display it for the driver.
                telemetry.addData("Running to",  " %7d :%7d", newLeftTarget,  newRightTarget);
                telemetry.addData("Currently at",  " at %7d :%7d",
                motor.rearRight.getCurrentPosition(), motor.rearLeft.getCurrentPosition(),
                motor.frontRight.getCurrentPosition(), motor.frontLeft.getCurrentPosition());
                telemetry.update();
            }

            // Stop all motion;
            motor.rearLeft.setPower(0);
            motor.rearRight.setPower(0);
            motor.frontLeft.setPower(0);
            motor.frontRight.setPower(0);

            // Turn off RUN_TO_POSITION
            motor.rearLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            motor.rearRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            motor.frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            motor.frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            sleep(250);   // optional pause after each move.
        }
    }

}
