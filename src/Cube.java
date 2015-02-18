import java.util.ArrayList;
import java.util.Random;

/** 
 * Cube class will consist of 6 Faces.
 * This class will be representative of a Rubik's Cube.
 */
public class Cube implements Cloneable {
  
  ///////// Private Data /////////////
  private final ArrayList<Face> cube;
  private transient static Random R;
  ////////////////////////////////////

  /**
   * Construcor of a Cube object.
   * Will automatically be in solved state
   */
  public Cube() {
    R = new Random();
    cube = new ArrayList<Face>();
    for (int i=0; i<6; i++)
      cube.add(new Face(i));
  }

  /////////////////////////// Public Methods ///////////////////////////////////

  /**
   * gets the value of a position of a Face.
   * @param face The Face of interest on the Cube
   * @param pos The Position of the Face
   * @return Returns the value of the specified position
   */
  public int get(int face, int pos) { return cube.get(face).get(pos); }

  /**
   * sets a position on the cube to a certain value.
   * @param face The Face of the Cube
   * @param pos The Position of the Face
   * @param val The new value
   */
  public void set(int face, int pos, int val) { cube.get(face).set(pos, val); }

  /** 
   * Freshens up the cube.
   * This will make the cube return to the solved state
   */
  public void Fresh() {
    for (int i=0; i<6; i++)
      for (int j=0; j<9; j++)
        set(i,j,i);
  }

  /**
   * Moves the cube randomly a certain number of moves.
   * @param moves number of random moves.
   */
  public String move(final int moves) {
    String s = "";
    for (int i=0; i<moves; i++) 
      s += rand();
    return s;
  }

  /** 
   * Makes a single random turn
   * @return string of moves the cube made.
   */
  public String rand() {
      int x = R.nextInt(6);
      boolean b = R.nextBoolean();
      if      (x == 0) {
        R(b);
        return "R" + ((b) ? "  ":"' ");
      }
      else if (x == 1) {
        L(b);
        return "L" + ((b) ? "  ":"' ");
      }
      else if (x == 2) {
        U(b);
        return "U" + ((b) ? "  ":"' ");
      }
      else if (x == 3) {
        D(b);
        return "D" + ((b) ? "  ":"' ");
      }
      else if (x == 4) {
        F(b);
        return "F" + ((b) ? "  ":"' ");
      }
      else {
        B(b);
        return "B" + ((b) ? "  ":"' ");
      }
  }

  // Probably will never succeed
  /**
   * solve.
   * This method solves the cube and tells the user what steps to take using standard notation
   * @param s An instance of Solvable, an algorithm for the Cube
   * @return A String of turns to do to reach the solved state.
   */
  public String solve(Solvable s) {
    return s.solve(this.clone());
  }

  /**
   * Check to see if an instance of a Cube is valid for solving.
   * @return true if valid
   */
  public boolean Valid() {
    int[] x = new int[6];
    for (int i=0; i<6; i++) 
      for (int j=0; j<9; j++)
        x[get(i,j)] += 1;
    for (int i=0; i<6; i++)
      if (x[i] != 9) return false;
    return true;
  }
  
  /////////////////////// Standard Functions ///////////////////////////////////

  /**
   * to String
   * @return returns a long string that displays the cube in two dimensions
   */
  public String toString() {
    return  "      " + get(1,0) + " " + get(1,1) + " " + get(1,2) + "\n" +
            "      " + get(1,3) + " " + get(1,4) + " " + get(1,5) + "\n" +
            "      " + get(1,6) + " " + get(1,7) + " " + get(1,8) + "\n" +
                       
                       get(3,0) + " " + get(3,1) + " " + get(3,2) + " "  + 
                       get(0,0) + " " + get(0,1) + " " + get(0,2) + " "  + 
                       get(4,0) + " " + get(4,1) + " " + get(4,2) + " "  + 
                       get(5,0) + " " + get(5,1) + " " + get(5,2) + "\n" + 
                       
                       get(3,3) + " " + get(3,4) + " " + get(3,5) + " "  + 
                       get(0,3) + " " + get(0,4) + " " + get(0,5) + " "  + 
                       get(4,3) + " " + get(4,4) + " " + get(4,5) + " "  + 
                       get(5,3) + " " + get(5,4) + " " + get(5,5) + "\n" + 
                       
                       get(3,6) + " " + get(3,7) + " " + get(3,8) + " "  + 
                       get(0,6) + " " + get(0,7) + " " + get(0,8) + " "  + 
                       get(4,6) + " " + get(4,7) + " " + get(4,8) + " "  + 
                       get(5,6) + " " + get(5,7) + " " + get(5,8) + "\n" +

            "      " + get(2,0) + " " + get(2,1) + " " + get(2,2) + "\n" +
            "      " + get(2,3) + " " + get(2,4) + " " + get(2,5) + "\n" +
            "      " + get(2,6) + " " + get(2,7) + " " + get(2,8) + "\n";
  }

  /**
   * Like toString, but no spaces
   * @return String of numbers representing cube.
   */
  public String toFile() {
    return this.toString().replace('\n',' ').replace(" ","");
  }

  public void fromFile(String s) {
    int i=0;
    int j=-1;
    for (char c: s.toCharArray()) {
      if (i == 0) ++j;
      int x = c - '0';
      set(j,i,x);
      i = (i+1)%9;
    }
  }

  /**
   * Copy.
   * @return an identical deep copy of the cube.
   */
  public Cube clone() {
    Cube c = new Cube();
    for (int i=0; i<6; i++) {
      for (int j=0; j<9; j++) {
        c.set(i,j,get(i,j));
      }
    }
    return c;
  }

  /**
   * Checks to see if two Cube objects are equal
   * @return true if equal
   */
  public boolean equals(Cube other) {
    for (int i=0; i<6; i++)
      for (int j=0; j<9; j++)
        if (get(i,j) != other.get(i,j))
          return false;
    return true;
  }

  // Different Operations
  // R(), L(), U(), D(), F(), B()
  // true for clockwise
  // false for counter-clockwise
  // no arg = true;
  
  /** Rotates the right side of the cube clockwise */
  public void R() { R(true); }
  
  /** Rotates the right side of the cube 
   * @param cw Clockwise if true, counter-clockwise if false
   */
  public void R(boolean cw) {
    cube.get(4).Turn(cw);
    int temp1 = cube.get(0).get(2);
    int temp2 = cube.get(0).get(5);
    int temp3 = cube.get(0).get(8);
    if (cw) {
      set(0,2,get(2,2));
      set(0,5,get(2,5));
      set(0,8,get(2,8));
      set(2,2,get(5,6));
      set(2,5,get(5,3));
      set(2,8,get(5,0));
      set(5,0,get(1,8));
      set(5,3,get(1,5));
      set(5,6,get(1,2));
      set(1,2,temp1);
      set(1,5,temp2);
      set(1,8,temp3);
    }
    else {
      set(0,2,get(1,2));
      set(0,5,get(1,5));
      set(0,8,get(1,8));
      set(1,2,get(5,6));
      set(1,5,get(5,3));
      set(1,8,get(5,0));
      set(5,0,get(2,8));
      set(5,3,get(2,5));
      set(5,6,get(2,2));
      set(2,2,temp1);
      set(2,5,temp2);
      set(2,8,temp3);
    }
  }
    
  /** Rotates the left side of the cube clockwise */
  public void L() { L(true); }
  /** Rotates the left side of the cube 
   * @param cw Clockwise if true, counter-clockwise if false
   */
  public void L(boolean cw) {
    cube.get(3).Turn(cw);
    int temp1 = cube.get(0).get(0);
    int temp2 = cube.get(0).get(3);
    int temp3 = cube.get(0).get(6);
    if (cw) {
      set(0,0,get(1,0));
      set(0,3,get(1,3));
      set(0,6,get(1,6));
      set(1,0,get(5,8));
      set(1,3,get(5,5));
      set(1,6,get(5,2));
      set(5,2,get(2,6));
      set(5,5,get(2,3));
      set(5,8,get(2,0));
      set(2,0,temp1);
      set(2,3,temp2);
      set(2,6,temp3);
    }
    else {
      set(0,0,get(2,0));
      set(0,3,get(2,3));
      set(0,6,get(2,6));
      set(2,0,get(5,8));
      set(2,3,get(5,5));
      set(2,6,get(5,2));
      set(5,2,get(1,6));
      set(5,5,get(1,3));
      set(5,8,get(1,0));
      set(1,0,temp1);
      set(1,3,temp2);
      set(1,6,temp3);
    }
  }
    
  /** Rotates the upper side of the cube clockwise */
  public void U() { U(true); }
  /** Rotates the upper side of the cube 
   * @param cw Clockwise if true, counter-clockwise if false
   */
  public void U(boolean cw) {
    cube.get(1).Turn(cw);
    int temp1 = cube.get(0).get(0);
    int temp2 = cube.get(0).get(1);
    int temp3 = cube.get(0).get(2);
    if (cw) {
      set(0,0,get(4,0));
      set(0,1,get(4,1));
      set(0,2,get(4,2));
      set(4,0,get(5,0));
      set(4,1,get(5,1));
      set(4,2,get(5,2));
      set(5,0,get(3,0));
      set(5,1,get(3,1));
      set(5,2,get(3,2));
      set(3,0,temp1);
      set(3,1,temp2);
      set(3,2,temp3);
    }
    else {
      set(0,0,get(3,0));
      set(0,1,get(3,1));
      set(0,2,get(3,2));
      set(3,0,get(5,0));
      set(3,1,get(5,1));
      set(3,2,get(5,2));
      set(5,0,get(4,0));
      set(5,1,get(4,1));
      set(5,2,get(4,2));
      set(4,0,temp1);
      set(4,1,temp2);
      set(4,2,temp3);
    }
  }  
  
  /** Rotates the down side of the cube clockwise */
  public void D() { D(true); }
  /** Rotates the down side of the cube 
   * @param cw Clockwise if true, counter-clockwise if false
   */
  public void D(boolean cw) {
    cube.get(2).Turn(cw);
    int temp1 = cube.get(0).get(6);
    int temp2 = cube.get(0).get(7);
    int temp3 = cube.get(0).get(8);
    if (cw) {
      set(0,6,get(3,6));
      set(0,7,get(3,7));
      set(0,8,get(3,8));
      set(3,6,get(5,6));
      set(3,7,get(5,7));
      set(3,8,get(5,8));
      set(5,6,get(4,6));
      set(5,7,get(4,7));
      set(5,8,get(4,8));
      set(4,6,temp1);
      set(4,7,temp2);
      set(4,8,temp3);
    }
    else {
      set(0,6,get(4,6));
      set(0,7,get(4,7));
      set(0,8,get(4,8));
      set(4,6,get(5,6));
      set(4,7,get(5,7));
      set(4,8,get(5,8));
      set(5,6,get(3,6));
      set(5,7,get(3,7));
      set(5,8,get(3,8));
      set(3,6,temp1);
      set(3,7,temp2);
      set(3,8,temp3);
    }
  }  
  
  /** Rotates the front side of the cube clockwise */
  public void F() { F(true); }
  /** Rotates the front side of the cube 
   * @param cw Clockwise if true, counter-clockwise if false
   */
  public void F(boolean cw) {
    cube.get(0).Turn(cw);
    int temp1 = cube.get(1).get(6);
    int temp2 = cube.get(1).get(7);
    int temp3 = cube.get(1).get(8);
    if (cw) {
      set(1,6,get(3,8));
      set(1,7,get(3,5));
      set(1,8,get(3,2));
      set(3,2,get(2,0));
      set(3,5,get(2,1));
      set(3,8,get(2,2));
      set(2,0,get(4,6));
      set(2,1,get(4,3));
      set(2,2,get(4,0));
      set(4,0,temp1);
      set(4,3,temp2);
      set(4,6,temp3);
    }
    else {
      set(1,6,get(4,0));
      set(1,7,get(4,3));
      set(1,8,get(4,6));
      set(4,0,get(2,2));
      set(4,3,get(2,1));
      set(4,6,get(2,0));
      set(2,0,get(3,2));
      set(2,1,get(3,5));
      set(2,2,get(3,8));
      set(3,8,temp1);
      set(3,5,temp2);
      set(3,2,temp3);
    }
  }  
  
  /** Rotates the back side of the cube clockwise */
  public void B() { B(true); }
  /** Rotates the back side of the cube 
   * @param cw Clockwise if true, counter-clockwise if false
   */
  public void B(boolean cw) {
    cube.get(5).Turn(cw);
    int temp1 = cube.get(1).get(0);
    int temp2 = cube.get(1).get(1);
    int temp3 = cube.get(1).get(2);
    if (cw) {
      set(1,0,get(4,2));
      set(1,1,get(4,5));
      set(1,2,get(4,8));
      set(4,2,get(2,8));
      set(4,5,get(2,7));
      set(4,8,get(2,6));
      set(2,6,get(3,0));
      set(2,7,get(3,3));
      set(2,8,get(3,6));
      set(3,0,temp3);
      set(3,3,temp2);
      set(3,6,temp1);
    }
    else {
      set(1,0,get(3,6));
      set(1,1,get(3,3));
      set(1,2,get(3,0));
      set(3,0,get(2,6));
      set(3,3,get(2,7));
      set(3,6,get(2,8));
      set(2,6,get(4,8));
      set(2,7,get(4,5));
      set(2,8,get(4,2));
      set(4,2,temp1);
      set(4,5,temp2);
      set(4,8,temp3);
    }
  }  
}
