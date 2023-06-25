/*
Iowa City Math Circle Outreach

Outreach program for ~6th graders.

*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp(name="Iowa City Math Circle Outreach", group="Linear Opmode")

public class IowaCityMathCircleOutreach extends LinearOpMode {

    private DcMotor motor;
    private DistanceSensor distanceSensor;
    private ColorSensor colorSensor;

    @Override
    public void runOpMode() {

        telemetry.addLine("Running");
        telemetry.update();

        motor = hardwareMap.get(DcMotor.class, "motor");
        motor.setDirection(DcMotor.Direction.FORWARD);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        distanceSensor = hardwareMap.get(DistanceSensor.class, "distanceSensor");
        colorSensor = hardwareMap.get(ColorSensor.class, "colorSensor");

        String [] messages = {
                "Motor connected.",
                "Encoder connected.",
                "Distance sensor connected.",
                "Color sensor connected.",
                "Ready for operation."
        };
        for (String msg : messages) {
            telemetry.addLine(msg);
        }
        telemetry.update();
        for (String msg : messages) {
            telemetry.speak(msg);
            sleep(1500);
        }

        waitForStart();

        int lastMotorPosition = 0;

        while (opModeIsActive()) {
            double power = -gamepad1.left_stick_y;
            boolean a = gamepad1.a;
            boolean [] buttonRGB = {gamepad1.x, gamepad1.y, gamepad1.b};
            boolean xyb = buttonRGB[0] || buttonRGB[1] || buttonRGB[2];

            int currentMotorPos = (int)(motor.getCurrentPosition() / 8192.0 * 360.0);
            double distance = distanceSensor.getDistance(DistanceUnit.CM);
            int [] rgb = {colorSensor.red(), colorSensor.green(), colorSensor.blue()};
            for (int i = 0; i < 3; ++i) {
                rgb[i] = (int)(rgb[i] / 20000.0 * 100.0);
            }
            if (a) {
                power = distance / 819.10;
            } else if (xyb) {
                for (int i = 0; i < 3; ++i) {
                    if (buttonRGB[i]) {
                        power = rgb[i] / 100.0;
                        break;
                    }
                }
            }
            motor.setPower(power);

            if (currentMotorPos != lastMotorPosition && !a && !xyb) {
                telemetry.log().add("Motor Position: %d %s", currentMotorPos, "degrees.");
                lastMotorPosition = currentMotorPos;
            } else if (a) {
                telemetry.log().add("Distance: %.2f %s", distance, "cm.");
            } else if (xyb) {
                telemetry.log().add("Colors Detected: Red (%d), Green (%d), Blue (%d)", rgb[0], rgb[1], rgb[2]);
            }
        }
    }
}
