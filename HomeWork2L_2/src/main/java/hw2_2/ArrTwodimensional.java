package hw2_2;

public class ArrTwodimensional {

    private int arrI=4;
    private int arrJ=4;

    public int getArrI() {
        return arrI;
    }

    public void setArrI(int arrI) {
        this.arrI = arrI;
    }

    public int getArrJ() {
        return arrJ;
    }

    public void setArrJ(int arrJ) {
        this.arrJ = arrJ;
    }

    public void sumArr(String[][] arr1) throws MyArrayDataException, MyArraySizeException {
        int x=0;
        for (int i=0; i<arrI; i++) {
            if (arr1[i].length==arrI) {
                x++;
            }
        }

        if (arr1.length!=arrI || x!=arrJ) {
            throw new MyArraySizeException("Размерность массива не ["+arrI+"]["+arrJ+"]", arrI, arrJ);
        }

        int sum=0;

        for (int i=0; i<arrI; i++) {
            for (int j=0; j<arrJ; j++) {
                try {
                    sum +=Integer.parseInt(arr1[i][j]);

                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Нельзя преобразовать элемент массива ["+i+"]["+j+"] равный "+arr1[i][j]+" в число", e, i, j, arr1[i][j]);
                }			}
        }

        System.out.println("Сумма элементов массива: "+sum);

    }
}
