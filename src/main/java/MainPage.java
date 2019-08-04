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

import javafx.embed.swing.JFXPanel;
import javafx.scene.web.WebEngine;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import static javafx.concurrent.Worker.State.FAILED;
  
/**
 *
 * @author MOHAMED SHABEER KP
 */
public class MainPage extends javax.swing.JFrame {

 
    
    private JFrame browser_frame;
    private JPanel browser_panel;
    private JPasswordField pass;
    private JButton exitpassfieldinit;
    private int wrong_count;
    private DatabaseOp db;
    private JourneyBrowserView browser;
    
    /**
     * Creates new form NewJFrame
     */
    public MainPage() {
        initComponents();
        db = new DatabaseOp();
        this.addWindowListener(getWindowAdapter());
        
        browser_frame=this;
        browser_panel=this.p_browser;
        pass=pass_exitpassword;
        exitpassfieldinit=this.b_exitpassfieldinit;
        wrong_count=0;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_main = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        p_browser = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_browser = new javax.swing.JButton();
        pass_exitpassword = new javax.swing.JPasswordField();
        b_exitpassfieldinit = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        l_warning = new javax.swing.JLabel();
        l_attempt_info = new javax.swing.JLabel();
        l_attempt_count = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Exam Portal");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setExtendedState(2);
        setName("main_frame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1000, 1000));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        p_main.setBackground(new java.awt.Color(255, 255, 255));
        p_main.setName(""); // NOI18N

        jDesktopPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));

        p_browser.setBackground(new java.awt.Color(203, 255, 255));
        p_browser.setLayout(new java.awt.BorderLayout());

        jDesktopPane1.setLayer(p_browser, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p_browser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p_browser, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 255), 1, true)));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("© Boss Incorporated");

        jLabel2.setText("GOGREENMCA 2016");

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

        btn_browser.setBackground(new java.awt.Color(153, 255, 153));
        btn_browser.setText("EXAM");
        btn_browser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_browser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_browserActionPerformed(evt);
            }
        });

        pass_exitpassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        pass_exitpassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pass_exitpasswordMouseClicked(evt);
            }
        });
        pass_exitpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pass_exitpasswordActionPerformed(evt);
            }
        });
        pass_exitpassword.setVisible(false);

        b_exitpassfieldinit.setBackground(new java.awt.Color(173, 234, 255));
        b_exitpassfieldinit.setText("Enter Password to Exit");
        b_exitpassfieldinit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_exitpassfieldinit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_exitpassfieldinitActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\moham\\Desktop\\exit.png")); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        l_warning.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        l_warning.setForeground(new java.awt.Color(255, 0, 51));
        l_warning.setText("!!! Wrong Password !!!");
        l_warning.setVisible(false);

        l_attempt_info.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        l_attempt_info.setText("time(s)");
        l_attempt_info.setVisible(false);

        l_attempt_count.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        l_attempt_count.setText("0");
        l_attempt_count.setVisible(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_exitpassfieldinit, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pass_exitpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(btn_browser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                .addComponent(l_warning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(l_attempt_count)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(l_attempt_info)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(l_warning)
                                .addComponent(l_attempt_info)
                                .addComponent(l_attempt_count))
                            .addComponent(jButton2)))
                    .addComponent(btn_browser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pass_exitpassword, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_exitpassfieldinit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7))
        );

        jButton2.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout p_mainLayout = new javax.swing.GroupLayout(p_main);
        p_main.setLayout(p_mainLayout);
        p_mainLayout.setHorizontalGroup(
            p_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        p_mainLayout.setVerticalGroup(
            p_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1)
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

    private void btn_browserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_browserActionPerformed
    createBrowser(db.getExamLink());  
    }//GEN-LAST:event_btn_browserActionPerformed

 public  void createBrowser(String link) {   
        browser = new JourneyBrowserView(link);   
        browser_panel.add(browser, BorderLayout.CENTER);
        browser_panel.updateUI();
}

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    String pass = this.pass_exitpassword.getText();
        if(pass.equals(db.getExitPassword()))
        {  try {
        Runtime.getRuntime().exec("explorer.exe");
        System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
  
        else 
        {
        wrong_count++;
        if(wrong_count>2)
        {
        this.l_warning.setVisible(true);
        this.l_attempt_count.setText(String.valueOf(wrong_count));
        this.l_attempt_count.setVisible(true);
        this.l_attempt_info.setVisible(true);
        }   
        }
     
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
         makeFrameFullSize(this);
    }//GEN-LAST:event_formWindowOpened

    private void pass_exitpasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pass_exitpasswordMouseClicked
        browser_panel.removeAll();
        browser_panel.revalidate();
        browser_panel.repaint();
       
    }//GEN-LAST:event_pass_exitpasswordMouseClicked

    private void b_exitpassfieldinitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_exitpassfieldinitActionPerformed
        pass.setVisible(true);
        exitpassfieldinit.setVisible(false);
        browser_frame.revalidate();
        browser_frame.repaint();
    }//GEN-LAST:event_b_exitpassfieldinitActionPerformed

    private void pass_exitpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pass_exitpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pass_exitpasswordActionPerformed

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
                try {
                   
                    MainPage f=new MainPage();
                    f.AppState();
                    f.secureWindow();
                    f.setVisible(true);
                    
                    } catch (IOException ex) {
                    Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
   
    }
    
  public void secureWindow()
  {
      WindowsSecurity obj = new WindowsSecurity(browser_frame,db);
  }
  
  public void AppState() throws IOException
  {    
                try {
                    db.initfirebase();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                
              db.getData();
                
              if(db.getAppState() == 0)
              {
              JOptionPane.showMessageDialog(browser_frame, "There is no active examination");
              System.exit(0);
              } 
  }
  
   private WindowAdapter getWindowAdapter() {
    return new WindowAdapter() {
      @Override
      public void windowIconified(WindowEvent we) {
        browser_frame.setState(JFrame.NORMAL);
        JOptionPane.showMessageDialog(browser_frame, "Cant Minimize");
      }
    };
  }

      


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_exitpassfieldinit;
    private javax.swing.JButton btn_browser;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel l_attempt_count;
    private javax.swing.JLabel l_attempt_info;
    private javax.swing.JLabel l_warning;
    private javax.swing.JPanel p_browser;
    private javax.swing.JPanel p_main;
    private javax.swing.JPasswordField pass_exitpassword;
    // End of variables declaration//GEN-END:variables

}