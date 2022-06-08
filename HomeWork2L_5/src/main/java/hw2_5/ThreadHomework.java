package hw2_5;

public class ThreadHomework {

    public static void main(String[] args) throws InterruptedException {
        ThreadHomework th = new ThreadHomework();

        try {
            th.firstMethod();
            th.secondMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void firstMethod() {
        int size = 10_000_000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (Math.sin(0.2f + i / 5) * arr[i] * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public void secondMethod() throws InterruptedException {
        int size = 10_000_000;
        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }

        float[] half1 = new float[size / 2];
        float[] half2 = new float[size - size / 2];

        long startTime = System.currentTimeMillis();

        System.arraycopy(arr, 0, half1, 0, size / 2);
        System.arraycopy(arr, size / 2, half2, 0, size - size / 2);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < half1.length; i++) {
                half1[i] = (float) (Math.sin(0.2f + i / 5) * half1[i] * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0, j = size / 2; i < half2.length; i++, j++) {
                half2[i] = (float) (Math.sin(0.2f + j / 5) * half2[i] * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        float[] arr1 = new float[size];
        System.arraycopy(half1, 0, arr, 0, size / 2);
        System.arraycopy(half2, 0, arr, size / 2, size - size / 2);

        System.out.println("Two thread time: " + (System.currentTimeMillis() -
                startTime) + " ms.");
    }
}
