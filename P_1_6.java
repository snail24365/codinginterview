public class P_1_6 {
  public static void main(String[] args) {
    System.out.println(compress("aabccccaaa"));
  }

  static String compress(String origin) {
    int finalLength = countCompression(origin);
    if (finalLength >= origin.length())return origin;

    int count = 0;
    StringBuffer sb = new StringBuffer();
    for(int i = 0; i < origin.length(); i++) {
      count++;
      char chr = origin.charAt(i);
      if (i == origin.length() - 1 || chr != origin.charAt(i+1)) {
        sb.append(chr);
        if (count > 1) {
         sb.append(count);
        }
        count = 0;
      }
    }
    String compressed = sb.toString();
    return compressed.length() > origin.length() ? origin : compressed; 
  }

  static int countCompression(String origin) {
    int ret = 0;
    int count = 0;
    for(int i = 0; i < origin.length(); i++) {
      count++;
      if (i == origin.length() - 1 || origin.charAt(i) != origin.charAt(i+1)) {
        int digit_len =  String.valueOf(count).length();
        ret += count == 1 ? 1 : digit_len + 1;
        count = 0;
      }
    }
    return ret;
  }
}
