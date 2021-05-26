public class P_1_5 {
  public static void main(String[] args) {
    System.out.println(isOneStep("pale", "ple"));
    System.out.println(isOneStep("pales", "pale"));
    System.out.println(isOneStep("pale", "bale"));
    System.out.println(isOneStep("pale", "bake"));
    System.out.println(isOneStep("bbake", "bakz"));
  } 
  
  static boolean isOneStep(String origin, String target){
    if (origin.length() < target.length()) {
      swap(origin, target);
    }

    int n1 = origin.length();
    int n2 = target.length();

    if(Math.abs(n1 - n2) > 1) {
      return false;
    }

    if(n2 == n1)  {
      int count = 0;
      for (int i = 0; i < n1; i++) {
        if(origin.charAt(i) != target.charAt(i)) {
          count += 1;
        }
      }
      return count <= 1;      
    }

    int i = 0;
    int j = 0;
    boolean used = false;
    while(i < n1 && j < n2) {
      if(origin.charAt(i) != target.charAt(j)) {
        if (used) {
          return false;
        }
        i++;
        used = true;
        continue;
      }
      i++;
      j++;
    }
    return true;
  }

  static void swap(String s1, String s2) {
    String temp = s2;
    s2 = s1;
    s1 = temp;
  }
}
