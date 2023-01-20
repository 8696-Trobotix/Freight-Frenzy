/*
    The robot can finally feel.
 */
package org.firstinspires.ftc.teamcode.Gido;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous; // Auto


import com.qualcomm.robotcore.hardware.DcMotor; 
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap; // Motor and Sensor

@Autonomous(name="Alive", group="Linear Opmode")
public class Alive extends LinearOpMode {

    private DcMotor rearLeft, rearRight;
    private ElapsedTime     runtime = new ElapsedTime();
    private DigitalChannel touchSensor;
}
@Override
public void runOpMode() {

    // Connect Motors
    rearLeft = hardwareMap.get(DcMotor.class, "rearLeft");
    rearRight = hardwareMap.get(DcMotor.class, "rearRight");

    // Connects the touch sensor
    touchSensor = hardwareMap.get(DigitalChannel.class, "touchSensor");

    // Set Motor Directions
        rearLeft.setDirection(DcMotor.Direction.FORWARD);
        rearRight.setDirection(DcMotor.Direction.FORWARD);

        // Set Motors to Brake
        rearLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Wait
        waitForStart();
        
}