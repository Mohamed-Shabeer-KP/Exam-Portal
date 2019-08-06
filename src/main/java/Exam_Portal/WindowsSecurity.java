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
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Thread.sleep;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class WindowsSecurity implements Runnable 
{
 
  private boolean running;
  private JFrame b_frame;
  private DatabaseOp db;
  private JLabel con_label;
  private JButton exambutton;
  private int internetcon_flag;

  public WindowsSecurity(JFrame b_frame,DatabaseOp db,JLabel con_label,JButton exambutton)
  {
    running=true;
    internetcon_flag = 2;
    this.b_frame = b_frame;
    this.db = db;
    this.con_label = con_label;
    this.exambutton = exambutton;
    new Thread(this).start();
  }
                            
     @Override
    public void run() {
        try {
     
      kill("explorer.exe"); // Kill explorer
      Robot robot = new Robot();
      while (running) {
          
      if(!netIsAvailable())
       {    
            exambutton.setVisible(false);
            Thread t = new Thread() {
            
            public void run() {     
                    if(internetcon_flag % 2 == 0)
                        con_label.setVisible(true);
                    else
                        con_label.setVisible(false);
                    try {
                        sleep(2000L);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    internetcon_flag++;
                }
            
        };
        t.start();             
       }
       else
       {
           if(internetcon_flag != 2)
           {
           exambutton.setVisible(true);
           con_label.setVisible(false);
           JOptionPane.showMessageDialog(b_frame, "Internet connection is active","Internet Connection status",JOptionPane.INFORMATION_MESSAGE);
           internetcon_flag = 2;
           }
       }
                   
       db.getData();   
       if(db.getAppState() == 0)
       {
         ActionListener taskPerformer = new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent ae) {
             JOptionPane.showMessageDialog(b_frame, "There is no active examination","Examination status",JOptionPane.INFORMATION_MESSAGE);
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
       if(pidInfo.contains("cmd.exe"))
       {
       kill("cmd.exe");
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
        Runtime.getRuntime().exec("TASKKILL /F /IM " + string).waitFor();
     else
        {  
        Runtime.getRuntime().exec("TASKKILL /F /IM Taskmgr.exe").waitFor(); 
        }
        } catch (Exception e) {
    }
  }
  
      private static boolean netIsAvailable() {
    try {
        final URL url = new URL("http://www.google.com");
        final URLConnection conn = url.openConnection();
        conn.connect();
        conn.getInputStream().close();
        return true;
    } catch (MalformedURLException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        return false;
    }
}
}

