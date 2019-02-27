/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc6986.m2d16;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc6986.m2d16.Robot;
import org.usfirst.frc6986.m2d16.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

//import static org.junit.Assume.assumeNoException;

import java.sql.Time;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;

/**
 * Add your docs here.
 */
public class RobotMap {
    public static WPI_TalonSRX talonSRX1;
    public static WPI_TalonSRX talonSRX2;
    public static SpeedControllerGroup speedControllerGroupElevate;
    public static Encoder encoder8;
    public static DigitalInput limitSwitch;

    public static void init(){


        limitSwitch = new DigitalInput(1); 
        encoder8 = new Encoder(8, 9);
        SmartDashboard.putData("EncoderElevate", encoder8);
        talonSRX1 = new WPI_TalonSRX(6);
        
        
        
        talonSRX2 = new WPI_TalonSRX(7);
        
        
           
        
        speedControllerGroupElevate = new SpeedControllerGroup(talonSRX1, talonSRX2  );

    }
}