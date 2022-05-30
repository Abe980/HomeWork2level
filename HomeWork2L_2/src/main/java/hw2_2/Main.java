package hw2_2;

public class Main {

    public static void main(String[] args) {

        String[][] arr = new String[4][4];

        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                arr[i][j]=i+""+j;
            }
        }

        String[][] arrR = new String[4][];
        arrR[0]= new String[] {"12", "3", "5", "23"};
        arrR[1]= new String[] {"12", "3", "5"};
        arrR[2]= new String[] {"12", "3", "5", "23"};
        arrR[3]= new String[] {"12", "3", "5", "23"};

        String[][] arrT = new String[4][];
        arrT[0]= new String[] {"12", "3", "5", "23"};
        arrT[1]= new String[] {"12", "3", "hhh", "23"};
        arrT[2]= new String[] {"12", "3", "5", "23"};
        arrT[3]= new String[] {"12", "3", "5", "23"};

        ArrTwodimensional arrTwodimensional = new ArrTwodimensional();

        try {
            arrTwodimensional.sumArr(arrT);
        } catch (MyArrayDataException e) {
            e.printStackTrace();

        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }

    }
}
