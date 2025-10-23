@FunctionalInterface
interface MyFunctional<T> {
  T apply(T a, T b);
}


public class RemoveDuplicate {
  public static void main(String[] args) {
    Integer result = ((MyFunctional<Integer>) (a, b) -> a + b).apply(10, 20);

  }

  public static void myFunc(MyFunctional myFunctional) {
    System.out.println(myFunctional.apply(1, 2));
  }
}