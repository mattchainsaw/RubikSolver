import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Scanner;
import java.io.File;

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
    JPanel ret = new JPanel();
    ret.setLayout(new GridLayout(2,1));
    ret.add(UtilButtons(), BorderLayout.CENTER);
    ret.add(ColorButtons(), BorderLayout.SOUTH);
    ret.setVisible(true);
    return ret;
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
    JButton r = new JButton("R'");
    JButton l = new JButton("L'");
    JButton u = new JButton("U'");
    JButton d = new JButton("D'");
    JButton f = new JButton("F'");
    JButton b = new JButton("B'");

    R.setFont(new Font("Arial", Font.PLAIN, 40));
    L.setFont(new Font("Arial", Font.PLAIN, 40));
    U.setFont(new Font("Arial", Font.PLAIN, 40));
    D.setFont(new Font("Arial", Font.PLAIN, 40));
    F.setFont(new Font("Arial", Font.PLAIN, 40));
    B.setFont(new Font("Arial", Font.PLAIN, 40));
    r.setFont(new Font("Arial", Font.PLAIN, 40));
    l.setFont(new Font("Arial", Font.PLAIN, 40));
    u.setFont(new Font("Arial", Font.PLAIN, 40));
    d.setFont(new Font("Arial", Font.PLAIN, 40));
    f.setFont(new Font("Arial", Font.PLAIN, 40));
    b.setFont(new Font("Arial", Font.PLAIN, 40));

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
        Color before = box.getBackground();
        box.setBackground(color);
        
        if (!color.equals(FRONT) && !color.equals(TOP)   && !color.equals(BOTTOM) &&
            !color.equals(LEFT)  && !color.equals(RIGHT) && !color.equals(BACK)) {
          if (before.equals(FRONT)) FRONT = color;
          if (before.equals(TOP)) TOP = color;
          if (before.equals(BOTTOM)) BOTTOM = color;
          if (before.equals(LEFT)) LEFT = color;
          if (before.equals(RIGHT)) RIGHT = color;
          if (before.equals(BACK)) BACK = color;
          paint();
        }
        
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
        buttons[i][j].setBackground(C);
      }
    }
  }
    
  
  
  private static JPanel UtilButtons() {
    JPanel ret = new JPanel();
    JButton help = new JButton("Help");
    JButton solve = new JButton("Solve");
    JButton reset = new JButton("Reset");
    
    help.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        JFrame win = new JFrame("Rubik's Cube Help");

        JTextArea text = new JTextArea();
        win.getContentPane().add(text);

        File file = new File("./res/help.txt");
        if (file == null) file = new File("../res/help.txt");
        try {
          Scanner s = new Scanner(file);
          while (s.hasNextLine()) {
            text.append(s.nextLine() + "\n");
          }
        }
        catch (Exception e) {
          e.printStackTrace();
        }
        text.setEditable(false);
        text.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        win.pack();
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      }
    });



    reset.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        cube.Fresh();
        paint();
      }
    });

    ret.add(help);
    ret.add(solve);
    ret.add(reset);
    ret.setVisible(true);
    return ret; 
  }
   
  
  
  private static JPanel ColorButtons() {
    JPanel ret = new JPanel();
    ret.setLayout(new GridLayout(2,5));
    ret.add(cb(Color.black));
    ret.add(cb(Color.blue));
    ret.add(cb(Color.cyan));
    ret.add(cb(Color.green));
    ret.add(cb(Color.magenta));
    ret.add(cb(Color.orange));
    ret.add(cb(Color.pink));
    ret.add(cb(Color.red));
    ret.add(cb(Color.white));
    ret.add(cb(Color.yellow));
    ret.setVisible(true);
    return ret;
  }


  private static JButton cb(final Color c) {
    JButton jb = new JButton();
    jb.setBackground(c);
    jb.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        color = c;
      }
    });
    return jb;
  }













}
