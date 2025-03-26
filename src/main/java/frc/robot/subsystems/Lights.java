// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.led.Animation;
import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.CANdle.LEDStripType;
import com.ctre.phoenix.led.CANdleConfiguration;
import com.ctre.phoenix.led.ColorFlowAnimation;
import com.ctre.phoenix.led.FireAnimation;
import com.ctre.phoenix.led.LarsonAnimation;
import com.ctre.phoenix.led.RainbowAnimation;
import com.ctre.phoenix.led.StrobeAnimation;
import com.ctre.phoenix.led.TwinkleAnimation;

/** Add your docs here. */
public class Lights {
  private static Lights instance;
  private CANdle candle;
  private int  totalLEDS = 60;
  private boolean animateDir = false;
  public enum AnimationTypes {
    BLUE,
    RED,
    Empty,
    ColorFlow,
    Fire,
    Larson,
    Rainbow,
    RgbFade,
    SingleFade,
    Strobe,
    Twinkle,
    TwinkleOff,
    SetAll,
    Coral,
    Algae,
    L4
  
}
  private Lights(){
    candle = new CANdle(6);
    // Configure the CANdle
    CANdleConfiguration config = new CANdleConfiguration();
      config.brightnessScalar = 1.0;
      config.stripType = LEDStripType.RGB;
    candle.configAllSettings(config);
  }
  public static Lights getInstance()
  {
      if (instance == null) {
          synchronized (Lights.class) {
              if (instance == null) {
                  instance = new Lights();
              }
          }
      }
      return instance;
  }     
  public void setPattern(AnimationTypes animation){
    Animation toAnimate = null;
    switch (animation) {
      case L4:
        toAnimate = new LarsonAnimation(255,30,0,0, 0.25,68, LarsonAnimation.BounceMode.Back,8, 8);
        break;
      case RED:
        toAnimate = new TwinkleAnimation(255, 0, 0, 0, 0.75, 68, TwinkleAnimation.TwinklePercent.Percent88, 0 );
        break;
      case BLUE:
        toAnimate = new TwinkleAnimation(0, 0, 255, 0, 0.75, 68, TwinkleAnimation.TwinklePercent.Percent88, 0 );
        break;
      case Algae:
        toAnimate = new ColorFlowAnimation(0, 255, 0, 0, 0.5, 68, ColorFlowAnimation.Direction.Forward, 0);
        break;
      case Coral:
        toAnimate = new ColorFlowAnimation(0, 255, 0, 0, 0.5, 68, ColorFlowAnimation.Direction.Forward, 0);
        break;
    }
      candle.animate(toAnimate,0);
    
  }
}
