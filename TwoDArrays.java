import java.util.Scanner;

public class TwoDArrays {

    public static void showMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] getMatrix(){
        Scanner sc = new Scanner(System.in);

        int matrix[][] = new int[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println("Enter (" + i + "," + j + ") element : ");
                matrix[i][j] = sc.nextInt();
            }
        }

        sc.close();
        return matrix;
    }
    
    public static void printSpiral(int [][] matrix){

        int hStart = 0;
        int hEnd = matrix[0].length - 1;
        int vStart = 0;
        int vEnd = matrix.length - 1;

       while (hStart <= hEnd && vStart <= vEnd) {

        for (int i = hStart; i <= hEnd; i++) {
            System.out.print(matrix[vStart][i] + " ");
        }

        for (int i = vStart+1; i <= vEnd; i++) {
            System.out.print(matrix[i][hEnd] + " ");
        }

        for (int i = hEnd-1; i >= hStart; i--) {
            if (hStart == hEnd) {
                break;
            }
            System.out.print(matrix[vEnd][i] + " ");
        }

        for (int i = vEnd-1; i > vStart; i--) {
            if (vStart == vEnd) {
                break;
            }
            System.out.print(matrix[i][hStart] + " ");
        }
        // break;
        hStart++;
        vStart++;
        hEnd--;
        vEnd--;
        
       }

    }

    public static int diagonalSum(int[][] matrix){
        // 2 Conditions for Diagonal Sum
        // i == j 
        // i+j == matrix.length-1

        int diagonalSum = 0;

        for (int i = 0; i < matrix.length; i++) {
            diagonalSum += matrix[i][i];    
        }
        int itr = matrix.length-1;
        for (int i = 0; i < matrix.length; i++) {
            if (i == itr) {
                itr--;
                continue;
            }
            diagonalSum += matrix[i][itr];
            itr--;
        }

        return diagonalSum;

    }

    public static boolean SearchInSorted(int[][] matrix , int key){

        int i = 0;
        int j = matrix[0].length-1;

        while (i < matrix.length && j >= 0) {
            if(matrix[i][j] == key){
                System.out.println(i);
                System.out.println(j);
                return true;
            }
            else if(key > matrix[i][j]){
                i++;
            }
            else{
                j--;
            }
        }

        return false;

    }

    public static int[][] findTranspose(int[][] matrix){
        int transpose[][] = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;

    }

    public static void main(String args[]){
        // 2D arrays === matrix
        // matrix.length gives length of matrix in vertical manner
        // matrix[0].length gives length of matrix in horizontal manner

        // int matrix[][] = getMatrix();
        // showMatrix(matrix);

        int mat[][] = {
            {10 , 20  ,30 , 40} , 
            {15 , 25 , 35 , 45} , 
            {27  ,29 , 37  ,48} , 
            {32  ,33 , 39 , 50}
        };

        // printSpiral(mat);
        // System.out.println(diagonalSum(mat));
        // System.out.println(SearchInSorted(mat , 27));
        int[][] transpose = findTranspose(mat);
        showMatrix(transpose);




    }
}
