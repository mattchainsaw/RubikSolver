import java.awt.*;
import javax.swing.*;

/** 
 * Main class to run the Rubik's Cube Solver program.
 * @author Matthew Meyer
 */
public class RubikSolver {
  
  public static void main(String[] args) {
    // Main window
    JFrame win = new JFrame("Rubik's Cube Solver");
    win.setLayout(new GridLayout(2,2));
    win.setLocation(100,100);
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
    JPanel JP = new JPanel();
    JP.setLayout(new FlowLayout());
//    JP.add(new JLabel("Rubik's Cube Solver!\nBy: Matthew Meyer"));
    JLabel title = null;
      title = new JLabel(new ImageIcon("./img/Rubiks.png"));
    if (title == null) title = new JLabel(new ImageIcon("../img/Rubiks.png"));
    if (title == null) {
      System.out.println("Can't find \"Rubiks.png\"");
      System.exit(1);
    }
    JP.add(title);
    JP.setVisible(true);
    win.add(JP);

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
