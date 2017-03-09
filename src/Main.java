public class Main {

    /*
    Doubling test. Write a client that performs a doubling test for sort algorithms.
    Start at N equal to 1000, and print N, the predicted number of seconds, the actual number of seconds,
    and the ratio as N doubles. Use your program to validate that insertion sort and selection sort are quadratic for random inputs,
    and formulate and test a hypothesis for merge sort.
     */

    public static void main(String[] args) {
	    insertionTester(1000);
        insertionTester(2000);
        insertionTester(4000);
        insertionTester(8000);
        insertionTester(16000);

        preTime = 0;

        selectionTester(1000);
        selectionTester(2000);
        selectionTester(4000);
        selectionTester(8000);
        selectionTester(16000);

        preTime = 0;

        mergeTester(1000);
        mergeTester(2000);
        mergeTester(4000);
        mergeTester(8000);
        mergeTester(16000);
        mergeTester(32000);
        mergeTester(64000);
    }

    private static void insertionTester(int n){
        double time = 0;
        int runs = 500;
        for (int i = 0; i < runs; i++) {
            Comparable[] arr = ar(n);

            double start = System.currentTimeMillis();
            SortClass.insertionSort(arr);
            double stop = System.currentTimeMillis();

            time += stop-start;
        }
        time /= runs;
        System.out.println("Main.insertionTester");
        System.out.println("n = [" + n + "]");
        System.out.println("Expected Time = " + preTime*4);
        System.out.println("time taken = " + time);
        System.out.println("ratio = " + time/preTime);
        System.out.println();
        preTime = time;
    }

    private static void selectionTester(int n){
        double time = 0;
        int runs = 500;
        for (int i = 0; i < runs; i++) {
            Comparable[] arr = ar(n);

            double start = System.currentTimeMillis();
            SortClass.selectionSort(arr);
            double stop = System.currentTimeMillis();

            time += stop-start;
        }
        time /= runs;
        System.out.println("Main.selectionTester");
        System.out.println("n = [" + n + "]");
        System.out.println("Expected Time = " + preTime*4);
        System.out.println("time taken = " + time);
        System.out.println("ratio = " + time/preTime);
        System.out.println();
        preTime = time;
    }

    private static void mergeTester(int n){
        double time = 0;
        int runs = 1000;
        for (int i = 0; i < runs; i++) {
            Comparable[] arr = ar(n);

            double start = System.currentTimeMillis();
            SortClass.mergeSort(arr);
            double stop = System.currentTimeMillis();

            time += stop-start;
        }
        time /= runs;
        System.out.println("Main.mergeTester");
        System.out.println("n = [" + n + "]");
        System.out.println("Expected Time = " + preTime*2);
        System.out.println("time taken = " + time);
        System.out.println("ratio = " + time/preTime);
        System.out.println();
        preTime = time;
    }

    static Comparable[] arr;
    static double preTime = 0;

    private static Comparable[] ar(int n){
        arr = new Comparable[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Math.random()*1000;
        }
        return arr;
    }
}
