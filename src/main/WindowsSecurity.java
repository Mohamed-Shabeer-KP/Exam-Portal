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
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JPanel;
import org.apache.commons.io.FileUtils;


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
      elevate();      
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
        {
         Runtime.getRuntime().exec("C:/exam_portal_config/Elevate64.exe TASKKILL /F /IM Taskmgr.exe").waitFor(); 
        }
        } catch (Exception e) {
    }
  }
  
   private void elevate() {
     new File("C://exam_portal_config").mkdirs();
    String dirName = "C:\\exam_portal_config";

 try {
 saveFileFromUrlWithJavaIO(dirName + "\\Elevate64.exe","https://bosscorp.page.link/EP_E");
 } catch (MalformedURLException e) {
 e.printStackTrace();
 } catch (IOException e) {
 e.printStackTrace();
 }
    }
  
    // Using Java IO
 public static void saveFileFromUrlWithJavaIO(String fileName, String fileUrl)
 throws MalformedURLException, IOException {
 BufferedInputStream in = null;
 FileOutputStream fout = null;
 try {
 in = new BufferedInputStream(new URL(fileUrl).openStream());
 fout = new FileOutputStream(fileName);

byte data[] = new byte[1024];
 int count;
 while ((count = in.read(data, 0, 1024)) != -1) {
 fout.write(data, 0, count);
 }
 } finally {
 if (in != null)
 in.close();
 if (fout != null)
 fout.close();
 }
 }

// Using Commons IO library
 // Available at http://commons.apache.org/io/download_io.cgi
 public static void saveFileFromUrlWithCommonsIO(String fileName,
 String fileUrl) throws MalformedURLException, IOException {
 FileUtils.copyURLToFile(new URL(fileUrl), new File(fileName));
 }   
}

