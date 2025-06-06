package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp()
public class ServoTest extends LinearOpMode {
    public void runOpMode() throws InterruptedException {
        Servo servo = hardwareMap.get(Servo.class, "servo");
        ElapsedTime timer = new ElapsedTime();
        servo.setPosition(0);
        servo.setDirection(Servo.Direction.FORWARD);
        waitForStart();
        if (isStopRequested()) {return;}
        timer.reset();
        while (opModeIsActive()){
            if (timer.milliseconds()>250){
                if(gamepad1.dpad_up){
                    servo.setPosition(servo.getPosition()+0.1);
                }
                else if (gamepad1.dpad_down){
                    servo.setPosition(servo.getPosition()-0.1);
                }
                else if (gamepad1.dpad_right) {
                    servo.setPosition(servo.getPosition() + 0.01);
                }
                else if (gamepad1.dpad_left){
                    servo.setPosition(servo.getPosition()-0.01);
                }
                timer.reset();
            }
            if (gamepad1.right_trigger>0){
                servo.setDirection(Servo.Direction.FORWARD);
            }
            else if (gamepad1.left_trigger>0){
                servo.setDirection(Servo.Direction.REVERSE);
            }
            telemetry.addData("Position", servo.getPosition());
            telemetry.update();
        }
    }


}