package hw2_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class UniqueWordsNumber {

    public static void main (String[] args) {

        String[] treeArr =  {"Ель", "Сосна", "Береза", "Дуб", "Сосна", "Береза", "Ясень", "Сосна", "Тополь", "Ясень", "Осина"};

        for (String s : treeArr) {
            System.out.print(s+" ");
        }
        System.out.println();

        HashSet<String> treeUnique = new HashSet<>(List.of(treeArr));

        System.out.println(treeUnique);

        HashMap<String, Integer> uwn = new HashMap<>();

        for (String str : treeArr) {
            if (uwn.containsKey(str)) {
                uwn.put(str, uwn.get(str)+1);
            } else {
                uwn.put(str, 1);
            }
        }

        System.out.println(uwn);
    }


}
