
package control;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CarroThread extends JLabel implements Runnable {
    private Thread carroThread = null;
    private int posX;
    private int posY;
    private ImageIcon imagem;
    // CONSTRUTOR DEFAULT
    public CarroThread() {
       
    }
    // CONSTRUTOR SOBRECARREGADO
    public CarroThread(String nome, ImageIcon img, int posX, int posY){
    super(img);
    this.imagem = img;
    this.posX = posX;
    this.posY = posY;
 
    carroThread = new Thread(this, nome);
    carroThread.start();
   
    }
    // MÉTODO RUN() DA INTERFACE RUNNABLE
    @Override
    public void run() {
        posX += new Random().nextInt(5) * 10;
        this.setLocation(posX, posY);

        if (posX >= 1000)
            return;

        try {
            Thread.sleep(new Random().nextInt(3) * 100);
            run();
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
}
