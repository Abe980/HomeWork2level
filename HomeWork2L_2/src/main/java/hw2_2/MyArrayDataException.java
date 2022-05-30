package hw2_2;

public class MyArrayDataException extends Exception {

    public MyArrayDataException() {
        super();
    }

    public MyArrayDataException(String s) {
        super(s);
    }


    public MyArrayDataException(String msg, Throwable cause, int i, int j, String errEl) {
        super(msg, cause);
        System.out.println("Нельзя преобразовать элемент массива ["+i+"]["+j+"] равный "+errEl+" в число");
    }



}
