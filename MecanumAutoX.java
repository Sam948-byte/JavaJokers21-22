package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="Mecanum Auto III")
public class MecanumAutoX extends LinearOpMode {
   @Override
   
   	
   public void runOpMode() throws InterruptedException {

	  DcMotor front_left = hardwareMap.dcMotor.get("front_left");
	  DcMotor back_left = hardwareMap.dcMotor.get("back_left");
	  DcMotor front_right = hardwareMap.dcMotor.get("front_right");
	  DcMotor back_right = hardwareMap.dcMotor.get("back_right");

	  // Reverse the right side motors
	  // Reverse left motors if you are using NeveRests
	  front_left.setDirection(DcMotor.Direction.REVERSE);
	  back_left.setDirection(DcMotor.Direction.REVERSE);
	  front_right.setDirection(DcMotor.Direction.REVERSE);
	  back_right.setDirection(DcMotor.Direction.REVERSE);

	front_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
	back_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
	front_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
	back_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

	  waitForStart();
	  
	  forward(2000, 1);
	  
   }
   	private void strafeLeft(int time0, int speed0){
   	  
   	DcMotor front_left = hardwareMap.dcMotor.get("front_left");
	  DcMotor back_left = hardwareMap.dcMotor.get("back_left");
	  DcMotor front_right = hardwareMap.dcMotor.get("front_right");
	  DcMotor back_right = hardwareMap.dcMotor.get("back_right");
   	  
  front_left.setPower(-speed0);
  front_right.setPower(speed0);
  back_left.setPower(speed0);
  back_right.setPower(-speed0);
  sleep(time0);
  front_left.setPower(0);
  front_right.setPower(0);
  back_left.setPower(0);
  back_right.setPower(0);
}

private void strafeRight(int time1, int speed1){
  
  DcMotor front_left = hardwareMap.dcMotor.get("front_left");
	  DcMotor back_left = hardwareMap.dcMotor.get("back_left");
	  DcMotor front_right = hardwareMap.dcMotor.get("front_right");
	  DcMotor back_right = hardwareMap.dcMotor.get("back_right");
  
  front_left.setPower(speed1);
  front_right.setPower(-speed1);
  back_left.setPower(-speed1);
  back_right.setPower(speed1);
  sleep(time1);
  front_left.setPower(0);
  front_right.setPower(0);
  back_left.setPower(0);
  back_right.setPower(0);
}

private void forward(int time2, int speed2){
  
  DcMotor front_left = hardwareMap.dcMotor.get("front_left");
	  DcMotor back_left = hardwareMap.dcMotor.get("back_left");
	  DcMotor front_right = hardwareMap.dcMotor.get("front_right");
	  DcMotor back_right = hardwareMap.dcMotor.get("back_right");
  
  front_left.setPower(speed2);
  front_right.setPower(speed2);
  back_left.setPower(speed2);
  back_right.setPower(speed2);
  sleep(time2);
  front_left.setPower(0);
  front_right.setPower(0);
  back_left.setPower(0);
  back_right.setPower(0);
}

private void backward(int time3, int speed3){
  
  DcMotor front_left = hardwareMap.dcMotor.get("front_left");
	  DcMotor back_left = hardwareMap.dcMotor.get("back_left");
	  DcMotor front_right = hardwareMap.dcMotor.get("front_right");
	  DcMotor back_right = hardwareMap.dcMotor.get("back_right");
  
  front_left.setPower(-speed3);
  front_right.setPower(-speed3);
  back_left.setPower(-speed3);
  back_right.setPower(-speed3);
  sleep(time3);
  front_left.setPower(0);
  front_right.setPower(0);
  back_left.setPower(0);
  back_right.setPower(0);
}

private void upLeft(int time4, int speed4){
  
  DcMotor front_left = hardwareMap.dcMotor.get("front_left");
	  DcMotor back_left = hardwareMap.dcMotor.get("back_left");
	  DcMotor front_right = hardwareMap.dcMotor.get("front_right");
	  DcMotor back_right = hardwareMap.dcMotor.get("back_right");
  
  front_right.setPower(speed4);
  back_left.setPower(speed4);
  sleep(time4);
  front_left.setPower(0);
  front_right.setPower(0);
  back_left.setPower(0);
  back_right.setPower(0);
}

private void upRight(int time5, int speed5){
  
  DcMotor front_left = hardwareMap.dcMotor.get("front_left");
	  DcMotor back_left = hardwareMap.dcMotor.get("back_left");
	  DcMotor front_right = hardwareMap.dcMotor.get("front_right");
	  DcMotor back_right = hardwareMap.dcMotor.get("back_right");
  
  front_left.setPower(speed5);
  back_right.setPower(speed5);
  sleep(time5);
  front_left.setPower(0);
  front_right.setPower(0);
  back_left.setPower(0);
  back_right.setPower(0);
}

private void downLeft(int time6, int speed6){
  
  DcMotor front_left = hardwareMap.dcMotor.get("front_left");
	  DcMotor back_left = hardwareMap.dcMotor.get("back_left");
	  DcMotor front_right = hardwareMap.dcMotor.get("front_right");
	  DcMotor back_right = hardwareMap.dcMotor.get("back_right");
  
  front_left.setPower(-speed6);
  back_right.setPower(-speed6);
  sleep(time6);
  front_left.setPower(0);
  front_right.setPower(0);
  back_left.setPower(0);
  back_right.setPower(0);
}

private void downRight(int time7, int speed7){
  
  DcMotor front_left = hardwareMap.dcMotor.get("front_left");
	  DcMotor back_left = hardwareMap.dcMotor.get("back_left");
	  DcMotor front_right = hardwareMap.dcMotor.get("front_right");
	  DcMotor back_right = hardwareMap.dcMotor.get("back_right");
  
  front_right.setPower(-speed7);
  back_left.setPower(-speed7);
  sleep(time7);
  front_left.setPower(0);
  front_right.setPower(0);
  back_left.setPower(0);
  back_right.setPower(0);
}

private void rotateLeft(int time8, int speed8){
  
  DcMotor front_left = hardwareMap.dcMotor.get("front_left");
	  DcMotor back_left = hardwareMap.dcMotor.get("back_left");
	  DcMotor front_right = hardwareMap.dcMotor.get("front_right");
	  DcMotor back_right = hardwareMap.dcMotor.get("back_right");
  
  front_left.setPower(-speed8);
  front_right.setPower(speed8);
  back_left.setPower(-speed8);
  back_right.setPower(speed8);
  sleep(time8);
  front_left.setPower(0);
  front_right.setPower(0);
  back_left.setPower(0);
  back_right.setPower(0);
}

private void rotateRight(int time9, int speed9){
  
  DcMotor front_left = hardwareMap.dcMotor.get("front_left");
	  DcMotor back_left = hardwareMap.dcMotor.get("back_left");
	  DcMotor front_right = hardwareMap.dcMotor.get("front_right");
	  DcMotor back_right = hardwareMap.dcMotor.get("back_right");
  
  front_left.setPower(speed9);
  front_right.setPower(-speed9);
  back_left.setPower(speed9);
  back_right.setPower(-speed9);
  sleep(time9);
  front_left.setPower(0);
  front_right.setPower(0);
  back_left.setPower(0);
  back_right.setPower(0);
}

}


   
