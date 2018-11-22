package StrassenMatrix;

public class StrassenMultiplication {
    private final int MAX = 10000;

    public StrassenMultiplication() {
    }

    public int[][] multMatrixRec(int[][] x, int[][] y, int size) {

        int[][] result = new int[size][size];

        if (size == 1) {
            result[0][0] = x[0][0] * y[0][0];

        } else {

            size = size / 2;

            int[][] a = new int[size][size];
            int[][] b = new int[size][size];
            int[][] c = new int[size][size];
            int[][] d = new int[size][size];
            int[][] e = new int[size][size];
            int[][] f = new int[size][size];
            int[][] g = new int[size][size];
            int[][] h = new int[size][size];

            fillMatrix(x, a, 0, 0);
            fillMatrix(x, b, 0, size);
            fillMatrix(x, c, size, 0);
            fillMatrix(x, d, size, size);

            fillMatrix(y, e, 0, 0);
            fillMatrix(y, f, 0, size);
            fillMatrix(y, g, size, 0);
            fillMatrix(y, h, size, size);

            int[][] p1 = multMatrixRec(a, subMatrix(f, h, size), size);
            int[][] p2 = multMatrixRec(addMatrix(a, b, size), h, size);
            int[][] p3 = multMatrixRec(addMatrix(c, d, size), e, size);
            int[][] p4 = multMatrixRec(d, subMatrix(g, e, size), size);
            int[][] p5 = multMatrixRec(addMatrix(a, d, size), addMatrix(e, h, size), size);
            int[][] p6 = multMatrixRec(subMatrix(b, d, size), addMatrix(g, h, size), size);
            int[][] p7 = multMatrixRec(subMatrix(a, c, size), addMatrix(e, f, size), size);

            insertInMatrix(result, addMatrix(subMatrix(addMatrix(p5, p4, size), p2, size), p6, size), 0, 0, size);
            insertInMatrix(result, addMatrix(p1, p2, size), 0, size, size);
            insertInMatrix(result, addMatrix(p3, p4, size), size, 0, size);
            insertInMatrix(result, subMatrix(subMatrix(addMatrix(p1, p5, size), p3, size), p7, size), size, size, size);

        }
        return result;
    }

    public void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void fillMatrix(int[][] m, int[][] aux, int row, int col) {
        for (int i1 = 0, i2 = row; i1 < aux.length; i1++, i2++) {
            for (int j1 = 0, j2 = col; j1 < aux.length; j1++, j2++) {
                aux[i1][j1] = m[i2][j2];
            }
        }
    }

    private void insertInMatrix(int[][] result, int[][] m, int row, int col, int size) {

        for (int i1 = 0, i2 = row; i1 < size; i1++, i2++) {
            for (int j1 = 0, j2 = col; j1 < size; j1++, j2++) {
                result[i2][j2] = m[i1][j1];
            }
        }
    }

    private int[][] addMatrix(int[][] x, int[][] y, int order) {
        int[][] result = new int[order][order];
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                result[i][j] = x[i][j] + y[i][j];
            }
        }
        return result;
    }

    private int[][] subMatrix(int[][] x, int[][] y, int order) {
        int[][] result = new int[order][order];
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                result[i][j] = x[i][j] - y[i][j];
            }
        }
        return result;
    }
}
