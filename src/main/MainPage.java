/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

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
import java.io.File;
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

      
    private final JFXPanel jfxPanel = new JFXPanel();
    private WebEngine engine;
 
    
    private final JLabel lblStatus = new JLabel();

    private Panel panel;
    private final JButton btnGo = new JButton("Refresh");
    private final JTextField txtURL = new JTextField();
    private final JProgressBar progressBar = new JProgressBar();
    
    private JPanel main_panel;
    private int wrong_count;
    private int correct_count;
    

    public MainPage() {
       
        main_panel=this.p_main;
        wrong_count=0;
        correct_count=0;
        initComponents();  
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_main = new javax.swing.JPanel();
        btn_browser = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pass_exitpassword = new javax.swing.JPasswordField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        p_browser = new javax.swing.JPanel();
        l_warning = new javax.swing.JLabel();
        l_attempt_info = new javax.swing.JLabel();
        l_attempt_count = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setExtendedState(2);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1000, 1000));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        p_main.setName(""); // NOI18N

        btn_browser.setText("HOME");
        btn_browser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_browserActionPerformed(evt);
            }
        });

        jButton2.setText("X");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        pass_exitpassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pass_exitpasswordMouseExited(evt);
            }
        });

        p_browser.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 0, 255)));
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
                .addComponent(p_browser, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        javax.swing.GroupLayout p_mainLayout = new javax.swing.GroupLayout(p_main);
        p_main.setLayout(p_mainLayout);
        p_mainLayout.setHorizontalGroup(
            p_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDesktopPane1)
                    .addGroup(p_mainLayout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pass_exitpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_browser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addComponent(l_warning)
                        .addGap(18, 18, 18)
                        .addComponent(l_attempt_count)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_attempt_info)))
                .addContainerGap())
        );
        p_mainLayout.setVerticalGroup(
            p_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(pass_exitpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_browser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_warning)
                    .addComponent(l_attempt_info)
                    .addComponent(l_attempt_count))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        jButton2.getAccessibleContext().setAccessibleName("");

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
    create_browser();
    loadURL("www.google.com");
   
    }
           
  private void create_browser()
  {
     JPanel panel =  this.p_browser;
     
   
        createScene(); 
 
        ActionListener al = new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                loadURL(txtURL.getText());
            }
        };
 
        txtURL.setEditable(false);
        txtURL.setVisible(false);// ----------remove link visibility
        btnGo.addActionListener(al);
        txtURL.addActionListener(al);
          
        progressBar.setPreferredSize(new Dimension(150, 18));
        progressBar.setStringPainted(true);
  
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));
        topBar.add(txtURL, BorderLayout.CENTER); //----------remove link visibility
        topBar.add(btnGo, BorderLayout.WEST);
 
        JPanel statusBar = new JPanel(new BorderLayout());
        statusBar.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));
        statusBar.add(lblStatus, BorderLayout.CENTER);
        statusBar.add(progressBar, BorderLayout.EAST);
 
        panel.add(topBar, BorderLayout.NORTH);
        panel.add(jfxPanel, BorderLayout.CENTER);
        panel.add(statusBar, BorderLayout.SOUTH);
      
        this.addWindowListener(getWindowAdapter(this));
  }
  private void createScene() {
 
        Platform.runLater(new Runnable() {
            @Override 
            public void run() {
 
                WebView view = new WebView();
                engine = view.getEngine();
 
                engine.titleProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, final String newValue) {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override 
                            public void run() {
                             
                            }
                        });
                    }
                });
 
                engine.setOnStatusChanged(new EventHandler<WebEvent<String>>() {
                    @Override 
                    public void handle(final WebEvent<String> event) {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override 
                            public void run() {
                                lblStatus.setText(event.getData());
                            }
                        });
                    }
                });
 
                engine.locationProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> ov, String oldValue, final String newValue) {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override 
                            public void run() {
                                txtURL.setText(newValue);
                            }
                        });
                    }
                });
 
                engine.getLoadWorker().workDoneProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, final Number newValue) {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override 
                            public void run() {
                                progressBar.setValue(newValue.intValue());
                            }
                        });
                    }
                });

                engine.getLoadWorker()
                        .exceptionProperty()
                        .addListener(new ChangeListener<Throwable>() {
 
                            public void changed(ObservableValue<? extends Throwable> o, Throwable old, final Throwable value) {
                                if (engine.getLoadWorker().getState() == FAILED) {
                                    SwingUtilities.invokeLater(new Runnable() {
                                        @Override public void run() {
                                            JOptionPane.showMessageDialog(
                                                    panel,
                                                    (value != null) ?
                                                    engine.getLocation() + "\n" + value.getMessage() :
                                                    engine.getLocation() + "\nUnexpected error.",
                                                    "Loading error...",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    });
                                }
                            }
                        });

                jfxPanel.setScene(new Scene(view));
            }
        });
    }
 
    public void loadURL(final String url) {
        Platform.runLater(new Runnable() {
            @Override 
            public void run() {
                String tmp = toURL(url);
 
                if (tmp == null) {
                    tmp = toURL("http://" + url);
                }
                engine.load(tmp);
            }
        });
    }

    private static String toURL(String str) {
        try {
            return new URL(str).toExternalForm();
        } catch (MalformedURLException exception) {
                return null;
        }}
   
    private WindowListener getWindowAdapter(JFrame f) {
         return new WindowAdapter() {
  
      @Override
      public void windowIconified(WindowEvent we) {
        f.setState(JFrame.NORMAL);
        JOptionPane.showMessageDialog(f, "Cant Minimize");
      }
    };     
    }//GEN-LAST:event_btn_browserActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
     
    String pass = this.pass_exitpassword.getText();
        if(pass.equals("pass"))
        {   
         File index = new File("c:/exam_portal_config");
         String[]entries = index.list();
         for(String s: entries){
         File currentFile = new File(index.getPath(),s);
         currentFile.delete();
         }
         index.delete();
         /*
            try {
            Runtime.getRuntime().exec("explorer.exe");// ----------------------------------FOR TESTING PURPOSE
        } catch (IOException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        }*/
            
            super.dispose();
            
            String shutdownCmd = "shutdown -l";      //  --------------------------ALTER TO SIGN OUT
        try {
            Process child = Runtime.getRuntime().exec(shutdownCmd);
        } catch (IOException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.exit(0);
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
         makeFrameFullSize(this);
    }//GEN-LAST:event_formWindowOpened

    private void pass_exitpasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pass_exitpasswordMouseExited

    }//GEN-LAST:event_pass_exitpasswordMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainPage().setVisible(true);
              MainPage f=new MainPage();
              f.start();
              
            }
        });
    }
    
  public void start()
  {
      WindowsSecurity obj = new WindowsSecurity(main_panel);
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_browser;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel l_attempt_count;
    private javax.swing.JLabel l_attempt_info;
    private javax.swing.JLabel l_warning;
    private javax.swing.JPanel p_browser;
    private javax.swing.JPanel p_main;
    private javax.swing.JPasswordField pass_exitpassword;
    // End of variables declaration//GEN-END:variables
}
