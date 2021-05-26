class P_1_4 {
  public static void main(String[] args) {
    System.out.println(isPermutePalindrome("abcdbca"));
    System.out.println(isPermutePalindrome("abcdba"));
    System.out.println(isPermutePalindrome("aabb"));
  }

  static boolean isPermutePalindrome(String str) {
    int bitVector = createBitVector(str);
    return bitVector == 0 || ((bitVector-1) & bitVector) == 0;
  }

  static int createBitVector(String str) {
    int bitVector = 0;
    for (char c : str.toCharArray()) {
      int index = (c >= 'a' && c <= 'z') ? c - 'a' : -1;
      if (index >= 0) {
        bitVector = toggle(bitVector, index);
      }
    }
    return bitVector;
  }

  static int toggle(int bitVector, int index) {
    if (index < 0) {
      return bitVector;
    }
    int marker = 1 << index;
    if ((bitVector & marker) > 0) {
      return bitVector & (~marker);
    }
    return bitVector | marker;
  }

}