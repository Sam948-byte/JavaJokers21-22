package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import java.util.concurrent.locks.Lock;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import java.util.List;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaCurrentGame;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TfodCurrentGame;

@Autonomous(name = "Red TFOD3 (Blocks to Java)", preselectTeleOp = "TeleOp")
public class Red3 extends LinearOpMode {

  private VuforiaCurrentGame vuforiaUltimateGoal;
  private TfodCurrentGame tfodUltimateGoal;
  private DcMotor Arm;
  private Servo LockGate;
  private DcMotor RightMotor;
  private DcMotor LeftMotor;

  Recognition recognition;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
	List<Recognition> recognitions;
	double index;

	vuforiaUltimateGoal = new VuforiaCurrentGame();
	tfodUltimateGoal = new TfodCurrentGame();
	Arm = hardwareMap.get(DcMotor.class, "Arm");
	LockGate = hardwareMap.get(Servo.class, "Lock Gate");
	RightMotor = hardwareMap.get(DcMotor.class, "Right Motor");
	LeftMotor = hardwareMap.get(DcMotor.class, "Left Motor");

	// Sample TFOD Op Mode
	telemetry.addData(">", "Initializing");
	telemetry.update();
	// Initialize Vuforia.
	vuforiaUltimateGoal.initialize(
		"", // vuforiaLicenseKey
		hardwareMap.get(WebcamName.class, "Webcam"), // cameraName
		"", // webcamCalibrationFilename
		false, // useExtendedTracking
		false, // enableCameraMonitoring
		VuforiaLocalizer.Parameters.CameraMonitorFeedback.AXES, // cameraMonitorFeedback
		0, // dx
		0, // dy
		0, // dz
		90, // xAngle
		0, // yAngle
		90, // zAngle
		true); // useCompetitionFieldTargetLocations
	// Set min confidence threshold to 0.7
	tfodUltimateGoal.initialize(vuforiaUltimateGoal, 0.7F, true, true);
	// Initialize TFOD before waitForStart.
	// Init TFOD here so the object detection labels are visible
	// in the Camera Stream preview window on the Driver Station.
	tfodUltimateGoal.activate();
	// Enable following block to zoom in on target.
	tfodUltimateGoal.setZoom(1.5, 16 / 9);
	telemetry.addData(">", "Press Play to start");
	telemetry.addData("Position", "Inside Left");
	index = 99;
	telemetry.update();
	// Wait for start command from Driver Station.
	waitForStart();
	if (opModeIsActive()) {
	  // Put run blocks here.
	  while (opModeIsActive()) {
		// Put loop blocks here.
		// Get a list of recognitions from TFOD.
		recognitions = tfodUltimateGoal.getRecognitions();
		// If list is empty, inform the user. Otherwise, go
		// through list and display info for each recognition.
		if (recognitions.size() == 0) {
		  telemetry.addData("TFOD", "No items detected.");
		} else {
		  index = 0;
		  // Iterate through list and call a function to
		  // display info for each recognized object.
		  for (Recognition recognition_item : recognitions) {
			recognition = recognition_item;
			// Display info.
			displayInfo(index);
			// Increment index.
			index = index + 1;
		  }
		}
		if (recognitions.size() == 0){
			Configuration_A();
		}
		else if ("Single" == recognition.getLabel()) {
			Configuration_B();
		} else if ("Quad" == recognition.getLabel()) {
			Configuration_C();
		} 
		telemetry.update();
	  }
	}
	// Deactivate TFOD.
	tfodUltimateGoal.deactivate();

	vuforiaUltimateGoal.close();
	tfodUltimateGoal.close();
  }

  /**
   * Describe this function...
   */
  private void Configuration_A() {
  	telemetry.addData("Configuration", "A");
 	telemetry.update();
 	Arm.setPower(1);
 	sleep(500);
	Arm.setPower(-0.3);
	LockGate.setPosition(180);
	sleep(500);
	RightMotor.setPower(-0.8);
	LeftMotor.setPower(1);
	sleep(1800);
	RightMotor.setPower(-1);
	sleep(400);
	RightMotor.setPower(1);
	LeftMotor.setPower(-1);
	LockGate.setPosition(0);
	sleep(300);
	RightMotor.setPower(0);
	LeftMotor.setPower(0);
	Arm.setPower(0);
	sleep(30000);
	telemetry.update();
  }

 private void Configuration_B() {
 	telemetry.addData("Configuration", "B");
 	telemetry.update();
 	Arm.setPower(1);
 	sleep(500);
	Arm.setPower(-0.3);
	LockGate.setPosition(180);
	sleep(500);
	RightMotor.setPower(-1);
	LeftMotor.setPower(1);
	sleep(1300);
	RightMotor.setPower(-0.9);
	LeftMotor.setPower(1);
	sleep(700);
	RightMotor.setPower(1);
	LeftMotor.setPower(-1);
	LockGate.setPosition(0);
	sleep(300);
	RightMotor.setPower(0);
	LeftMotor.setPower(0);
	Arm.setPower(0);
	sleep(30000);
	telemetry.update();
  }

 private void Configuration_C() {
 	telemetry.addData("Configuration", "C");
 	telemetry.update();
 	Arm.setPower(1);
 	sleep(500);
	Arm.setPower(-0.3);
	LockGate.setPosition(180);
	sleep(500);
	RightMotor.setPower(-1);
	LeftMotor.setPower(1);
	sleep(1700);
	RightMotor.setPower(-0.8);
	LeftMotor.setPower(1);
	sleep(1900);
	RightMotor.setPower(0);
	LeftMotor.setPower(0);
	LockGate.setPosition(0);
	sleep(300);
	Arm.setPower(0);
	sleep(100);
	RightMotor.setPower(1);
	LeftMotor.setPower(-1);
	sleep(1100);
	RightMotor.setPower(0);
	LeftMotor.setPower(0);
	sleep(30000);
	telemetry.update();
  }

  /**
   * Display info (using telemetry) for a recognized object.
   */
  private void displayInfo(double i) {
	// Display label info.
	// Display the label and index number for the recognition.
	telemetry.addData("label " + i, recognition.getLabel());
	// Display upper corner info.
	// Display the location of the top left corner
	// of the detection boundary for the recognition
	telemetry.addData("Left, Top " + i, recognition.getLeft() + ", " + recognition.getTop());
	// Display lower corner info.
	// Display the location of the bottom right corner
	// of the detection boundary for the recognition
	telemetry.addData("Right, Bottom " + i, recognition.getRight() + ", " + recognition.getBottom());
  }
}
