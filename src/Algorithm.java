/**
 * Algorithm class to solve the cube.
 * @author Matthew Meyer
 */
public class Algorithm implements Solvable {
  
  public Algorithm() {}

  /**
   * Solve method to solve the Cube
   * @return String of moves to make to solve the cube.
   */
  public String solve(Cube cube) {
    String str = "";
    Cube c = cube.clone();
    String save = "";
    int i=0;
    // NEVER GONNA WORK!
/*    Cube C = new Cube();
    while (!cube.equals(C)) {
      if (i == 50) {
        str = "";
        i=0;
        cube = c.clone();
      }
      ++i;
      str = cube.rand() + str;
    }
    save = save + shorten(reverse(str));
*/
    
    while (!bottomCross(cube)) {
      if (i == 12) {
        i = 0;
        cube = c.clone();
        str = "";
      }
      ++i;
      str = cube.rand() + str;
    }
    System.out.println("Done with Step 1");
    i=0;
    save = shorten(reverse(str));
    str = "";
    c = cube.clone();
    while(!bottomCorners(cube)) {
      if (i == 25) {
        i=0;
        cube = c.clone();
        str = "";
      }
      ++i;
      str = cube.rand() + str;
    }
    System.out.println("Done with Step 2");
    i=0;
    save = save + shorten(reverse(str));
    str = "";
    c = cube.clone();
    while(!twoLayers(cube)) {
      if (i == 25) {
        i=0; cube = c.clone(); str = "";
      }
      ++i; 
      str = cube.rand() + str;
    }
    System.out.println("Done with Step 3");
    i=0;
    save = save + shorten(reverse(str));
    str = "";
    c = cube.clone();
    while (!topCross(cube)) {
      if (i == 25) {
        i=0; cube = c.clone(); str = "";
      }
      ++i;
      str = cube.rand() + str;
    }
    System.out.println("Done with Step 4");
    i=0;
    save = save + shorten(reverse(str));
    str = "";
    c = cube.clone();
    while (!topCorn(cube)) {
      if (i == 35) {
        i=0; cube = c.clone(); str = "";
      }
      ++i;
      str = cube.rand() + str;
    }
    System.out.println("Done with Step 5");
    i=0;
    save = save + shorten(reverse(str));
    str = "";
    c = cube.clone();

    return shorten(save);
   } 



  // bools //
  
  private boolean topCorn(Cube c) {
    if (!topCross(c)) return false;
    if (c.get(0,0) != 0) return false;
    if (c.get(0,2) != 0) return false;
    if (c.get(3,0) != 3) return false;
    if (c.get(3,2) != 3) return false;
    if (c.get(4,0) != 4) return false;
    if (c.get(4,2) != 4) return false;
    if (c.get(5,0) != 5) return false;
    if (c.get(5,2) != 5) return false;
    if (c.get(1,2) != 1) return false;
    if (c.get(1,6) != 1) return false;
    if (c.get(1,8) != 1) return false;
    if (c.get(1,0) != 1) return false;
    return true;
  }

  private boolean topCross(Cube c) {
    if (!twoLayers(c)) return false;
    if (c.get(1,1) != 1) return false;
    if (c.get(1,3) != 1) return false;
    if (c.get(1,5) != 1) return false;
    if (c.get(1,7) != 1) return false;
    if (c.get(0,1) != 0) return false;
    if (c.get(3,1) != 3) return false;
    if (c.get(4,1) != 4) return false;
    if (c.get(5,1) != 5) return false;
    return true;
  }

  private boolean twoLayers(Cube c) {
    if (!bottomCorners(c)) return false;
    if (c.get(0,3) != 0) return false;
    if (c.get(0,5) != 0) return false;
    if (c.get(3,3) != 3) return false;
    if (c.get(3,5) != 3) return false;
    if (c.get(4,3) != 4) return false;
    if (c.get(4,5) != 4) return false;
    if (c.get(5,3) != 5) return false;
    if (c.get(5,5) != 5) return false;
    return true;
  }

  private boolean bottomCross(Cube c) {
    if (c.get(2,1) != 2) return false;
    if (c.get(2,3) != 2) return false;
    if (c.get(2,4) != 2) return false;
    if (c.get(2,5) != 2) return false;
    if (c.get(2,7) != 2) return false;
    if (c.get(0,7) != 0) return false;
    if (c.get(3,7) != 3) return false;
    if (c.get(4,7) != 4) return false;
    if (c.get(5,7) != 5) return false;
    return true;
  }

  private boolean bottomCorners(Cube c) {
    if (!(bottomCross(c))) return false;
    if (c.get(2,0) != 2) return false;
    if (c.get(2,2) != 2) return false;
    if (c.get(2,6) != 2) return false;
    if (c.get(2,8) != 2) return false;
    if (c.get(0,6) != 0) return false;
    if (c.get(0,8) != 0) return false;
    if (c.get(3,6) != 3) return false;
    if (c.get(3,8) != 3) return false;
    if (c.get(4,6) != 4) return false;
    if (c.get(4,8) != 4) return false;
    if (c.get(5,6) != 5) return false;
    if (c.get(5,8) != 5) return false;
    return true;
  }

  ////// String manip ////////////////

  private String reverse(String str) {
    char[] c = str.toCharArray();
    for (int i=0; i<str.length(); i+= 3) {
      char t = c[i];
      c[i] = c[i+2];
      c[i+2] = t;
    }
    return new StringBuffer(new String(c)).reverse().toString(); // <-- what a freakin mess
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
