public class FaceTester {
  public static void main(String[] args) {
    try {
      Face F = new Face(1);
      System.out.println(F.toString());
    } 
    catch (FaceException FE) {
      System.out.println(FE.getMessage());
    }

    try {
      Face f = new Face(-1);
      System.out.println(f.toString());
    } 
    catch (FaceException fe) {
      System.out.println(fe.getMessage());
    }
  }
}
