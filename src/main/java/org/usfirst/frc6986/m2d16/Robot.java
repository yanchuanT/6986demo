// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6986.m2d16;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc6986.m2d16.commands.*;
import org.usfirst.frc6986.m2d16.subsystems.*;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import java.math.BigDecimal;
import edu.wpi.first.wpilibj.Compressor;

import com.analog.adis16448.frc.ADIS16448_IMU;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {

    Command autonomousCommand;
    SendableChooser<Command> chooser = new SendableChooser<>();
    

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DriveTrain driveTrain;
    public static Elevator elevator;
    public static Claw claw;
    public static TrackPanelTest trackPanelTest;
    private Compressor compressor;

    public static final ADIS16448_IMU imu = new ADIS16448_IMU();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrain = new DriveTrain();
        SmartDashboard.putData(driveTrain);
        elevator = new Elevator();
        SmartDashboard.putData(elevator);
        claw = new Claw();
        SmartDashboard.putData(claw);
        compressor = new Compressor(0);

        trackPanelTest = new TrackPanelTest();

        

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // Add commands to Autonomous Sendable Chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        SmartDashboard.putData("Auto mode", chooser);

        new Thread(() -> {
			UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
			camera.setResolution(640, 480);
			camera.setFPS(30);

//			CvSink cvSink = CameraServer.getInstance().getVideo();
//			CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 640,
//			480);
//			Mat source = new Mat();
//			Mat output = new Mat();
//			while(true) {
//			cvSink.grabFrame(source);
//			Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
//			outputStream.putFrame(output);
//			}
		}).start();


    }

    @Override 
    public void robotPeriodic() {

       // imu.reset();
        


        double Roll = imu.getRoll();
        BigDecimal b = new BigDecimal(Roll);
        double Roll2 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        double AccelX = imu.getAccelX();
        BigDecimal c = new BigDecimal(AccelX);
        double AccelX2 = c.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        double AccelY = imu.getAccelY();
        BigDecimal d = new BigDecimal(AccelY);
        double AccelY2 = d.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        double GyroX = imu.getAngleX();
        BigDecimal e = new BigDecimal(GyroX);
        double GyroX2 = e.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        double GyroY = imu.getAngleY();
        BigDecimal f = new BigDecimal(GyroY);
        double GyroY2 = f.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        double GyroZ = imu.getAngleZ();
        BigDecimal g = new BigDecimal(GyroZ);
        double GyroZ2 = g.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        double GyroA = imu.getAngle();
        BigDecimal h = new BigDecimal(GyroA);
        double GyroA2 = h.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        double Temperature = imu.getTemperature();
        BigDecimal i = new BigDecimal(Temperature);
        double Temperature2 = i.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();



        SmartDashboard.putNumber("Gyro-X", GyroX2);
        SmartDashboard.putNumber("Gyro-Y", GyroY2);
        SmartDashboard.putNumber("Gyro-Z", GyroZ2);
        SmartDashboard.putNumber("Gyro", GyroA2);

        SmartDashboard.putNumber("Accel-X", AccelX2);
        SmartDashboard.putNumber("Accel-Y", AccelY2);
        //SmartDashboard.putNumber("Accel-Z", imu.getAccelZ());

        //SmartDashboard.putNumber("Pitch", imu.getPitch());
        SmartDashboard.putNumber("Roll", Roll2);
      
        //SmartDashboard.putNumber("Yaw", imu.getYaw());

       // System.out.println(imu.getAccelX());
       // System.out.println(imu.getAccelY());

        //SmartDashboard.putNumber("Pressure: ", imu.getBarometricPressure());
          SmartDashboard.putNumber("Temperature: ", Temperature2); 
}

    

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        autonomousCommand = chooser.getSelected();
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
}
