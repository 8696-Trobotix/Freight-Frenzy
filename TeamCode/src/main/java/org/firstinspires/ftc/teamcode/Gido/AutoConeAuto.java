/*
This program will automatically pick up cones, score cones, and park during auto.

To Do List:
Turning
Distance units
Auto score for loop
Add linear slide
*/

package org.firstinspires.ftc.teamcode.Gido;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
 // Autonomous 

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
 // Motors, servo, distance, and color sensors

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
// Angles

@Autonomous(name="AutoConeAuto", group="Linear Opmode")
public class AutoConeAuto extends LinearOpMode {

    private ElapsedTime     runtime = new ElapsedTime();
    private ColorSensor colorSensor;
    private DistanceSensor distanceSensor;
    private Servo servo;
    public TouchSensor clawRest, magnet;

    @Override
    public void runOpMode() {

        boolean rest, last, now = true;
        int curLevel = 0, toLevel = 0;
        
        clawRest = hardwareMap.get(TouchSensor.class, "clawRest");
        magnet   = hardwareMap.get(TouchSensor.class, "magnet");

        final double openClaw = 0.25, closeClaw = 0.65;

        servo = hwMap.get(Servo.class, "servo");
        public void setServoPosition(double position) {

            servo.setServoPosition(position);
        }
        // Wait
        waitForStart();

        Motors motor = new Motors();

            motor.moveAllWheels(0.5);
        if(pblue > pred && pgreen && pblue) {
            
            motor.moveAllWheels(0.0);
            sleep(100);
            motor.rearLeftWheel(0.3);
            motor.frontLeftWheel(-0.3);
            // motor.slideMotor(0.5);
        /* if(du < 100) {
                
            motor.rearLeftWheel(0.0);
            motor.frontLeftWheel(0.0);
            sleep(100);
            motor.timeAllWheels(0.6, 0.35);
            motor.timeAllWheels(-0.6, -0.35);
            } */// Unit of measurement needs to be specified
            clawRelease(200);
        for(int i = 1; i <= 5; i++) {

                
            }
        } // Scoring for loop
        double  red = colorSensor.red();
        double green = colorSensor.green();
        double blue = colorSensor.blue();
        double total = red + green + blue; 

        double pred = red / total;
        double pgreen = green / total;
        double pblue = blue / total;
    
        public double getDistance(DistanceUnit du) {

        return distanceSensor.getDistance(du);
        } // Gets the distance 
        public void clawRelease(int wait) {

            servo.setServoPosition(openClaw);
            sleep(wait);
            servo.setServoPosition(closeClaw);
        } // Opens the claw waits for a specified amount of time and then closes the claw
        public void slidePos(int pos) {

            if(pos = 1) {


            } else if(pos = 2) {


            }
        }
            
        }
    }
}