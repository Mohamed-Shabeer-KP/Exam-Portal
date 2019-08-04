package Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
/**
 *
 * @author MOHAMED SHABEER KP
 */
public class DatabaseOp implements Runnable  {
    
    private int app_state;
    private String exit_password;
    private String exam_link;
    private JFrame f;
    
    public DatabaseOp(JFrame f)
    {
    this.app_state=0;
    this.exam_link="";
    this.exit_password="";
    this.f=f;
    new Thread(this).start();
    }
    
      @Override
    public void run() {
        try {
            
        SplashScreen s=new SplashScreen();
        s.setVisible(true);
        Thread t=Thread.currentThread();
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
                 f.setVisible(true);
            }
        });
      
    } catch (Exception e) {
    System.out.println(e);
    }
    }


    public void initfirebase() throws FileNotFoundException
    {
                File f = new File("res/firebaseconfig.json");
                FileInputStream serviceAccount = new FileInputStream(f);
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

