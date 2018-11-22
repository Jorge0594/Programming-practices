import StrassenMatrix.StrassenMultiplication;
class Main {
    public static void main(String[] args) {

        int size = 4;
        int[][] x = new int[size][size];
        int[][] y = new int[size][size];

        int num = 1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                x[i][j] = num;
                y[i][j] = num;
                if(num == 9){
                    num = 0;
                }
                num++;
            }
        }



        StrassenMultiplication mult = new StrassenMultiplication();

        int[][] result = mult.multMatrixRec(x, y, size);

        mult.printMatrix(result);
    }
}
