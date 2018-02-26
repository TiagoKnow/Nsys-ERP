package FuncoesInternas;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JOptionPane;
import javazoom.jl.player.Player;

public class mp3 {
  /**
   * Objeto para nosso arquivo MP3 a ser tocado
   */
  private File mp3;
  /**
   * Objeto Player da biblioteca jLayer. Ele tocará o arquivo
   * MP3
   */
  private Player player;
  /**
   * Construtor que recebe o objeto File referenciando o arquivo
   * MP3 a ser tocado e atribui ao atributo MP3 da classe.
   *
   * @param mp3
   */
  public mp3(File mp3) {
    this.mp3 = mp3;
  }
  /**
   * Método que toca o MP3
   */
  public void play() {
      try {
                FileInputStream fis     = new FileInputStream(mp3);
                BufferedInputStream bis = new BufferedInputStream(fis);
                this.player = new Player(bis);
                //System.out.println("Tocando!");
                this.player.play();
                //System.out.println("Terminado!");
            }
            catch (Exception e) {
                //System.out.println("Problema ao tocar " + mp3);
                JOptionPane.showMessageDialog(null, "Problema ao tocar " + mp3);
            }
     }
}