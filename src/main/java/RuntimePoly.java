
public class RuntimePoly {
  public static void main(String[] args) {

    Displayable d;
    d = new A();
    d.disp();
    d = new B();
    d.disp();
    d = new C();
    d.disp();

    System.out.println("2nd implementation:");
    DisplayClass dc = new DisplayClass();
    dc.dispFromDisplayClass(new A());
    dc.dispFromDisplayClass(new B());
    dc.dispFromDisplayClass(new C());
    /*
     * The first implementation manually switches references, while the second uses
     * a helper class for cleaner delegation—both achieve runtime polymorphism. The
     * second is more organized and extensible.
     */

  }
}

interface Displayable {
  void disp();
}

// 2nd implementation
class DisplayClass {
  public Displayable d;

  public void dispFromDisplayClass(Displayable d) {
    d.disp();
  }
}

class A implements Displayable {
  public void disp() {
    System.out.println("Hello from A");
  }
}

class B implements Displayable {
  public void disp() {
    System.out.println("Hello from B");
  }
}

class C implements Displayable {
  public void disp() {
    System.out.println("Hello from C");
  }
}