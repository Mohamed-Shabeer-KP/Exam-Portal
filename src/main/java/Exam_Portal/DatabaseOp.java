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
    
    private int app_state;
    private int internetcon_flag;
    private String exit_password;
    private String exam_link;
    private JFrame f;
    private DatabaseOp db;
    private JButton exam_button;
    private JLabel con_label;
    private JButton btn_exam;
    
    public DatabaseOp(JFrame f,JButton exam_button,JLabel con_label,JButton btn_exam)
    {
    app_state = 0;
    internetcon_flag = 0;
    exam_link = "";
    exit_password = "";
    this.f = f;
    this.exam_button=exam_button;
    this.con_label = con_label;
    this.btn_exam = btn_exam;
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
              //opening the main application
              if(db.getAppState() == 0 && internetcon_flag == 0 )
              {
              JOptionPane.showMessageDialog(f, "There is no active examination","Examination status",JOptionPane.INFORMATION_MESSAGE);
              System.exit(0);             
              }
              else if(db.getAppState() == 1)
              {
              f.setVisible(true);
              new WindowsSecurity(f,db,con_label,btn_exam); 
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
    DatabaseReference basic_ref = database.getReference("main");
    basic_ref.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            app_state = Integer.parseInt((String) dataSnapshot.child("app_state").getValue());   
            exam_link = (String) dataSnapshot.child("exam_link").getValue();   
            exit_password =(String) dataSnapshot.child("exit_password").getValue();   
        }
        
        @Override
        public void onCancelled(DatabaseError databaseError) {
            System.out.println("Error");// ...
        }    
    });
    }

    public void getPass()
    {
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference basic_ref = database.getReference("main");
    basic_ref.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            app_state = Integer.parseInt((String) dataSnapshot.child("app_state").getValue());  
            
        }
        
        @Override
        public void onCancelled(DatabaseError databaseError) {
            System.out.println("Error");// ...
        }    
    });
    }
    
    private static int netIsAvailable() throws InterruptedException, IOException {
        Process p1 = java.lang.Runtime.getRuntime().exec("ping -n 1 www.google.com");
        int returnVal = p1.waitFor();
        return returnVal;    
}
    
    int getAppState()
    {
        return app_state;
    }
    
    String getExitPassword()
    {
        return exit_password;
    }
    
    String getExamLink()
    {  
        return exam_link;
    }

}

