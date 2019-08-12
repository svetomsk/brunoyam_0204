package multithreading;

public class Task implements Runnable {
    private int [][] result;
    private int [][] a;
    private int [][] b;
    private int row;
    private int column;

    public Task(int[][] result, int[][] a, int[][] b, int row, int column) {
        this.result = result;
        this.a = a;
        this.b = b;
        this.row = row;
        this.column = column;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int k = 0; k < a.length; k++) { // multiply row by column
            sum += a[row][k] * b[k][column];
        }
        result[row][column] = sum;
    }
}