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
    Cube orig = cube.clone();
    Cube c = cube.clone();
    String save = "";
    int i=0;
    
    while (!bottomCross(cube)) {
      if (i == 12) {
        i = 0;
        cube = c.clone();
        str = "";
      }
      ++i;
      str = str + cube.rand();
    }
    System.out.println("Done with Step 1");
    i=0;
    save = shorten(str);
    str = "";
    c = cube.clone();

    while(!bottomCorner1(cube)) {
      if (i == 8) {
        i=0;
        cube = c.clone();
        str = "";
      }
      ++i;
      str = str + cube.rand();
    }
    System.out.println("Done with Step 2A");
    i=0;
    save = save + shorten(str);
    str = "";
    c = cube.clone();
   
    while(!bottomCorner2(cube)) {
      if (i == 8) {
        i=0;
        cube = c.clone();
        str = "";
      }
      ++i;
      str = str + cube.rand();
    }
    System.out.println("Done with Step 2B");
    i=0;
    save = save + shorten(str);
    str = "";
    c = cube.clone();
   
    while(!bottomCorner3(cube)) {
      if (i == 8) {
        i=0;
        cube = c.clone();
        str = "";
      }
      ++i;
      str = str + cube.rand();
    }
    System.out.println("Done with Step 2C");
    i=0;
    save = save + shorten(str);
    str = "";
    c = cube.clone();
   
    while(!bottomCorner4(cube)) {
      if (i == 8) {
        i=0;
        cube = c.clone();
        str = "";
      }
      ++i;
      str = str + cube.rand();
    }
    System.out.println("Done with Step 2D");
    save = save + shorten(str);
    str = "";
     
    while(!twoLayers(cube)) { 
      if (cube.get(0,1) == 0 && cube.get(1,7) == 4) {
        cube.U(); cube.R(); cube.U(false); cube.R(false);
        cube.U(false); cube.F(false); cube.U(); cube.F();
        str = str + "U  R  U' R' U' F' U  F  ";
      }
      else if (cube.get(0,1) == 0 && cube.get(1,7) == 3) {
        cube.U(false); cube.L(false); cube.U(); cube.L();
        cube.U(); cube.F(); cube.U(false); cube.F(false);
        str = str + "U' L' U  L  U  F  U' F' ";
      }
      else if (cube.get(4,1) == 4 && cube.get(1,5) == 5) {
        cube.U(); cube.B(); cube.U(false); cube.B(false);
        cube.U(false); cube.R(false); cube.U(); cube.R();
        str = str + "U  B  U' B' U' R' U  R  ";
      }
      else if (cube.get(4,1) == 4 && cube.get(1,5) == 0) {
        cube.U(false); cube.F(false); cube.U(); cube.F();
        cube.U(); cube.R(); cube.U(false); cube.R(false);
        str = str + "U' F' U  F  U  R  U' R' ";
      }
      else if (cube.get(3,1) == 3 && cube.get(1,3) == 0) {
        cube.U(); cube.F(); cube.U(false); cube.F(false);
        cube.U(false); cube.L(false); cube.U(); cube.L();
        str = str + "U  F  U' F' U' L' U  L  ";
      }
      else if (cube.get(3,1) == 3 && cube.get(1,3) == 5) {
        cube.U(false); cube.B(false); cube.U(); cube.B();
        cube.U(); cube.L(); cube.U(false); cube.L(false);
        str = str + "U' B' U  B  U  L  U' L' ";
      }
      else if (cube.get(5,1) == 5 && cube.get(1,1) == 3) {
        cube.U(); cube.L(); cube.U(false); cube.L(false);
        cube.U(false); cube.B(false); cube.U(); cube.B();
        str = str + "U  L  U' L' U' B' U  B  ";
      }
      else if (cube.get(5,1) == 5 && cube.get(1,1) == 4) {
        cube.U(false); cube.R(false); cube.U(); cube.R();
        cube.U(); cube.B(); cube.U(false); cube.B(false);
        str = str + "U' R' U  R  U  B  U' B' ";
      }
      else if (cube.get(0,3) == 3 && cube.get(3,5) == 0) {
        cube.F(); cube.F(); cube.U(); cube.U(); cube.L(); cube.F(); 
        cube.F(); cube.L(false); cube.U(); cube.U(); cube.F(false); 
        cube.U(); cube.F(false);
        str = str + "F  F  U  U  L  F  F  L' U  U  F' U  F' ";
      }
      else if (cube.get(0,5) == 4 && cube.get(4,3) == 0) {
        cube.R(); cube.R(); cube.U(); cube.U(); cube.F(); cube.R(); 
        cube.R(); cube.F(false); cube.U(); cube.U(); cube.R(false);
        cube.U(); cube.R(false);
        str = str + "R  R  U  U  F  R  R  F' U  U  R' U  R' ";
      }
      else if (cube.get(5,3) == 4 && cube.get(4,5) == 5) {
        cube.B(); cube.B(); cube.U(); cube.U(); cube.R(); cube.B(); 
        cube.B(); cube.R(false); cube.U(); cube.U(); cube.B(false); 
        cube.U(); cube.B(false);
        str = str + "B  B  U  U  R  B  B  R' U  U  B' U  B' ";
      }
      else if (cube.get(5,5) == 3 && cube.get(3,3) == 5) {
        cube.L(); cube.L(); cube.U(); cube.U(); cube.B(); cube.L(); 
        cube.L(); cube.B(false); cube.U(); cube.U(); cube.L(false); 
        cube.U(); cube.L(false);
        str = str + "L  L  U  U  B  L  L  B' U  U  L' U  L' ";
      }
      else {
        cube.U(); 
        str = str + "U  "; 
      }
    }

    System.out.println("Done with Step 3");
    save = save + shorten(str);
    str = "";
    while (!topCross(cube)) {
      if (cube.get(1,1) == 1 && cube.get(1,3) == 1 &&
          cube.get(1,5) != 1 && cube.get(1,7) != 1) {
        cube.F(); cube.U(); cube.R(); cube.U(false); cube.R(false); cube.F(false);
        str = str + "F  U  R  U' R' F' ";
      }
      else if (cube.get(1,1) != 1 && cube.get(1,3) == 1 &&
          cube.get(1,5) == 1 && cube.get(1,7) != 1) {
        cube.F(); cube.R(); cube.U(); cube.R(false); cube.U(false); cube.F(false);
        str = str + "F  R  U  R' U' F' ";
      }
      else if (cube.get(1,1) != 1 && cube.get(1,3) != 1 &&
          cube.get(1,5) != 1 && cube.get(1,7) != 1) {
        cube.F(); cube.U(); cube.R(); cube.U(false); cube.R(false); cube.F(false);
        str = str + "F  U  R  U' R' F' ";
      }
      else {
        cube.U(); str = str + "U  ";
      }
    }

    System.out.println("Done with Step 4A");
    save = save + shorten(str);
    str = "";
    while (!top(cube)) {
      if (cube.get(1,0) != 1 && cube.get(1,2) != 1 &&
          cube.get(1,6) != 1 && cube.get(1,8) != 1) {
        while (cube.get(3,2) != 1) {
          cube.U();
          str = str + "U  ";
        }
      }
      else if (
          (cube.get(1,0) == 1 && cube.get(1,2) != 1 &&
          cube.get(1,6) != 1 && cube.get(1,8) != 1) ||
          (cube.get(1,0) != 1 && cube.get(1,2) == 1 &&
          cube.get(1,6) != 1 && cube.get(1,8) != 1) ||
          (cube.get(1,0) != 1 && cube.get(1,2) != 1 &&
          cube.get(1,6) == 1 && cube.get(1,8) != 1) ||
          (cube.get(1,0) != 1 && cube.get(1,2) != 1 &&
          cube.get(1,6) != 1 && cube.get(1,8) == 1) ) {
        while (cube.get(1,6) != 1) {
          cube.U();
          str = str + "U  ";
        }
      }
      else {
        while (cube.get(0,0) != 1) {
          cube.U();
          str = str + "U  ";
        }
      }
      cube.R(); cube.U(); cube.R(false); cube.U();
      cube.R(); cube.U(); cube.U(); cube.R(false);
      str = str + "R  U  R' U  R  U  U  R' ";
    }
    System.out.println("Done with Step 4B");
    
    save = save + shorten(str);
    str = "";    
    c = cube.clone();
    i=0;int j=0;
    while (!solved(cube)) {
      if (i == 30) {
        i = 0;
        cube = c.clone();
        str = "";
      }
      ++i;++j;
      str = str + cube.rand();
      if (j == 10000) {
        str = "Try to rip off the stickers!";
        break;
      }
    }
    System.out.println("Done with Step 5");

    save = save + str;
    if (save.contains("Try")) {
      save = orig.move(5);
      save = save + orig.solve(new Algorithm());
    }
      
    return shorten(save);        
   } 


  // bools //
  private boolean solved(Cube c) {
    if (!top(c)) return false;
    if (c.get(0, 0) != 0) return false;
    if (c.get(0, 2) != 0) return false;
    if (c.get(3, 0) != 3) return false;
    if (c.get(3, 2) != 3) return false;
    if (c.get(4, 0) != 4) return false;
    if (c.get(4, 2) != 4) return false;
    return c.get(5, 0) == 5 && c.get(5, 2) == 5;
  }
  
  private boolean solvedE(Cube c) {
    if (!top(c)) return false;
    if (c.get(0, 1) != 0) return false;
    if (c.get(3, 1) != 3) return false;
    return c.get(4, 1) == 4 && c.get(5, 1) == 5;
  }

  private boolean top(Cube c) {
    if (!twoLayers(c)) return false;
    if (c.get(1, 0) != 1) return false;
    if (c.get(1, 2) != 1) return false;
    return c.get(1, 6) == 1 && c.get(1, 8) == 1;
  }

  private boolean topCross(Cube c) {
    if (!twoLayers(c)) return false;
    if (c.get(1, 1) != 1) return false;
    if (c.get(1, 3) != 1) return false;
    if (c.get(1, 4) != 1) return false;
    return c.get(1, 5) == 1 && c.get(1, 7) == 1;
  }

  private boolean twoLayers(Cube c) {
    if (!bottomCorner4(c)) return false;
    if (c.get(0, 3) != 0) return false;
    if (c.get(0, 5) != 0) return false;
    if (c.get(3, 3) != 3) return false;
    if (c.get(3, 5) != 3) return false;
    if (c.get(4, 3) != 4) return false;
    if (c.get(4, 5) != 4) return false;
    return c.get(5, 3) == 5 && c.get(5, 5) == 5;
  }

  private boolean bottomCross(Cube c) {
    if (c.get(2, 1) != 2) return false;
    if (c.get(2, 3) != 2) return false;
    if (c.get(2, 4) != 2) return false;
    if (c.get(2, 5) != 2) return false;
    if (c.get(2, 7) != 2) return false;
    if (c.get(0, 7) != 0) return false;
    if (c.get(3, 7) != 3) return false;
    return c.get(4, 7) == 4 && c.get(5, 7) == 5;
  }

  private boolean bottomCorner1(Cube c) {
    if (!(bottomCross(c))) return false;
    if (c.get(2, 0) != 2) return false;
    return c.get(0, 6) == 0 && c.get(3, 8) == 3;
  }

  private boolean bottomCorner2(Cube c) {
    if (!(bottomCorner1(c))) return false;
    if (c.get(2, 2) != 2) return false;
    return c.get(0, 8) == 0 && c.get(4, 6) == 4;
  }

  private boolean bottomCorner3(Cube c) {
    if (!(bottomCorner2(c))) return false;
    if (c.get(2, 6) != 2) return false;
    return c.get(3, 6) == 3 && c.get(5, 8) == 5;
  }

  private boolean bottomCorner4(Cube c) {
    if (!(bottomCorner3(c))) return false;
    if (c.get(2, 8) != 2) return false;
    return c.get(4, 8) == 4 && c.get(5, 6) == 5;
  }

  ////// String manip ////////////////

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
