import java.util.Arrays;

class P_1_2 {
  public static void main(String[] args) {
    System.out.println(isPermutation("dog", "god"));
    System.out.println(isPermutation2("dog", "god"));
  } 
  
  static boolean isPermutation(String str1, String str2) {
    char[] arr1 =  str1.toCharArray();
    Arrays.sort(arr1);
    
    char[] arr2 =  str2.toCharArray();
    Arrays.sort(arr2);
    return new String(arr1).equals(new String(arr2));
  }

  static boolean isPermutation2(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }

    int[] count_arr = new int[128];

    for (char ch : str1.toCharArray()) {
      count_arr[ch - 'a'] += 1;
    }

    for (char ch : str2.toCharArray()) {
      count_arr[ch - 'a'] -= 1;
      if (count_arr[ch - 'a'] < 0) {
        return false;
      }
    }
    return true;
  }
}