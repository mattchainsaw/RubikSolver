
import java.util.Scanner;

public class Input {
  
  public static void main(String[] args) {
    Cube c = new Cube();
    in(c);
    print("\n\n\nDONE!");
    print(c.toString());
  }

  ///// Utility Functions and Members /////

  public static void print(String str) {
    System.out.println(str);
  }

  public static void clear() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
    print("Rubik's Cube Solver\nMatthew Meyer\n");
  }

  public static void in(Cube c) {
    clear();
    String[] side = {"front", "top", "bottom", "left", "right", "back", "DONE!"};
    Scanner in = new Scanner(System.in);
    int x;
    print(side[0]);
    print("\n" + c.toString());
    for (int i=0; i<6; i++) {
      for (int j=0; j<9; j++) {
        print("Please enter in 0-5, one by one, left to right, top to bottom, on the " + side[i] + " side of the cube.");
        x = in.nextInt();
        while (x < 0 || x > 5) {
          print("Try again. (0-5)");
          x = in.nextInt();
        }
        c.set(i,j,x);
        clear();
        print(side[i + (j==8 ? 1:0)]);
        print("\n" + c.toString());
      }
    }
  }
}
