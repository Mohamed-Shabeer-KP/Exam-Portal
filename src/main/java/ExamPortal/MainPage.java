package ExamPortal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import AES256.Decryption;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import com.codebrig.journey.JourneyBrowserView;
  
/**
 *
 * @author MOHAMED SHABEER KP
 */
public class MainPage extends javax.swing.JFrame {

    private JFrame browser_frame;
    private int wrong_count,exit_flag,exam_count;
    private ExamSubject[] subjects;
    private int exit_btn_click_count,exam_btn_count;
    private DatabaseOp db;
    private int min,sec;
    public int sub_id;
    /**
     * Creates new form NewJFrame
     */
    public MainPage() {
        
        initComponents();
        
        sub_id = -1;
        wrong_count = 0;
        exit_flag = 0;
        exit_btn_click_count = 3;
        exam_btn_count = 0;
        browser_frame = this;  
        
        db = new DatabaseOp(this,this.btn_exam,this.l_connection,this.l_timer,this.l_date);
        db.thread_start(db);
        this.addWindowListener(getWindowAdapter());
 
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_main = new javax.swing.JPanel();
        dskp_browser = new javax.swing.JDesktopPane();
        p_browser = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        l_date = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        l_connection = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        btn_exam = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        l_warning = new javax.swing.JLabel();
        l_attempt_count = new javax.swing.JLabel();
        l_attempt_info = new javax.swing.JLabel();
        l_timer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Exam Portal");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(2);
        setName("main_frame"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        p_main.setBackground(new java.awt.Color(255, 255, 255));
        p_main.setName(""); // NOI18N

        dskp_browser.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));

        p_browser.setBackground(new java.awt.Color(203, 255, 255));
        p_browser.setLayout(new java.awt.BorderLayout());

        dskp_browser.setLayer(p_browser, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dskp_browserLayout = new javax.swing.GroupLayout(dskp_browser);
        dskp_browser.setLayout(dskp_browserLayout);
        dskp_browserLayout.setHorizontalGroup(
            dskp_browserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dskp_browserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p_browser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        dskp_browserLayout.setVerticalGroup(
            dskp_browserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dskp_browserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p_browser, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 255), 1, true)));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setPreferredSize(new java.awt.Dimension(845, 65));

        l_date.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        l_date.setText("[sys_date]");
        l_date.setMaximumSize(new java.awt.Dimension(200, 17));
        l_date.setMinimumSize(new java.awt.Dimension(200, 17));
        l_date.setPreferredSize(new java.awt.Dimension(200, 17));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel2.setText("Go-Green MCA 2016");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        l_connection.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        l_connection.setForeground(new java.awt.Color(255, 0, 0));
        l_connection.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_connection.setText("!!! Internet Connection not available !!!");
        l_connection.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        l_connection.setVisible(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(l_connection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(l_connection, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l_date, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(l_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 102, 255), new java.awt.Color(0, 51, 51)));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exit.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btn_exam.setBackground(new java.awt.Color(153, 255, 153));
        btn_exam.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        btn_exam.setText("EXAM");
        btn_exam.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_exam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_examActionPerformed(evt);
            }
        });
        btn_exam.setVisible(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(71, 108, 255)));

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ASAS EXAM PORTAL ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(71, 108, 255)));

        l_warning.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        l_warning.setForeground(new java.awt.Color(255, 51, 51));
        l_warning.setText("!!! Wrong Password !!!");
        l_warning.setVisible(false);

        l_attempt_count.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        l_attempt_count.setText("0");
        l_attempt_count.setVisible(false);

        l_attempt_info.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        l_attempt_info.setText("time(s)");
        l_attempt_info.setVisible(false);

        l_timer.setForeground(new java.awt.Color(255, 51, 51));
        l_timer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_timer.setText("00:00");
        l_timer.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(71, 108, 255)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l_warning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_attempt_count)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_attempt_info)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_timer, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_attempt_info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(l_timer, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(l_attempt_count, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_warning, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_exam, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btn_exam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout p_mainLayout = new javax.swing.GroupLayout(p_main);
        p_main.setLayout(p_mainLayout);
        p_mainLayout.setHorizontalGroup(
            p_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dskp_browser)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1138, Short.MAX_VALUE))
                .addContainerGap())
        );
        p_mainLayout.setVerticalGroup(
            p_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dskp_browser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void makeFrameFullSize(JFrame aFrame) {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    aFrame.setSize(screenSize.width, screenSize.height);
}

    public void createBrowser(String link) {   
        p_browser.removeAll();
        p_browser.updateUI();
        JourneyBrowserView browser = new JourneyBrowserView(link);  
        p_browser.add(browser, BorderLayout.CENTER);
        p_browser.updateUI();
}

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      makeFrameFullSize(this);
    }//GEN-LAST:event_formWindowOpened

    private void btn_examActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_examActionPerformed
  

        String plain_exam_link = null;
        if(exam_btn_count == 0)
        {
            exam_count = db.getExamCount();
            Object[] exam_subs = new Object[exam_count];
            subjects = db.getExamSubjects();
            for(int i=0;i<exam_count;i++)
                exam_subs[i] = subjects[i].getSubName();
            
            switch (db.getAppMode()) {
            //Multiple Mode
                case 1:
                    Object selectionObject = JOptionPane.showInputDialog(this, "Select Subject", "Examination", JOptionPane.QUESTION_MESSAGE, null, exam_subs, exam_subs[0]);
                    if(selectionObject == null)
                        JOptionPane.showMessageDialog(this, "You should select a subject to continue.","Subject not selected",JOptionPane.WARNING_MESSAGE);
                    else
                    {
                        String selectionString = selectionObject.toString();
                        
                        for(int i = 0;i < exam_count;i++)
                            if(exam_subs[i].equals(selectionString))
                                sub_id = i;
                        
                        if(sub_id == -1)
                            JOptionPane.showMessageDialog(this, "Select a valid subject","Invalid subject",JOptionPane.WARNING_MESSAGE);
                        else
                        {
                            JPanel panel = new JPanel();
                            String title = new String("Login - "+exam_subs[sub_id]+" Examination");
                            JLabel label = new JLabel("Enter login password : ");
                            JTextField pass = new JTextField(20);
                            String login_pass = "";
                            panel.add(label);
                            panel.add(pass);
                            String[] options2 = new String[]{"OK", "Cancel"};
                            int option2 = JOptionPane.showOptionDialog(this, panel, title,
                                    JOptionPane.NO_OPTION, JOptionPane.WARNING_MESSAGE,
                                    null, options2, options2[0]);
                            if(option2 == 0) // pressing OK button
                            {
                                login_pass = pass.getText();    
                            }
                            
                            plain_exam_link = Decryption.decrypt(subjects[sub_id].getExamLink(), login_pass ,subjects[sub_id].getExitPassword());// AES 256 DECIPHER -login_pass.equals(subjects[sub_id].getLoginPassword())
                            if( plain_exam_link != null)  
                            {
                                subjects = db.getExamSubjects();
                                db.setStudCount(sub_id,1);
                                db.ws.sub_id = sub_id;
                                exam_btn_count++;
                                exit_flag = 1;
                                createBrowser(plain_exam_link);
                                timer();
                            }
                            else if(option2 == 0)
                            {
                                JOptionPane.showMessageDialog(this, "Wrong Password","Invalid Password",JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    }       break;
            //Indivitual Mode
                case 0:
                    sub_id = 0;
                    JPanel panel = new JPanel();
                    JLabel label = new JLabel("Enter login password :");
                    String title = new String("Login - " + exam_subs[sub_id] + " Examination");
                    JTextField pass = new JTextField(20);
                    String login_pass = "";
                    panel.add(label);
                    panel.add(pass);
                    String[] options2 = new String[]{"OK", "Cancel"};
                    int option2 = JOptionPane.showOptionDialog(this, panel,title,
                            JOptionPane.NO_OPTION, JOptionPane.WARNING_MESSAGE,
                            null, options2, options2[0]);
                    if(option2 == 0) // pressing OK butto
                    {
                        login_pass = pass.getText();
                    }   
                    
                    plain_exam_link = Decryption.decrypt(subjects[sub_id].getExamLink(), login_pass ,subjects[sub_id].getExitPassword()); // AES256 Decipher
                    if(plain_exam_link != null)
                    {
                        subjects = db.getExamSubjects();
                        db.ws.sub_id = sub_id;
                        exam_btn_count++;
                        exit_flag = 1;
                        db.setStudCount(sub_id,1);
                        createBrowser(plain_exam_link);
                        timer();
                    }
                    else if(option2 == 0)
                        JOptionPane.showMessageDialog(this, "Wrong Password","Invalid Password",JOptionPane.WARNING_MESSAGE);
                    break;
            // open mode
                default:
                    sub_id = 0;
                    subjects = db.getExamSubjects();
                    plain_exam_link = subjects[0].getExamLink();
                    db.ws.sub_id = sub_id;
                    exam_btn_count++;
                    exit_flag = 0;
                    db.setStudCount(sub_id,1);
                    createBrowser(plain_exam_link);
                    timer();
                    break;    
            }
        }
        else if(sub_id != -1)
            {
            JPanel panel = new JPanel();
            JLabel label = new JLabel("Are you sure you want to reload the page ?  ");
            panel.add(label);
            String[] options = new String[]{"OK", "Cancel"};
            int option = JOptionPane.showOptionDialog(this, panel, "Refresh",
                         JOptionPane.NO_OPTION, JOptionPane.WARNING_MESSAGE,
                         null, options, options[0]);
            if(option == 0) // pressing OK button
            {     
                subjects = db.getExamSubjects();
                db.ws.sub_id = sub_id;
                createBrowser(subjects[sub_id].getExamLink());
            }           
        }
    }//GEN-LAST:event_btn_examActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(sub_id == -1 || exit_flag == 0)
        {
            try {                  
            Runtime.getRuntime().exec("C:/Windows/explorer.exe");   
            } catch (IOException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.exit(0);
        }      
        else if(exit_btn_click_count <= 0)
        {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter password : ");
        JPasswordField pass = new JPasswordField(10);
        String inputpass = "";
        panel.add(label);
        panel.add(pass);
        String[] options = new String[]{"OK", "Cancel"};
        int option = JOptionPane.showOptionDialog(this, panel, "Exit",
                         JOptionPane.NO_OPTION, JOptionPane.WARNING_MESSAGE,
                         null, options, options[0]);
        if(option == 0) // pressing OK button
        {
            char[] password = pass.getPassword();
            inputpass = new String(password);
        }
        
        subjects = db.getExamSubjects();
        if(inputpass.equals(subjects[sub_id].getExitPassword()) && option == 0 )
        {   
            db.setStudCount(sub_id,2);
            try {
            Runtime.getRuntime().exec("C:/Windows/explorer.exe");  
            } catch (IOException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.exit(0);
        }
        else if(option == 0)
        {           
                wrong_count++;
                this.l_warning.setVisible(true);
                this.l_attempt_count.setText(String.valueOf(wrong_count));
                this.l_attempt_count.setVisible(true);
                this.l_attempt_info.setVisible(true); 
  
            Thread t = new Thread() {
 
            public void run() {
                int i = 0;
                while (i <= 5) {
                      Toolkit.getDefaultToolkit().beep(); 
                    try {
                        sleep(1000L);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    i++;
                }
            }
        };
        t.start();
        }
        }
        else
        {   
            exit_btn_click_count--;
            if(exit_btn_click_count !=0 )  
            JOptionPane.showMessageDialog(this, "FOR EXAMINER ONLY - Click "+(exit_btn_click_count)+" more time(s)","Exit",JOptionPane.WARNING_MESSAGE);
            else 
            JOptionPane.showMessageDialog(this, "FOR EXAMINER ONLY","Exit",JOptionPane.WARNING_MESSAGE);    
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
            * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
            */
            
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainPage();              
            }
        });
   
    }
        private void timer()
    {
        
        javax.swing.Timer t = new javax.swing.Timer(1000, new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              sec++;
                if(sec/60 == 1)
                {
                min++;
                sec = 0;
                }
                l_timer.setText(min+" : "+sec);
          }
       });
       t.start();
    }
    
   private WindowAdapter getWindowAdapter() {
    return new WindowAdapter() {
      @Override
      public void windowIconified(WindowEvent we) {
        browser_frame.setState(JFrame.NORMAL);
        JOptionPane.showMessageDialog(browser_frame, "You cannot minimize this application","Attempt to Minimize",JOptionPane.WARNING_MESSAGE);
      }
    };
  }

public JLabel getConnectionLabel()
{
return l_connection;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exam;
    private javax.swing.JDesktopPane dskp_browser;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel l_attempt_count;
    private javax.swing.JLabel l_attempt_info;
    private javax.swing.JLabel l_connection;
    private javax.swing.JLabel l_date;
    private javax.swing.JLabel l_timer;
    private javax.swing.JLabel l_warning;
    private javax.swing.JPanel p_browser;
    private javax.swing.JPanel p_main;
    // End of variables declaration//GEN-END:variables

 

}