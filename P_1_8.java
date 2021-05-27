import myutil.Util;

public class P_1_8 {
  public static void main(String[] args) {
    int[][] test = {{1,1,1,1}, {1,0,1,1}, {1,1,1,0}};
    setZeros2(test);
    Util.printIntArr(test);
  }

  static void setZeros(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    boolean[] rowFlag = new boolean[m];
    boolean[] colFlag = new boolean[n];
    
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          rowFlag[i] = true;
          colFlag[j] = true;
        }
      }
    }

    for (int i = 0 ; i < rowFlag.length; i++) {
      if (rowFlag[i]) {
        for(int j = 0; j < n; j++) {
          matrix[i][j] = 0;
        }
      }
    }
    
    for (int i = 0 ; i < colFlag.length; i++) {
      if (colFlag[i]) {
        for(int j = 0; j < m; j++) {
          matrix[j][i] = 0;
        }
      }
    }
  }
  
  static void setZeros2(int[][] matrix) {
    boolean isFirstColZero = false;
    boolean isFirstRowZero = false;
    for(int i = 0; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        isFirstColZero = true;
      }
    }
    for(int i = 0; i < matrix[0].length; i++) {
      if (matrix[0][i] == 0) {
        isFirstRowZero = true;
      }
    }
    for(int i = 1; i < matrix.length; i++) {
      for(int j = 1; j <matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        } 
      }
    }

    for(int i = 0; i < matrix.length; i++) {
      if(matrix[i][0] == 0) {
        nullifyRow(matrix, i);
      }
    }
    for(int i = 0; i < matrix[0].length; i++) {
      if(matrix[0][i] == 0) {
        nullifyCol(matrix, i);
      }
    }
    if(isFirstColZero) {
      nullifyCol(matrix, 0);
    }
    if(isFirstRowZero) {
      nullifyRow(matrix, 0);
    }
  }

  static void nullifyCol(int[][] matrix, int index) {
    for(int i = 0; i < matrix.length; i++) {
      matrix[i][index] = 0;
    }
  }

  static void nullifyRow(int[][] matrix, int index) {
    for(int i = 0; i < matrix[0].length; i++) {
      matrix[index][i] = 0;
    }
  }
}
