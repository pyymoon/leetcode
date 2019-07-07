package com.leetcode.medium;

public class UpdateMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix.length == 0){
            return null;
        }

        int cols = matrix.length;
        int rows = matrix[0].length;
        for(int i=0;i<cols;i++){
            for(int j=0;j<rows;j++){
                if(matrix[i][j]==1){
                    matrix[i][j] = rows + cols;
                }
                if(i>0){
                    int up = matrix[i-1][j]+1;
                    int temp = matrix[i][j];
                    matrix[i][j]= temp>up?up:temp;
                }
                if(j>0){
                    int left = matrix[i][j-1]+1;
                    int temp = matrix[i][j];
                    matrix[i][j]= temp>left?left:temp;
                }
            }
        }

        for(int col=cols-1;col>=0;col--){
            for(int row=rows-1;row>=0;row--){
                if(col<cols-1){
                    int down = matrix[col+1][row]+1;
                    int temp = matrix[col][row];
                    matrix[col][row]= temp>down?down:temp;
                }
                if(row<rows-1){
                    int right = matrix[col][row+1]+1;
                    int temp = matrix[col][row];
                    matrix[col][row]= temp>right?right:temp;
                }

            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{0,1,0}};
        UpdateMatrix um = new UpdateMatrix();
        int[][] result = um.updateMatrix(mat);
    }
}
