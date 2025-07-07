/* code to explain anonymous class, lambda, method reference
*/

import java.util.*;
import java.util.function.Consumer;

class Person {
  String name;

  Person(String name) {
    this.name = name;
  }

  public void printName() {
    System.out.println(name);
  }
}

public class AnonymousClass {

  public static void main(String[] args) {
    List<Person> people = Arrays.asList(
        new Person("Asha"),
        new Person("Rahul"),
        new Person("Meera"));

    System.out.println("Before lambda, anonymous class:");
    people.forEach(new Consumer<Person>() {
      @Override
      public void accept(Person p) {
        p.printName();
      }
    });

    System.out.println();

    System.out.println("Using lambda:");
    people.forEach(p -> p.printName());

    System.out.println();

    System.out.println("Using method reference:");
    people.forEach(Person::printName);
  }
}