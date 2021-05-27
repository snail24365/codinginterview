package myutil;

public class Util {
  public static void printIntArr(int[][] m) {
    for (int[] xs : m) {
      for (int x :xs){
        System.out.print(x);
      }
      System.out.println("");
    }
  }
}
