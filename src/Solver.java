import java.awt.*;
import javax.swing.*;

public class Solver {
  
  public static void main(String[] args) {
    // Main window
    JFrame win = new JFrame("Rubik's Cube Solver");
    win.setLayout(new GridLayout(2,2));
    win.setLocation(100,100);
    win.setSize(100,100);
    /*  +--------+--------+
     *  |        | cube   |
     *  | title  | view   |
     *  |        |        |
     *  +-----------------+
     *  | pro    | cube   |
     *  | oper   | oper   |
     *  | color  |        |
     *  +-----------------+
     */

    // title
    JLabel title = null;
    try  {
      title = new JLabel(new ImageIcon("../img/Rubiks.png"));
    }
    catch (Exception e) {
      System.out.println("Can't find \"../img/Rubiks.png\"");
    }
    win.add(title);

    // cube view
    JPanel cubeView = Input.CubePanel();
    win.add(cubeView);

    JPanel utils = Input.UtilsPanel();
    win.add(utils);

    JPanel oper = Input.OperationsPanel();
    win.add(oper);
    
    win.pack();
    win.setVisible(true);
    win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
