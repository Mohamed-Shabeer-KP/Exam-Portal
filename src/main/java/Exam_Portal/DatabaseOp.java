package Exam_Portal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.auth.oauth2.GoogleCredentials;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
import javax.swing.SwingUtilities;
/**
 *
 * @author MOHAMED SHABEER KP
 */
public class DatabaseOp implements Runnable  {
    
    private int exam_count,app_mode,exam_state,sub_id,stud_count;
    private String sub_name,exam_link,exit_password,login_password;
    private int internetcon_flag;
    private ExamSubject subjects[];
    private JFrame f;
    private DatabaseOp db;
    private JButton exam_button;
    private JLabel con_label,timer_label,date_label;
    public WindowsSecurity ws;
    
    public DatabaseOp(JFrame f,JButton exam_button,JLabel con_label,JLabel timer_label,JLabel date_label)
    {
    exam_count = 0;
    exam_state = 0;
    app_mode = 0;
    sub_name = "";
    exam_link = "";
    exit_password = "";
    internetcon_flag = 0;
    this.f = f;
    this.sub_id = sub_id;
    this.exam_button=exam_button;
    this.con_label = con_label;
    this.timer_label = timer_label;
    this.date_label = date_label;
    }
    
    public void thread_start(DatabaseOp db)
    {
     this.db = db;
     new Thread(this).start();
    }
    
      @Override
    public void run() {
        try {
            
        SplashScreen s = new SplashScreen();
        
        if(netIsAvailable() == 1)
        {
            internetcon_flag = 1;
            JOptionPane.showMessageDialog(f, "There is no active Internet Connection","Internet connection status",JOptionPane.ERROR_MESSAGE);
            System.exit(0); 
        }
        else
        s.setVisible(true);  
               
        Thread t = Thread.currentThread();
        
        db.initfirebase();
        db.getData();
        
        try {
            t.sleep(10000L);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        s.dispose();
        SwingUtilities.invokeLater(new Runnable(){
            public void run()
            {
              if(db.getExamCount() == 0 && internetcon_flag == 0 )
              {
              JOptionPane.showMessageDialog(f, "There is no active examination","Examination status",JOptionPane.INFORMATION_MESSAGE);
              System.exit(0);             
              }
              else 
              {
              f.setVisible(true);
              ws = new WindowsSecurity(f,db,con_label,exam_button,timer_label,date_label); 
              }
              }
        });
                             try {
                      t.sleep(7000L);
                  } catch (InterruptedException ex) {
                      Logger.getLogger(DatabaseOp.class.getName()).log(Level.SEVERE, null, ex);
                  }                        
            exam_button.setVisible(true);
    } catch (Exception e) {
    System.out.println(e);
    }
    }


    public void initfirebase() throws FileNotFoundException
    {
        
                InputStream serviceAccount  =   getClass().getResourceAsStream("/firebaseconfig.json");
                FirebaseOptions options = null;
                try {
                    options = new FirebaseOptions.Builder()
                            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                            .setDatabaseUrl("https://asas-exam-portal.firebaseio.com/")
                            .build(); } catch (IOException ex) {
                               System.out.println(ex);
                            }
               FirebaseApp.initializeApp(options);
    }
      
    public void getData()
    {
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference basic_ref = database.getReference("");
    basic_ref.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            exam_count = Integer.parseInt((String) dataSnapshot.child("main").child("exam_count").getValue());   
            app_mode = Integer.parseInt((String) dataSnapshot.child("main").child("app_mode").getValue()); 
            
            subjects = new ExamSubject[exam_count];
            for(int i = 1; i <= exam_count;i++)
            {
                sub_name = String.valueOf(dataSnapshot.child(String.valueOf(i)).child("sub_name").getValue());
                exam_state = Integer.parseInt((String) dataSnapshot.child(String.valueOf(i)).child("app_state").getValue());
                exam_link = (String) dataSnapshot.child(String.valueOf(i)).child("exam_link").getValue();
                login_password = (String) dataSnapshot.child(String.valueOf(i)).child("login_password").getValue();
                exit_password = (String) dataSnapshot.child(String.valueOf(i)).child("exit_password").getValue();
                stud_count = Integer.parseInt((String) dataSnapshot.child(String.valueOf(i)).child("stud_count").getValue());
               
                subjects[i-1] = new ExamSubject();
                subjects[i-1].setSubName(sub_name);
                subjects[i-1].setAppState(exam_state);
                subjects[i-1].setExamLink(exam_link);
                subjects[i-1].setLoginPassword(login_password);    
                subjects[i-1].setExitPassword(exit_password);   
                subjects[i-1].setStudCount(stud_count);
            }   
        }
        
        @Override
        public void onCancelled(DatabaseError databaseError) {
            System.out.println("Error");// ...
        }    
    });
    }
    
    public void setStudCount(int sub_id,int mode_flag)
    {
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference basic_ref = database.getReference(String.valueOf(sub_id+1)).child("stud_count");
    
    if(mode_flag == 1)
        basic_ref.setValueAsync(String.valueOf((subjects[sub_id].getStudCount())+1));
    else if (mode_flag == 2)
        basic_ref.setValueAsync(String.valueOf((subjects[sub_id].getStudCount())-1));
    else
        basic_ref.setValueAsync(String.valueOf(0));
    }
    
    
    
    private static int netIsAvailable() throws InterruptedException, IOException {
        Process p1 = java.lang.Runtime.getRuntime().exec("ping -n 1 www.google.com");
        int returnVal = p1.waitFor();
        return returnVal;    
}

    int getExamCount() 
    {
        return exam_count;
    }
    int getAppMode()
    {
        return app_mode;
    }
    
    ExamSubject[] getExamSubjects()
    {   
        return subjects;
    }

}

