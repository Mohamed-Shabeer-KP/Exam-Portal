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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author MOHAMED SHABEER KP
 */
public class DatabaseOp {
    
    public int  app_state=0;

    public void initfirebase() throws FileNotFoundException
    {
                File f = new File("src\\main\\java\\res\\asas-exam-portal-firebase-adminsdk-dixej-8f5f170638.json");
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
      
    public boolean getState()
    {
     final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference basic_ref = database.getReference("main");
    basic_ref.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            app_state = Integer.parseInt((String) dataSnapshot.child("app_state").getValue());
          //  hoursperday = Integer.parseInt((String) dataSnapshot.child("hoursperday").getValue());
       
        }
        
        @Override
        public void onCancelled(DatabaseError databaseError) {
            System.out.println("Error");// ...
        }
    });
    
      try {
                      Thread.sleep(8000L);
                  } catch (InterruptedException ex) {
                      Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
                  }
    
        return app_state==1;
    }
}

