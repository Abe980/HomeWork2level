package hw2_2;

public class MyArraySizeException extends Exception {

    public MyArraySizeException() {
        super();
    }

    public MyArraySizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyArraySizeException(String message, int i, int j) {
        super(message);
        System.out.println("Размерность массива не ["+i+"]["+j+"]");
    }

    public MyArraySizeException(Throwable cause) {
        super(cause);
    }


}
