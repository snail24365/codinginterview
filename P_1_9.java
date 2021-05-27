public class P_1_9 {
  public static void main(String[] args) {
    
  }

  static boolean isRotation(String s1, String s2) {
    int len = s1.length();
    if(len == s2.length() && len > 0) {
      String xyxy = s2 + s2;
      return xyxy.contains(s1);
    }
    return false;
  }
}
