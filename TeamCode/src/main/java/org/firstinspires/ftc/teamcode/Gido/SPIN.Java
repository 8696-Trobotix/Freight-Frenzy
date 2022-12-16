/*
… If I, I get to know your name
Well, if I could trace your private number, baby
… All I know is that to me
You look like you're lots of fun
Open up your lovin' arms
I want some, want some
… I set my sights on you
(And no one else will do)
And I, I've got to have my way now, baby
… All I know is that to me
You look like you're havin' fun
Open up your lovin' arms
Watch out, here I come
… You spin me right 'round, baby, right 'round
Like a record, baby, right 'round, 'round, 'round
You spin me right 'round, baby, right 'round
Like a record, baby, right 'round, 'round, 'round
… I (I, I, I), I got to be your friend now, baby
And I (I, I, I) would like to move in just a little bit closer
(To move in just a little bit closer)
… All I know is that to me
You look like you're lots of fun
Open up your lovin' arms
Watch out, here I come
… You spin me right 'round, baby, right 'round
Like a record, baby, right 'round, 'round, 'round
You spin me right 'round, baby, right 'round
Like a record, baby, right 'round, 'round, 'round
… I want your love
I want your love
… All I know is that to me
You look like you're lots of fun
Open up your lovin' arms
Watch out, here I come
… You spin me right 'round, baby, right 'round
Like a record, baby, right 'round, 'round, 'round
You spin me right 'round, baby, right 'round
Like a record, baby, right 'round, 'round, 'round
… You spin me right 'round, baby, right 'round
Like a record, baby, right 'round, 'round, 'round (I want your love)
You spin me right 'round, baby, right 'round
Like a record, baby, right 'round, 'round, 'round (I want your love)
… You spin me right 'round, baby, right 'round (I need your love)
Like a record, baby, right 'round, 'round, 'round (I need your love)
You spin me right 'round, baby, right 'round
Like a record, baby, right 'round, 'round, 'round (I need your love)
You spin me right 'round, baby, right 'round
*/

package org.firstinspires.ftc.teamcode.Gido;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="SPIN", group="Linear Opmode")
public class SPIN extends LinearOpMode {

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

        // Wait
        waitForStart();

        // Spins
        moveRightWheel(0.5, -20);
        moveLeftWheel(0.5, 20); 
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