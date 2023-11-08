public class MagicSquare {
    public static void main(String[] args) {
        System.out.println("Enter the number of rows/columns: ");
        int n = In.getInt();
        int[][] square = new int[n][n];

        System.out.println("Enter the values for the square:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Enter value for row " + (i + 1) + " and column " + (j + 1) + ": ");
                square[i][j] = In.getInt();
            }
        }

        if (isMagic(square)) {
            System.out.println("\nIt is a magic square");
            int sum = getMagicSquareSum(square);
            System.out.println("The sum is " + sum + "\n");
        } else {
            System.out.println("\nIt is not a magic square\n");
        }
    }

    public static boolean isMagic(int[][] square) {
        int n = square.length;
        int expectedSum = n * (n * n + 1) / 2;

        // check the sum of each row
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += square[i][j];
            }
            if (rowSum != expectedSum) {
                return false;
            }
        }

        // check the sum of each column
        for (int j = 0; j < n; j++) {
            int colSum = 0;
            for (int i = 0; i < n; i++) {
                colSum += square[i][j];
            }
            if (colSum != expectedSum) {
                return false;
            }
        }

        // check the sum of the main diagonal
        int diagonalSum = 0;
        for (int i = 0; i < n; i++) {
            diagonalSum += square[i][i];
        }
        if (diagonalSum != expectedSum) {
            return false;
        }

        // check the sum of the secondary diagonal
        int secondaryDiagonalSum = 0;
        for (int i = 0; i < n; i++) {
            secondaryDiagonalSum += square[i][n - 1 - i];
        }
        if (secondaryDiagonalSum != expectedSum) {
            return false;
        }

        // if all checks pass, it is a magic square
        return true;
    }

    public static int getMagicSquareSum(int[][] square) {
        int n = square.length;
        return n * (n * n + 1) / 2;
    }
}