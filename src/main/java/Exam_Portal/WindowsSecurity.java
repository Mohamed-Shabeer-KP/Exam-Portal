package Exam_Portal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author MOHAMED SHABEER KP
 */
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class WindowsSecurity implements Runnable 
{
 
  private boolean running;
  private JFrame b_frame;
  private DatabaseOp db;

  public WindowsSecurity(JFrame b_frame,DatabaseOp db)
  {
    running=true;
    this.b_frame = b_frame;
    this.db = db;
    new Thread(this).start();
  }
                            
     @Override
    public void run() {
        try {
     
      kill("explorer.exe"); // Kill explorer
      Robot robot = new Robot();
      while (running) {
       db.getData();
       if(db.getAppState() == 0)
       {
         ActionListener taskPerformer = new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent ae) {
             JOptionPane.showMessageDialog(b_frame, "There is no active examination");
                
             try {
                     Runtime.getRuntime().exec("explorer.exe");
                 } catch (IOException ex) {
                     Logger.getLogger(WindowsSecurity.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
        };        
         
        Timer timer = new Timer(100 ,taskPerformer);
        timer.setRepeats(false);
        timer.start();
        Thread.sleep(5000L);
        Runtime.getRuntime().exec("explorer.exe");
        System.exit(0);
       }  
       
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
       kill("Taskmgr.exe");
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
        if(!string.equals("Taskmgr.exe"))
      Runtime.getRuntime().exec("taskkill /F /IM " + string).waitFor();
     else
        {   //  src//Elevate64.exe
        Runtime.getRuntime().exec("TASKKILL /F /IM Taskmgr.exe").waitFor(); 
        }
        } catch (Exception e) {
    }
  }
}

