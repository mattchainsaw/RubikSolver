import java.util.ArrayList;

/** 
 * Face Class.
 * @author Matthew Meyer
 */

public class Face {
  /**
   * Constructor for the Face class.
   * @param aFace Integer number denoting what side this face represents.
   */
  /* Face's blocks
   * 0 1 2
   * 3 4 5
   * 6 7 8
   * aFace
   * 0 Front Face
   * 1 Top Face
   * 2 Bottom Face
   * 3 Left Face
   * 4 Right Face
   * 5 Back Face
   */
  public Face(int aFace) {
    blocks = new ArrayList<Integer>();
    for (int i=0; i<9; i++) {
      blocks.add(aFace);
    }
  }

  /**
   * gets the value of a position of the Face.
   * @param pos Position of blocks
   * @return Returns the value at the specified position
   */
  public int get(int pos) { return blocks.get(pos); }

  /**
   * sets a position of the face to a value.
   * @param pos Position of the Face
   * @param val Value that the position will be set to.
   */
  public void set(int pos, int val) { blocks.set(pos,val); }

  /**
   * Turns the Face of the cube clockwise.
   */
  public void Turn() { Turn(true); }

  /**
   * Turns the Face of the cube clockwise or counter-clockwise.
   * @param clockwise True if clockwise, false if counter-clockwise.
   */
  public void Turn(boolean clockwise) {
    if (clockwise) {
      // corners
      int temp = blocks.get(0);
      blocks.set(0,blocks.get(6));
      blocks.set(6,blocks.get(8));
      blocks.set(8,blocks.get(2));
      blocks.set(2,temp);
      // edges
      temp = blocks.get(1);
      blocks.set(1,blocks.get(3));
      blocks.set(3,blocks.get(7));
      blocks.set(7,blocks.get(5));
      blocks.set(5,temp);
    }
    else {
      // corners
      int temp = blocks.get(0);
      blocks.set(0,blocks.get(2));
      blocks.set(2,blocks.get(8));
      blocks.set(8,blocks.get(6));
      blocks.set(6,temp);
      // edges
      temp = blocks.get(1);
      blocks.set(1,blocks.get(5));
      blocks.set(5,blocks.get(7));
      blocks.set(7,blocks.get(3));
      blocks.set(3,temp);
    }
  }

  private ArrayList<Integer> blocks;
}
