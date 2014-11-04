public class FaceTester {
  public static void main(String[] args) {
    try {
      Face F = new Face(1);
    } 
    catch (FaceException FE) {
      System.out.println(FE.message());
    }

    try {
      Face f = new Face(-1);
    } 
    catch (FaceException fe) {
      System.out.println(fe.message());
    }
  }
}
