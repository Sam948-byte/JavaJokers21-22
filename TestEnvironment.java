package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "TestEnvironment (Blocks to Java)")
public class TestEnvironment extends LinearOpMode {

  private DcMotor RightMotor;
  private DcMotor Arm;
  private Servo LockGate;
  private DcMotor LeftMotor;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
	RightMotor = hardwareMap.get(DcMotor.class, "Right Motor");
	Arm = hardwareMap.get(DcMotor.class, "Arm");
	LockGate = hardwareMap.get(Servo.class, "Lock Gate");
	LeftMotor = hardwareMap.get(DcMotor.class, "Left Motor");

	// Put initialization blocks here.
	RightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
	waitForStart();
	if (opModeIsActive()) {
	  // Put run blocks here.
	  while (opModeIsActive()) {
		// Put loop blocks here.
		Configuration_X();
		telemetry.update();
	  }
	}
  }

  /**
   * Describe this function...
   */
  private void Configuration_X() {
	Arm.setPower(-0.3);
	LockGate.setPosition(180);
	sleep(500);
	RightMotor.setPower(1);
	LeftMotor.setPower(1);
	sleep(1350);
	RightMotor.setPower(0);
	LeftMotor.setPower(0.7);
	sleep(500);
	RightMotor.setPower(0);
	LeftMotor.setPower(0);
	sleep(30000);
	telemetry.update();
  }
}
