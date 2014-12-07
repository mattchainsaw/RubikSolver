import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Input {
  
  private static Cube cube = new Cube();
  private static Color color = Color.red;
  private static Color FRONT = Color.red;
  private static Color TOP = Color.yellow;
  private static Color BOTTOM = Color.white;
  private static Color LEFT = Color.green;
  private static Color RIGHT = Color.blue;
  private static Color BACK = Color.orange;
  private static JButton[][] buttons = new JButton[6][9];

  public static JPanel CubePanel() {
    JPanel ret = new JPanel();
    ret.setLayout(new GridLayout(3,4));
    ret.add(new JLabel());                 // keep blank
    ret.add(FacePanel(1));
    ret.add(new JLabel());                 // keep blank
    ret.add(new JLabel());                 // keep blank
    ret.add(FacePanel(3));
    ret.add(FacePanel(0));
    ret.add(FacePanel(4));
    ret.add(FacePanel(5));
    ret.add(new JLabel());                 // keep blank
    ret.add(FacePanel(2));
    ret.add(new JLabel());                 // keep blank
    ret.add(new JLabel());                 // keep blank
    ret.setVisible(true);
    return ret;
  }

  public static JPanel UtilsPanel() {
    return new JPanel();
  }

  public static JPanel OperationsPanel() {
    JPanel ret = new JPanel();
    ret.setLayout(new GridLayout(2,6));
    JButton R = new JButton("R");
    JButton L = new JButton("L");
    JButton U = new JButton("U");
    JButton D = new JButton("D");
    JButton F = new JButton("F");
    JButton B = new JButton("B");
    JButton r = new JButton("r");
    JButton l = new JButton("l");
    JButton u = new JButton("u");
    JButton d = new JButton("d");
    JButton f = new JButton("f");
    JButton b = new JButton("b");

    R.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        cube.R();
        paint();
      }
    });
    ret.add(R);

    L.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        cube.L();
        paint();
      }
    });
    ret.add(L);

    U.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        cube.U();
        paint();
      }
    });
    ret.add(U);

    D.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        cube.D();
        paint();
      }
    });
    ret.add(D);

    F.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        cube.F();
        paint();
      }
    });
    ret.add(F);

    B.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        cube.B();
        paint();
      }
    });
    ret.add(B);

    r.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        cube.R(false);
        paint();
      }
    });
    ret.add(r);

    l.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        cube.L(false);
        paint();
      }
    });
    ret.add(l);

    u.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        cube.U(false);
        paint();
      }
    });
    ret.add(u);

    d.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        cube.D(false);
        paint();
      }
    });
    ret.add(d);

    f.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        cube.F(false);
        paint();
      }
    });
    ret.add(f);

    b.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        cube.B(false);
        paint();
      }
    });
    ret.add(b);

    ret.setVisible(true);
    return ret;
  }

  private static JPanel FacePanel(int c) {
    JPanel ret = new JPanel();
    ret.setLayout(new GridLayout(3,3));
    for (int i=0; i<9; i++) {
      buttons[c][i] = ColorLabel(c,i);
      ret.add(buttons[c][i]);
    }
    ret.setVisible(true);
    return ret;
  }
  private static JButton ColorLabel(final int c, final int i) {
    final JButton box = new JButton();
    Color C = null;
    switch (c) {
      case 0: C = FRONT;
              break;
      case 1: C = TOP;
              break;
      case 2: C = BOTTOM;
              break;
      case 3: C = LEFT;
              break;
      case 4: C = RIGHT;
              break;
      case 5: C = BACK;
              break;
    }
    box.setBackground(C);
    box.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        box.setBackground(color);
        int x = 0; // default is front
        if (color.equals(TOP)) x = 1;
        if (color.equals(BOTTOM)) x = 2;
        if (color.equals(LEFT)) x = 3;
        if (color.equals(RIGHT)) x = 4;
        if (color.equals(BACK)) x = 5;

        cube.set(c,i,x);
      }
    });
    return box;
  }

  private static void paint() {
    for (int i=0; i<6; i++) {
      for (int j=0; j<9; j++) {
        int c = cube.get(i,j);
        Color C = null;
        switch (c) {
          case 0: C = Color.red;
                  break;
          case 1: C = Color.yellow;
                  break;
          case 2: C = Color.white;
                  break;
          case 3: C = Color.green;
                  break;
          case 4: C = Color.blue;
                  break;
          case 5: C = Color.orange;
                  break;
        }
        buttons[i][j].setBackground(C);
      }
    }
  }
}
