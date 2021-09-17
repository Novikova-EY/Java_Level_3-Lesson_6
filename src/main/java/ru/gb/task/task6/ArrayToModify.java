package ru.gb.task.task6;

import java.util.Arrays;

public class ArrayToModify {
    private static Integer[] arrayOld;

    public static void main(String[] args) {
        ArrayToModify arrayToModify = new ArrayToModify(arrayOld);
        arrayToModify.toDoArray(arrayOld);
    }

    public ArrayToModify(Integer[] arrayOld) {
        this.arrayOld = arrayOld;
    }

    public Integer[] toDoArray(Integer[] arrayOld) {
        if (checkNullArray(arrayOld) && checkSmallArray(arrayOld)) {

            Integer[] arrayNew = new Integer[arrayOld.length % 4];

            for (int i = 0; i < arrayNew.length; i++) {
                arrayNew[i] = arrayOld[arrayOld.length - arrayNew.length + i];
            }
            return arrayNew;
        }
        return null;
    }

    public boolean checkSmallArray(Integer[] arrayOld) {
        try {
            if (arrayOld.length / 4 == 0) {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            System.out.println("В массиве менее 4-х элементов");
        }
        return true;
    }

    public boolean checkNullArray(Integer[] arrayOld) {
        if (Arrays.hashCode(arrayOld) == 0) {
            System.out.println("Массив пустой");
            return false;
        }
        return true;
    }

    public boolean toCheckArray(Integer[] arrayOld) {
        if (checkNullArray(arrayOld) && checkSmallArray(arrayOld)) {
            int count1 = 0;
            int count4 = 0;
            for (int i = 0; i < arrayOld.length; i++) {
                if (arrayOld[i] != 1) {
                    count1++;
                }
                if (arrayOld[i] != 4) {
                    count4++;
                }
            }
            if ((count1 + count4 != arrayOld.length) || ((count1 == arrayOld.length) || (count4 == arrayOld.length))) {
                return false;
            }
        }
        return true;
    }
}
