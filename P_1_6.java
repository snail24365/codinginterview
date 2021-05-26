public class P_1_6 {
  public static void main(String[] args) {
    System.out.println(compress("aabccccaaa"));
  }

  static String compress(String origin) {
    
    char[] chars = origin.toCharArray();
    char prev = chars[0];
    int count = 0;
    StringBuffer sb = new StringBuffer();
    for (char c : chars) {
      if (c == prev) {
        count += 1;
      }
      else {
        String chunk = count == 1 ? String.valueOf(prev) : (String.valueOf(prev) + count);
        sb.append(chunk);
        prev = c;
        count = 1;
      }
    }
    String chunk = count == 1 ? String.valueOf(prev) : (String.valueOf(prev) + count);
    sb.append(chunk);
    String compressed = sb.toString();

    return compressed.length() > origin.length() ? origin : compressed; 
  }
}
