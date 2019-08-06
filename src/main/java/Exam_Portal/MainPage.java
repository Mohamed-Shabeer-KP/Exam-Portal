package Exam_Portal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.codebrig.journey.JourneyBrowserView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
  
/**
 *
 * @author MOHAMED SHABEER KP
 */
public class MainPage extends javax.swing.JFrame {

    private JFrame browser_frame;
    private int wrong_count;
    private int exit_btn_click_count;
    private DatabaseOp db;
    private JourneyBrowserView browser;
    
    /**
     * Creates new form NewJFrame
     */
    public MainPage() {
        initComponents();
        db = new DatabaseOp(this,btn_exam);
        db.thread_start(db);
        this.addWindowListener(getWindowAdapter());
        browser_frame = this;
        wrong_count=0;
        exit_btn_click_count = 3;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_main = new javax.swing.JPanel();
        dskp_browser = new javax.swing.JDesktopPane();
        p_browser = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_exitpass = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btn_exam = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        l_warning = new javax.swing.JLabel();
        l_attempt_count = new javax.swing.JLabel();
        l_attempt_info = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Exam Portal");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(2);
        setName("main_frame"); // NOI18N
        setUndecorated(true);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dskp_browserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p_browser, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 255), 1, true)));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel1.setText("© Boss Incorporated");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel2.setText("Go-Green MCA 2016");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 102, 255), new java.awt.Color(0, 51, 51)));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btn_exitpass.setBackground(new java.awt.Color(173, 234, 255));
        btn_exitpass.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        btn_exitpass.setText("Enter Password to Exit");
        btn_exitpass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_exitpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitpassActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exit.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btn_exam.setBackground(new java.awt.Color(153, 255, 153));
        btn_exam.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
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
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(71, 108, 255)));

        l_warning.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        l_warning.setForeground(new java.awt.Color(255, 0, 51));
        l_warning.setText("!!! Wrong Password !!!");
        l_warning.setVisible(false);

        l_attempt_count.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        l_attempt_count.setText("0");
        l_attempt_count.setVisible(false);

        l_attempt_info.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        l_attempt_info.setText("time(s)");
        l_attempt_info.setVisible(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(l_warning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(l_attempt_count)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_attempt_info)
                .addGap(33, 33, 33))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_attempt_info, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(l_attempt_count, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(l_warning))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_exitpass, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_exam, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btn_exam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_exitpass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout p_mainLayout = new javax.swing.GroupLayout(p_main);
        p_main.setLayout(p_mainLayout);
        p_mainLayout.setHorizontalGroup(
            p_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dskp_browser))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(p_main, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void makeFrameFullSize(JFrame aFrame) {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    aFrame.setSize(screenSize.width, screenSize.height);
}

 public  void createBrowser(String link) {   
      
        browser = new JourneyBrowserView(link);  
        p_browser.add(browser, BorderLayout.CENTER);
        p_browser.updateUI();
}

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      makeFrameFullSize(this);
    }//GEN-LAST:event_formWindowOpened

    private void btn_examActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_examActionPerformed
      createBrowser(db.getExamLink());
    }//GEN-LAST:event_btn_examActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_exitpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitpassActionPerformed

        if(exit_btn_click_count <= 0)
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
                         null, options, options[1]);
        if(option == 0) // pressing OK button
        {
            char[] password = pass.getPassword();
            inputpass = new String(password);
        }
           
        if(inputpass.equals(db.getExitPassword()) && option == 0)
        {  try {
            Runtime.getRuntime().exec("explorer.exe");
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else if(option == 0)
        {           
                wrong_count++;
                this.l_warning.setVisible(true);
                this.l_attempt_count.setText(String.valueOf(wrong_count));
                this.l_attempt_count.setVisible(true);
                this.l_attempt_info.setVisible(true); 

                for(int i=0;i<10;i++)
                {
                Toolkit.getDefaultToolkit().beep();             
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
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
    }//GEN-LAST:event_btn_exitpassActionPerformed

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
                MainPage f=new MainPage();              
            }
        });
   
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



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exam;
    private javax.swing.JButton btn_exitpass;
    private javax.swing.JDesktopPane dskp_browser;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel l_attempt_count;
    private javax.swing.JLabel l_attempt_info;
    private javax.swing.JLabel l_warning;
    private javax.swing.JPanel p_browser;
    private javax.swing.JPanel p_main;
    // End of variables declaration//GEN-END:variables

 

}