import java.awt.Graphics;
import javax.swing.JComponent;

public class MyCustomJComponent extends JComponent {
   public void paintComponent(Graphics g) {
      // Cast to Graphics2D
      Graphics2D graphicsObj = (Graphics2D)g;

      // Write your drawing instructions
   }
}
