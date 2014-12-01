import java.util.ArrayList;

/** 
 * Cube class will consist of 6 Faces.
 * This class will be representative of a Rubik's Cube.
 */
public class Cube {
  /**
   * Construcor of a Cube object.
   */
  public Cube() {
    cube = new ArrayList<Face>();
    for (int i=0; i<6; i++)
      cube.add(new Face(i));
  }

  /**
   * Gets the value of a position of a Face.
   * @param face The Face of interest on the Cube
   * @param pos The Position of the Face
   * @return Returns the value of the specified position
   */
  public int Get(int face, int pos) { return cube.get(face).Get(pos); }

  /**
   * Sets a position on the cube to a certain value.
   * @param face The Face of the Cube
   * @param pos The Position of the Face
   * @param val The new value
   */
  public void Set(int face, int pos, int val) { cube.get(face).Set(pos, val); }

  // Different Operations
  
  /** Rotates the right side of the cube clockwise */
  public void R() { R(true); }
  
  /** Rotates the right side of the cube 
   * @param cw Clockwise if true, counter-clockwise if false
   */
  public void R(boolean cw) {
    cube.get(4).Turn(cw);
    int temp1 = cube.get(0).Get(2);
    int temp2 = cube.get(0).Get(5);
    int temp3 = cube.get(0).Get(8);
    if (cw) {
      Set(0,2,Get(2,2));
      Set(0,5,Get(2,5));
      Set(0,8,Get(2,8));
      Set(2,2,Get(5,6));
      Set(2,5,Get(5,3));
      Set(2,8,Get(5,0));
      Set(5,0,Get(1,2));
      Set(5,3,Get(1,5));
      Set(5,6,Get(1,8));
      Set(1,2,temp1);
      Set(1,5,temp2);
      Set(1,8,temp3);
    }
    else {
      Set(0,2,Get(1,2));
      Set(0,5,Get(1,5));
      Set(0,8,Get(1,8));
      Set(1,2,Get(5,0));
      Set(1,5,Get(5,3));
      Set(1,8,Get(5,6));
      Set(5,0,Get(2,8));
      Set(5,3,Get(2,5));
      Set(5,6,Get(2,2));
      Set(2,2,temp1);
      Set(2,5,temp2);
      Set(2,8,temp3);
    }
  }
    
  /** Rotates the left side of the cube clockwise */
  public void L() { L(true); }
  /** Rotates the left side of the cube 
   * @param cw Clockwise if true, counter-clockwise if false
   */
  public void L(boolean cw) {
    rotate(2,0);
    R(cw);
    rotate(2,0);
  }  
  
  /** Rotates the upper side of the cube clockwise */
  public void U() { U(true); }
  /** Rotates the upper side of the cube 
   * @param cw Clockwise if true, counter-clockwise if false
   */
  public void U(boolean cw) {
    rotate(0,1);
    rotate(1,0);
    R(cw);
    rotate(1,1);
    rotate(2,0);
  }  
  
  /** Rotates the down side of the cube clockwise */
  public void D() { D(true); }
  /** Rotates the down side of the cube 
   * @param cw Clockwise if true, counter-clockwise if false
   */
  public void D(boolean cw) {
    rotate(0,3);
    rotate(1,0);
    R(cw);
    rotate(3,1);
  }
  
  /** Rotates the front side of the cube clockwise */
  public void F() { F(true); }
  /** Rotates the front side of the cube 
   * @param cw Clockwise if true, counter-clockwise if false
   */
  public void F(boolean cw) {
    rotate(1,0);
    R(cw);
    rotate(3,0);
  }  
  
  /** Rotates the back side of the cube clockwise */
  public void B() { B(true); }
  /** Rotates the back side of the cube 
   * @param cw Clockwise if true, counter-clockwise if false
   */
  public void B(boolean cw) {
    rotate(3,0);
    R(cw);
    rotate(1,0);
  }
 
  private void rotate(int x, int y) {
    while (x > 0) {
      Face temp = cube.get(0);
      cube.set(0,cube.get(3));
      cube.set(3,cube.get(5));
      cube.set(5,cube.get(4));
      cube.set(4,temp);
    }
    while (y > 0) {
      Face temp = cube.get(0);
      cube.set(0,cube.get(1));
      cube.set(1,cube.get(5));
      cube.set(5,cube.get(2));
      cube.set(2,temp);
      cube.get(5).Turn();
      cube.get(5).Turn();
      cube.get(1).Turn();
      cube.get(1).Turn();
      cube.get(3).Turn();
      cube.get(4).Turn(false);
    }
  }
 
  private ArrayList<Face> cube;
}
