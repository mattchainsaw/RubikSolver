public class Solutions {
  
  public static void main(String[] args) {
    Cube c = new Cube();
    make(c,0,'0');
    System.out.println(z);
  }

  public static int z = 0;

  public static void make(Cube c, int x, char ch) {
    if (x == 8) return;
//    System.out.println(x);
//    System.out.println(c.toString());
    ++z;
    c.R();
    if (ch != 'r') make(c,x+1, 'R'); // Right
    c.R(false);
    c.R(false); 
    if (ch != 'R') make(c,x+1,'r'); // Right Inverted
    c.R();
    c.L();
    if (ch != 'l') make(c,x+1,'L'); // Left
    c.L(false);
    c.L(false);
    if (ch != 'L') make(c,x+1,'l'); // Left Inverted
    c.L();
    c.U();
    if (ch != 'u') make(c,x+1,'U'); // Up
    c.U(false);
    c.U(false);
    if (ch != 'U') make(c,x+1,'u'); // Up Inverted
    c.U();
    c.D();
    if (ch != 'd') make(c,x+1,'D'); // Down
    c.D(false);
    c.D(false);
    if (ch != 'D') make(c,x+1,'d'); // Down Inverted
    c.D();
    c.F();
    if (ch != 'f') make(c,x+1,'F'); // Front
    c.F(false);
    c.F(false);
    if (ch != 'F') make(c,x+1,'f'); // Front Inverted
    c.F();
    c.B();
    if (ch != 'b') make(c,x+1,'B'); // Back
    c.B(false);
    c.B(false);
    if (ch != 'B') make(c,x+1,'b'); // Back Inverted
  }
}
