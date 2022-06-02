package hw2_3;

import java.util.HashMap;
import java.util.Map;

public class TelDirectory {

    private HashMap<String, String> hm = new HashMap<>();

    public void add(String f, String t) {
        hm.put(t, f);

    }

    public void get(String k) {

        int n=0;
        System.out.println(k+":");
        for (Map.Entry<String, String> value : hm.entrySet()) {

            if (k.equals(value.getValue())) {
                System.out.println(value.getKey());
                n++;
            }


        }

        if (n==0) {
            System.out.println("Телефонов не найдено");
        }

    }
}
