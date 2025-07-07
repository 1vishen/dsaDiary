
public class RuntimePoly {
  public static void main(String[] args) {

    Displayable d;
    d = new A();
    d.disp();
    d = new B();
    d.disp();
    d = new C();
    d.disp();

  }
}

interface Displayable {
  void disp();
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