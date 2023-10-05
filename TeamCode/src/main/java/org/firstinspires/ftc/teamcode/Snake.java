package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Snake", group="Linear Opmode")
@Disabled
public class Snake extends LinearOpMode {
    @Override
    public void runOpMode() {
        telemetry.log().add("PRESS START TO PLAY SNAKE");
        waitForStart();
        telemetry.speak("Three, two, one, go!");
        int scrnRows = 10, scrnCols = 10, maxFood = 1, rate = 1000;
        telemetry.log().setCapacity(scrnRows);
        int [][] screen = new int [scrnRows][scrnCols];
        int headRow = scrnRows / 2, headCol = scrnCols / 2;
        int length = 1, food = 0;
        boolean [] lastAction = {false, false, false, false};
        while (opModeIsActive()) {
            boolean [] action = {gamepad1.dpad_up, gamepad1.dpad_down, gamepad1.dpad_left, gamepad1.dpad_right};
            if (action[0] || lastAction[0]) {
                --headRow;
            } else if (action[1] || lastAction[1]) {
                ++headRow;
            } else if (action[2] || lastAction[2]) {
                --headCol;
            } else if (action[3] || lastAction[3]) {
                ++headCol;
            }
            lastAction = action;
            for (int [] row : screen) {
                for (int i = 0; i < scrnCols; ++i) {
                    if (row[i] > 0) {
                        --row[i];
                    }
                }
            }
            if (screen[headRow][headCol] > 0 ||
                headRow < 0 || headRow >= scrnRows ||
                headCol < 0 || headCol >= scrnCols) {
                telemetry.log().add("GAME OVER");
                telemetry.speak("Game over! Better luck next time.");
                break;
            } else if (screen[headRow][headCol] == -1) {
                ++length;
                --food;
                for (int [] row : screen) {
                    for (int i = 0; i < scrnCols; ++i) {
                        ++row[i];
                    }
                }
            }
            if (food < maxFood) {
                int foodRow = (int)(Math.random() * scrnRows), foodCol = (int)(Math.random() * scrnCols);
                if (screen[foodRow][foodCol] == 0) {
                    screen[foodRow][foodCol] = -1;
                }
            }
            screen[headRow][headCol] = length;
            String [] display = new String [scrnRows];
            for (int i = 0; i < scrnRows; ++i) {
                for (int j = 0; j < scrnCols; ++j) {
                    int cell = screen[i][j];
                    display[i] += (cell != 0 ? (cell > 0 ? 'S' : 'O') : ' ');
                }
            }
            telemetry.clear();
            for (String line : display) {
                telemetry.log().add(line);
            }
            sleep(rate);
        }
    }
}
