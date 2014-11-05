/** A Face is one side of the Rubik's Cube.
 *  This class is used to describe the cube in the display and solving process. This class will
 *  only be used for behind the scenes work with our Rubik's Cube Solver. 
 *  @author Matthew Meyer
 *  */
public class Face {
  /** Constructor for Face Class.
   *  This constructor will be called in making the cube. As there are only six faces on a cube, 
   *  our number of Face objects will be six. We will only have a single constructor as the 
   *  user will never need to worry about calling it. 
   *  @param n This will be the Face number in the center of the matrix. It will never be 
   *  changed to any other number.
   *  */
  public Face(int n) throws FaceException {
    facets = new int[3][3];
    if (n < 0 || n > 5) throw new FaceException("BAD! BAD! BAD! BAD!!!!");
    else {
      facets[1][1] = n;
      Clear();
    }
  }

  ///// Accessors /////
  
  public String toString() {
    String out = "";
    for (int i=0; i<3; i++) {
      for (int j=0; j<3; j++) {
        out += facets[i][j]; 
      }
      if (i != 2) out += "\n";
    }
    return out;
  }            

  ///// Mutators /////

  /** Method to make the face "clean".
   *  This method is used in the constructor and will serve to clean the cube for user input.
   *  */
  public void Clear() {
    for (int i=0; i<3; i++) {
      for (int j=0; j<3; j++) {
        if (i != 1 || j != 1) {
          facets[i][j] = -1;
        }
      }
    }
  }

  ///// Private Utilities /////


  ///// Private Memebers /////

  private int[][] facets;
}
