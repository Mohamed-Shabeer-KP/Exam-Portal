/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OnlinePortal;

/**
 *
 * @author MOHAMED SHABEER KP
 */
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class SplashScreen extends JFrame {

    private JLabel imglabel;
    private ImageIcon img;
    private static JProgressBar pbar;
    Thread t = null;
    int x, y, z;

    public SplashScreen() throws IOException {
        super("ASAS Online Portal");
        setAppIcon();
        x = 1000;
        y = 450;
        z = 30;
        setSize(x, y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setAlwaysOnTop(true);
        Image i = ImageIO.read(getClass().getResource("/splash.png"));
        img = new ImageIcon(i);
        imglabel = new JLabel(img);
        add(imglabel);
        setLayout(null);
        pbar = new JProgressBar();
        pbar.setMinimum(0);
        pbar.setMaximum(100);
        pbar.setStringPainted(true);
        pbar.setForeground(Color.LIGHT_GRAY);
        imglabel.setBounds(0, 0, x, y - 20);
        add(pbar);
        pbar.setPreferredSize(new Dimension(y, z));
        pbar.setBounds(0, (y - 20), x, (z - 10));

        Thread t = new Thread() {

            public void run() {
                int i = 0;
                while (i <= 100) {
                    pbar.setValue(i);
                    try {
                        sleep(90);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    i++;
                }
            }
        };
        t.start();
    }

    private void setAppIcon() {
        System.out.println("Setting Application Icon");
        try {
            Image i = ImageIO.read(getClass().getResource("/aep_icon.png"));
            this.setIconImage(i);
        } catch (IOException ex) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
