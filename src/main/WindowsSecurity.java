/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author MOHAMED SHABEER KP
 */
import java.awt.Robot;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class WindowsSecurity implements Runnable 
{
  public JPanel frame;
  public boolean running;

  public WindowsSecurity(JPanel yourFrame)
  {
    frame = yourFrame;
    //running=true;
    new Thread(this).start();
  }

  public void stop()
  {
     this.running = false;
  }

  @Override
  public void run() {
    try {
    //  frame.getParentFrame().setAlwaysOnTop(true);
     
      //this.terminal.getParentFrame().setDefaultCloseOperation(0);
      kill("explorer.exe"); // Kill explorer
      Robot robot = new Robot();
      int i = 0;
      while (running) {
         sleep(30L);
         focus();
         releaseKeys(robot);
         sleep(15L);
         focus();
         if (i++ % 10 == 0) {
             kill("taskmgr.exe");
         }
         focus();
         releaseKeys(robot);
         
      }
      
      Runtime.getRuntime().exec("explorer.exe"); // Restart explorer
    } catch (Exception e) {

    }
  }

  private void releaseKeys(Robot robot) {
    robot.keyRelease(17);
    robot.keyRelease(18);
    robot.keyRelease(127);
    robot.keyRelease(524);
    robot.keyRelease(9);
  }

  private void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (Exception e) {

    }
  }

  private void kill(String string) {
    try {
      Runtime.getRuntime().exec("taskkill /F /IM " + string).waitFor();
    } catch (Exception e) {
    }
  }

  private void focus() {
      


frame.requestFocus();
  }
}

