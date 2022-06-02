package hw2_3;

public class Main {

    public static void main(String[] args) {

        TelDirectory h = new TelDirectory();

        h.add("Ivanov", "111111");
        h.add("Ivanov", "222222");
        h.add("Ivanov", "333333");
        h.add("Petrov", "122211");

        h.get("Ivanov");
        h.get("hnknk");
        h.get("Petrov");

    }
}
