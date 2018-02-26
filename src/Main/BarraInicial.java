package Main;

import Telas.Login;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class BarraInicial extends javax.swing.JWindow {
                JLabel jLabelSplashImage;
    public      JLabel jLabelTextoCarregamento;
    static      JLabel jLabelTextoDinamicoPlugins;
    static      JProgressBar jProgressBarSistema;
    Dimension   Screen;
    public Login    lg;
    
    public BarraInicial() {
        lg    = new Login(this);
        criandoComponentes();
        
        this.setVisible(true);
        lg.IniciaCarregamentoSistema();
        this.setVisible(false);
    }

    private void criandoComponentes(){
        
        jProgressBarSistema = new JProgressBar();
        jLabelSplashImage = new JLabel();
        jLabelTextoCarregamento = new JLabel();
        jLabelTextoDinamicoPlugins = new JLabel();
        
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("sistema.jpg"));
        jLabelSplashImage.setIcon(imageIcon);
        
        this.setMinimumSize(new java.awt.Dimension(imageIcon.getIconWidth(),imageIcon.getIconHeight()));
        jLabelSplashImage.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        
        getContentPane().setLayout(null);
        
        Screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((Screen.width - this.getSize().width) / 2, (Screen.height - this.getSize().height) / 2);
        
        jProgressBarSistema.setForeground(new Color(0,0,204));
        jProgressBarSistema.setPreferredSize(new java.awt.Dimension(148, 5));
        jProgressBarSistema.setBounds(0, 266, imageIcon.getIconWidth(), 5);
        jProgressBarSistema.setBorderPainted(false);
        jProgressBarSistema.setIndeterminate(true);
        
        getContentPane().add(jProgressBarSistema);
        
        jLabelTextoCarregamento.setForeground(new java.awt.Color(0,0,204));
        jLabelTextoCarregamento.setFont(new java.awt.Font("DialogInput", 0, 13));
        jLabelTextoCarregamento.setBounds(this.getSize().width / 10, 285, (this.getSize().height / 10) * 9, 20);
        
        this.getContentPane().add(jLabelTextoCarregamento);
        
        jLabelTextoDinamicoPlugins.setForeground(new java.awt.Color(0,0,204));
        jLabelTextoDinamicoPlugins.setFont(new java.awt.Font("DialogInput", 0, 11));
        jLabelTextoDinamicoPlugins.setBounds(360, 285, 230, 20);
        
        
        this.getContentPane().add(jLabelTextoDinamicoPlugins);
       
        this.getContentPane().add(jLabelSplashImage);
        this.pack();

    }    
    
   
}
