package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="MecanumSlow")
public class MecanumSlow extends LinearOpMode {
   @Override
   public void runOpMode() throws InterruptedException {
	  // Declare our motors
	  // Make sure your ID's match your configuration
	  DcMotor motorFrontLeft = hardwareMap.dcMotor.get("front_left");
	  DcMotor motorBackLeft = hardwareMap.dcMotor.get("back_left");
	  DcMotor motorFrontRight = hardwareMap.dcMotor.get("front_right");
	  DcMotor motorBackRight = hardwareMap.dcMotor.get("back_right");

	  // Reverse the right side motors
	  // Reverse left motors if you are using NeveRests
	  motorFrontLeft.setDirection(DcMotor.Direction.REVERSE);
	  motorBackLeft.setDirection(DcMotor.Direction.REVERSE);

	  waitForStart();

	  if (isStopRequested()) return;

	  while (opModeIsActive()) {
		 double rx = -gamepad1.left_stick_y; // Remember, this is reversed!
		 double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
		 double y = gamepad1.right_stick_x;

		 double frontLeftPower = y + x + rx;
		 double backLeftPower = y - x + rx;
		 double frontRightPower = y - x - rx;
		 double backRightPower = y + x - rx;

		 // Put powers in the range of -1 to 1 only if they aren't already
		 // Not checking would cause us to always drive at full speed
		 if (Math.abs(frontLeftPower) > 1 || Math.abs(backLeftPower) > 1 ||
			Math.abs(frontRightPower) > 1 || Math.abs(backRightPower) > 1) {
			// Find the largest power
			double max = 0;
			max = Math.max(Math.abs(frontLeftPower), Math.abs(backLeftPower));
			max = Math.max(Math.abs(frontRightPower), max);
			max = Math.max(Math.abs(backRightPower), max);

			// Divide everything by max (it's positive so we don't need to worry
			// about signs)
			frontLeftPower /= max;
			backLeftPower /= max;
			frontRightPower /= max;
			backRightPower /= max;
		 }

		 motorFrontLeft.setPower(frontLeftPower * 0.25);
		 motorBackLeft.setPower(backLeftPower * 0.25);
		 motorFrontRight.setPower(frontRightPower * 0.25);
		 motorBackRight.setPower(backRightPower * 0.25);
		
	  }
   }
   }
