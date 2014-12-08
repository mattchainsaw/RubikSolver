/**
 * Algorithm class to solve the cube.
 * @author Matthew Meyer
 */
public class Algorithm implements Solvable {
  
  public Algorithm() {};

  /**
   * Solve method to solve the Cube
   * @return String of moves to make to solve the cube.
   */
  public String solve(Cube cube) {
    String str = "";
    Cube solved = new Cube();
    // NEVER GONNA WORK!
    while (!cube.equals(solved))
      str = str + cube.rand();
    return shorten(str);
  }

  private String shorten(String str) {
    int l = str.length();
    while (true) {
      str = rep(str);
      if (str.length() == l) break;
      l = str.length();
    }
    return str;
  }

  private String rep(String str) {
    str = str.replace("R  R  R  ", "R' ");
    str = str.replace("L  L  L  ", "L' ");
    str = str.replace("U  U  U  ", "U' ");
    str = str.replace("D  D  D  ", "D' ");
    str = str.replace("F  F  F  ", "F' ");
    str = str.replace("B  B  B  ", "B' ");
    str = str.replace("R' R' R' ", "R  ");
    str = str.replace("L' L' L' ", "L  ");
    str = str.replace("U' U' U' ", "U  ");
    str = str.replace("D' D' D' ", "D  ");
    str = str.replace("F' F' F' ", "F  ");
    str = str.replace("B' B' B' ", "B  ");

    str = str.replace("R  R' ", "");
    str = str.replace("L  L' ", "");
    str = str.replace("U  U' ", "");
    str = str.replace("D  D' ", "");
    str = str.replace("F  F' ", "");
    str = str.replace("B  B' ", "");
    str = str.replace("R' R  ", "");
    str = str.replace("L' L  ", "");
    str = str.replace("U' U  ", "");
    str = str.replace("D' D  ", "");
    str = str.replace("F' F  ", "");
    str = str.replace("B' B  ", "");
    return str;
  }
}

