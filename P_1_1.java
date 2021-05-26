import java.util.Arrays;

class P_1_1 {
  public static void main(String[] args) {
    String testSet1 = "abcdef";
    assert isUniqueChars(testSet1);
    assert isUniqueChars2(testSet1);
    assert isUniqueChars3(testSet1);
    assert isUniqueChars4(testSet1);

    String testSet2 = "abcdaf";
    assert !isUniqueChars(testSet2);
    assert !isUniqueChars2(testSet2);
    assert !isUniqueChars3(testSet2);
    assert !isUniqueChars4(testSet2);
    
    System.out.println("Passed!");
  }

  // 배열자료구조 사용하여 O(n)으로 검사
  static boolean isUniqueChars(String str) {
    if (str.length() > 128)  return false;
    boolean[] char_set = new boolean[128];
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i);
      if(char_set[val]) {
        return false;
      }
      char_set[val] = true;
    }
    return true;
  }

  // bit vector를 사용하여 필요공간을 1/8로 줄임
  // a~z까지 있다고 가정했을시 checker 문자열 26개는 32bit안에 있으므로 32bit만 사용하여 커버가능.
  static boolean isUniqueChars2(String str) {
    int checker = 0;
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i) - 'a';
      if ((checker & (1 << val)) > 0) {
        return false;
      }
      checker |= (1 << val);
    }
    return true;
  }

  // Sorting알고리즘에 따라 공간복잡도는 달라짐. 시간복잡도 O(n log n)
  static boolean isUniqueChars3(String str) {
    char[] sorted = str.toCharArray();
    Arrays.sort(sorted);

    if (str.length() < 1) return true;

    // str 길이 1 이상임을 가정.
    char prev = sorted[0];
    for(int i = 1; i < sorted.length; i++) {
      if (prev == sorted[i]) {
        return false;
      }
      prev = sorted[i];
    }
    return true;
  }

  // 시간복잡도 O(n^2) 공간복잡도 O(1)
  static boolean isUniqueChars4(String str) {
    for (int i = 0; i < str.length(); i++) {
      for (int j = i+1; j < str.length(); j++) {
        if (str.charAt(i) == str.charAt(j))
          return false;
      }
    }
    return true;
  }
}