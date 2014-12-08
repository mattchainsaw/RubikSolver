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

    while(!bottomCorner1(cube)) {
      if (i == 8) {
        i=0;
        cube = c.clone();
        str = "";
      }
      ++i;
      str = cube.rand() + str;
    }
    System.out.println("Done with Step 2A");
    i=0;
    save = save + shorten(reverse(str));
    str = "";
    c = cube.clone();
   
    while(!bottomCorner2(cube)) {
      if (i == 8) {
        i=0;
        cube = c.clone();
        str = "";
      }
      ++i;
      str = cube.rand() + str;
    }
    System.out.println("Done with Step 2B");
    i=0;
    save = save + shorten(reverse(str));
    str = "";
    c = cube.clone();
   
    while(!bottomCorner3(cube)) {
      if (i == 8) {
        i=0;
        cube = c.clone();
        str = "";
      }
      ++i;
      str = cube.rand() + str;
    }
    System.out.println("Done with Step 2C");
    i=0;
    save = save + shorten(reverse(str));
    str = "";
    c = cube.clone();
   
    while(!bottomCorner4(cube)) {
      if (i == 8) {
        i=0;
        cube = c.clone();
        str = "";
      }
      ++i;
      str = cube.rand() + str;
    }
    System.out.println("Done with Step 2D");
    i=0;
    save = save + shorten(reverse(str));
    str = "";
    c = cube.clone();
   
    while(!twoLayers(cube)) { 
/*      if (cube.get(0,1) == 0 && cube.get(1,7) == 4) {
        cube.U();
        cube.R();
        cube.U(false);
        cube.R(false);
        cube.U(false);
        cube.F(false);
        cube.U();
        cube.F();
        str = str + "U  R  U' R' U' F' U  F  ";
      }
      else if (cube.get(0,1) == 0 && cube.get(1,7) == 3) {
        cube.U(false);
        cube.L(false);
        cube.U();
        cube.L();
        cube.U();
        cube.F();
        cube.U(false);
        cube.F(false);
        str = str + "U' L' U  L  U  F  U' F' ";
      }
      else if (cube.get(4,1) == 4 && cube.get(1,5) == 5) {
        cube.U();
        cube.B();
        cube.U(false);
        cube.B(false);
        cube.U(false);
        cube.R(false);
        cube.U();
        cube.R();
        str = str + "U  B  U' B' U' R' U  R  ";
      }
      else if (cube.get(4,1) == 4 && cube.get(1,5) == 0) {
        cube.U(false);
        cube.F(false);
        cube.U();
        cube.F();
        cube.U();
        cube.R();
        cube.U(false);
        cube.R(false);
        str = str + "U' F' U  F  U  R  U' R' ";
      }
      else if (cube.get(3,1) == 3 && cube.get(1,3) == 0) {
        cube.U();
        cube.F();
        cube.U(false);
        cube.F(false);
        cube.U(false);
        cube.L(false);
        cube.U();
        cube.L();
        str = str + "U  F  U' F' U' L' U  L  ";
      }
      else if (cube.get(3,1) == 0 && cube.get(1,3) == 5) {
        cube.U(false);
        cube.B(false);
        cube.U();
        cube.B();
        cube.U();
        cube.L();
        cube.U(false);
        cube.L(false);
        str = str + "U' B' U  B  U  L  U' L' ";
      }
      else if (cube.get(5,1) == 5 && cube.get(1,1) == 3) {
        cube.U();
        cube.L();
        cube.U(false);
        cube.L(false);
        cube.U(false);
        cube.B(false);
        cube.U();
        cube.B();
        str = str + "U  L  U' L' U' B' U  B  ";
      }
      else if (cube.get(5,1) == 5 && cube.get(1,1) == 3) {
        cube.U(false);
        cube.R(false);
        cube.U();
        cube.R();
        cube.U();
        cube.B();
        cube.U(false);
        cube.B(false);
        str = str + "U' R' U  R  U  B  U' B' ";
      }

      else if (cube.get(0,5) == 1 || cube.get(4,3) == 1) {
        cube.U();
        cube.R();
        cube.U(false);
        cube.R(false);
        cube.U(false);
        cube.F(false);
        cube.U();
        cube.F();
        str = str + "U  R  U' R' U' F' U  F  ";
      }
      else if (cube.get(0,3) == 1 || cube.get(3,5) == 1) {
        cube.U(false);
        cube.L(false);
        cube.U();
        cube.L();
        cube.U();
        cube.F();
        cube.U(false);
        cube.F(false);
        str = str + "U' L' U  L  U  F  U' F' ";
      }
      else if (cube.get(4,5) == 1 || cube.get(5,3) == 1) {
        cube.U(false);
        cube.R(false);
        cube.U();
        cube.R();
        cube.U();
        cube.B();
        cube.U(false);
        cube.B(false);
        str = str + "U' R' U  R  U  B  U' B' ";

      }
      else if (cube.get(3,3) == 1 || cube.get(5,5) == 1) {
        cube.U();
        cube.L();
        cube.U(false);
        cube.L(false);
        cube.U(false);
        cube.B(false);
        cube.U();
        cube.B();
        str = str + "U  L  U' L' U' B' U  B  ";

      }
      else { cube.U(); str = "U  " + str; }
*/    if (i == 30) {
        i=0; cube = c.clone(); str = "";
      }
      ++i;
      str = cube.rand() + str;
    }


    System.out.println("Done with Step 3");
    i=0;
    save = save + shorten(str);
    str = "";
    c = cube.clone();
    while (!topCross(cube)) {
      if (i == 30) {
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
      if (i == 30) {
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
    if (!bottomCorner1(c)) return false;
    if (!bottomCorner2(c)) return false;
    if (!bottomCorner3(c)) return false;
    if (!bottomCorner4(c)) return false;
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

  private boolean bottomCorner1(Cube c) {
    if (!(bottomCross(c))) return false;
    if (c.get(2,0) != 2) return false;
    if (c.get(0,6) != 0) return false;
    if (c.get(3,8) != 3) return false;
    return true;
  }

  private boolean bottomCorner2(Cube c) {
    if (!(bottomCross(c))) return false;
    if (c.get(2,2) != 2) return false;
    if (c.get(0,8) != 0) return false;
    if (c.get(4,6) != 4) return false;
    return true;
  }

  private boolean bottomCorner3(Cube c) {
    if (!(bottomCross(c))) return false;
    if (c.get(2,6) != 2) return false;
    if (c.get(3,6) != 3) return false;
    if (c.get(5,8) != 5) return false;
    return true;
  }

  private boolean bottomCorner4(Cube c) {
    if (!(bottomCross(c))) return false;
    if (c.get(2,8) != 2) return false;
    if (c.get(4,8) != 4) return false;
    if (c.get(5,6) != 5) return false;
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
