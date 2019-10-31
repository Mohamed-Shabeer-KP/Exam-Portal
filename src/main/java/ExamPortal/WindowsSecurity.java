package ExamPortal;

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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class WindowsSecurity implements Runnable {

    private boolean running;
    private JFrame b_frame;
    private DatabaseOp db;
    private ExamSubject[] subjects;
    private JLabel con_label, date_label;
    private JButton exam_button;
    private int internetcon_flag;
    public int sub_id;

    public WindowsSecurity(JFrame b_frame, DatabaseOp db, JLabel con_label, JButton exam_button, JLabel timer_label, JLabel date_label) {
        running = true;
        internetcon_flag = 2;
        this.b_frame = b_frame;
        this.db = db;
        this.sub_id = -1;
        this.con_label = con_label;
        this.date_label = date_label;
        this.exam_button = exam_button;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            kill("explorer.exe"); // Kill explorer
            Robot robot = new Robot();
            while (running) {

                Date date = java.util.Calendar.getInstance().getTime();
                SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy, hh:mm a");
                date_label.setText(formatter.format(date));

                if (netIsAvailable() == 1) {
                    exam_button.setVisible(false);
                    con_label.setVisible(true);
                } else {
                    exam_button.setVisible(true);
                    con_label.setVisible(false);
                }

                db.getData();
                subjects = db.getExamSubjects();

                if (db.getExamCount() == 0 || (sub_id != -1 && subjects[sub_id].getAppState() == 0)) {
                    ActionListener taskPerformer = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            db.setStudCount(sub_id, 0);
                            JOptionPane.showMessageDialog(b_frame, "Session is Over", "Session Status", JOptionPane.INFORMATION_MESSAGE);
                        }
                    };

                    Timer timer = new Timer(100, taskPerformer);
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
                String pidInfo = "";

                Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");
                BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

                while ((line = input.readLine()) != null) {
                    pidInfo += line;
                }

                input.close();

                if (pidInfo.contains("Taskmgr.exe")) {
                    kill("Taskmgr.exe");
                }
                if (pidInfo.contains("cmd.exe")) {
                    kill("cmd.exe");
                }
                releaseKeys(robot);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void setSubId(int sub_id) {
        this.sub_id = sub_id;
    }

    public void stop() {
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
            if (!string.equals("Taskmgr.exe")) {
                Runtime.getRuntime().exec("TASKKILL /F /IM " + string).waitFor();
            } else {
                Runtime.getRuntime().exec("TASKKILL /F /IM Taskmgr.exe").waitFor();
            }
        } catch (Exception e) {
        }
    }

    private static int netIsAvailable() throws InterruptedException, IOException {
        Process p1 = java.lang.Runtime.getRuntime().exec("ping -n 1 www.google.com");
        Thread.sleep(7000L);
        int returnVal = p1.waitFor();
        return returnVal;
    }

}
