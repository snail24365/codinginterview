public class P_1_7 {
  public static void main(String[] args) {
    int[][] ret = rotateMatrixInplace(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    print(ret);
  }

  static void print(int[][] m) {
    for (int[] xs : m) {
      for (int x :xs){
        System.out.print(x);
      }
      System.out.println("");
    }
  }

  static int[][] rotateMatrix1(int[][] m) {
    int n = m.length;
    int[][] ret = new int[n][n];
    for(int i = 0; i < n; i++) {
      for(int j = n-1; j >= 0; j--) {
        ret[i][n-j-1] = m[j][i];
      }
    }
    return ret;
  }
  static int[][] rotateMatrixInplace(int[][] m) {
    final int N = m.length - 1;
    for(int r = 0; r <= N / 2; r++){
      int n = N - 2 * r;
      for(int c = r; c < r + n; c++) {
        int temp = m[r][c]; 
        m[r][c] = m[N-c][r];
        m[N-c][r] = m[N-r][N-c];
        m[N-r][N-c] = m[c][N-r];
        m[c][N-r] = temp;
      }
    }
    return m;
  }
}
