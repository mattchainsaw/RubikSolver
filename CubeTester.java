public class CubeTester {
  
  public static String s;

  public static void Log(String S) {
    s += S + " method is wrong\n";
  }

  public static void main(String[] args) {
   s = ""; 
   Cube c = new Cube();
   System.out.println("solved");
   System.out.println(c.toString());

   Cube Solved = new Cube();
   if (!c.equals(Solved))
     Log("Constructor");
      
   c.R();
   System.out.println("Right");
   System.out.println(c.toString());
   
   c.R(false);
   System.out.println("Right inverted");
   System.out.println(c.toString());
   
   if (!c.equals(Solved))
     Log("Right");
   
   c.L();
   System.out.println("Left");
   System.out.println(c.toString());
   
   c.L(false);
   System.out.println("Left inverted");
   System.out.println(c.toString());
   
   if (!c.equals(Solved))
     Log("Left");

   c.U(false);
   System.out.println("Up inverted");
   System.out.println(c.toString());
   
   if (c.equals(Solved))
     Log("Up");
   
   c.U(true);
   System.out.println("Up");
   System.out.println(c.toString());
   
   if (!c.equals(Solved))
     Log("Up");

   c.D();
   System.out.println("Down");
   System.out.println(c.toString());
   
   c.D(false);
   System.out.println("Down inverted");
   System.out.println(c.toString());
   
   if (!c.equals(Solved))
     Log("Down");

   c.F();
   System.out.println("Front");
   System.out.println(c.toString());
   
   c.F(false);
   System.out.println("Front inverted");
   System.out.println(c.toString());
   
   if (!c.equals(Solved))
     Log("Front");

   c.B();
   System.out.println("Back");
   System.out.println(c.toString());
   
   c.B(false);
   System.out.println("Back inverted");
   System.out.println(c.toString());

   
   if (!c.equals(Solved))
     Log("Back");
   
   System.out.println(s);

   c.move(1);
   System.out.println(c.toString());
   System.out.println(c.solve());
   System.out.println(c.toString());

  }
}

