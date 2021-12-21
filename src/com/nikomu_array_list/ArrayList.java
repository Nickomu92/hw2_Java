package com.nikomu_array_list;

import com.nikomu_enums.Color;

public class ArrayList {
    public static void main(String[] args) {
        System.out.printf("\n%sЗадание: \"Создать свой ArrayList(add, delete, get, insert, size)\";%s\n", Color.ANSI_RED.getCode(), Color.ANSI_RESET.getCode());

        // Создадим строковый массив-список
        NikoMuArrayList<String> myStringArrayList = new NikoMuArrayList<>();

        System.out.printf("\n%sРабота со строковым массивом-списком%s\n\n", Color.ANSI_GREEN.getCode(), Color.ANSI_RESET.getCode());

        System.out.println("Результат работы метода size():");
        System.out.printf("Размер массива: %s;\n\n", myStringArrayList.size());

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.printf("myStringArrayList: %s\n\n", myStringArrayList);

        System.out.println("Работа метода add(\"один\"):\n");
        myStringArrayList.add("один");

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.printf("myStringArrayList: %s\n\n", myStringArrayList);

        System.out.println("Результат работы метода size():");
        System.out.printf("Размер массива: %s\n\n", myStringArrayList.size());

        System.out.println("Работа метода add(\"два\"):\n");
        myStringArrayList.add("два");
        System.out.println("Работа метода add(\"три\"):\n");
        myStringArrayList.add("три");
        System.out.println("Работа метода add(\"четыре\"):\n");
        myStringArrayList.add("четыре");
        System.out.println("Работа метода add(\"пять\"):\n");
        myStringArrayList.add("пять");
        System.out.println("Работа метода add(\"шесть\"):\n");
        myStringArrayList.add("шесть");
        System.out.println("Работа метода add(\"семь\"):\n");
        myStringArrayList.add("семь");
        System.out.println("Работа метода add(\"восемь\"):\n");
        myStringArrayList.add("восемь");
        System.out.println("Работа метода add(\"девять\"):\n");
        myStringArrayList.add("девять");
        System.out.println("Работа метода add(\"десять\"):\n");
        myStringArrayList.add("десять");

        System.out.println("Результат работы метода size():");
        System.out.printf("Размер массива: %s\n\n", myStringArrayList.size());

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.println("myStringArrayList: " + myStringArrayList + "\n");

        System.out.println("Работа метода add(\"одиннадцать\") с увеличением размера массива на шаг 5:\n");
        myStringArrayList.add("одиннадцать");
        System.out.println("Работа метода add(\"двенадцать\")\n");
        myStringArrayList.add("двенадцать");
        System.out.println("Работа метода add(\"тринадцать\")\n");
        myStringArrayList.add("тринадцать");

        System.out.println("Результат работы метода size():");
        System.out.printf("Размер массива: %s\n\n", myStringArrayList.size());

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.println("myStringArrayList: " + myStringArrayList + "\n");

        System.out.println("Результат работы метода get(22): ");
        System.out.println("myStringArrayList[22] = " + myStringArrayList.get(22) + "\n");
        System.out.println("Результат работы метода get(-5): ");
        System.out.println("myStringArrayList[-5] = " + myStringArrayList.get(-5) + "\n");
        System.out.println("Результат работы метода get(5): ");
        System.out.println("myStringArrayList[5] = " + myStringArrayList.get(5) + "\n");

        System.out.println("Результат работы метода delete(9): ");
        System.out.println("Удаление элемента массива " + myStringArrayList.delete(9) + "\n");
        System.out.println("Результат работы метода delete(-2): ");
        System.out.println("Удаление элемента массива " + myStringArrayList.delete(-2) + "\n");
        System.out.println("Результат работы метода delete(2): ");
        System.out.println("Удаление элемента массива " + myStringArrayList.delete(2) + "\n");

        System.out.println("Результат работы метода size():");
        System.out.printf("Размер массива: %s\n\n", myStringArrayList.size());

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.println("myStringArrayList: " + myStringArrayList + "\n");

        System.out.println("Результат работы метода insert(-10, -10): ");
        System.out.println("Вставка элемента массива " + myStringArrayList.insert("-10",-10) + "\n");

        System.out.println("Результат работы метода insert(888, 8): ");
        System.out.println("Вставка элемента массива " + myStringArrayList.insert("888",8) + "\n");

        System.out.println("Результат работы метода size():");
        System.out.printf("Размер массива: %s\n\n", myStringArrayList.size());

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.println("myStringArrayList: " + myStringArrayList + "\n");

        System.out.printf("Результат работы метода insert(\"18\", 18) = %s\n\n", myStringArrayList.insert("18",18));

        System.out.println("Результат работы метода size():");
        System.out.printf("Размер массива: %s\n\n", myStringArrayList.size());

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.println("myStringArrayList: " + myStringArrayList + "\n");

        // Создадим целочисленный массив-список
        NikoMuArrayList<Integer> myIntegerArrayList = new NikoMuArrayList<>(6, 3);
        System.out.printf("\n%sРабота с целочисленным массивом-списком%s\n\n", Color.ANSI_GREEN.getCode(), Color.ANSI_RESET.getCode());

        System.out.println("Результат работы метода size():");
        System.out.printf("Размер массива myIntegerArrayList: %s\n\n", myIntegerArrayList.size());

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.printf("myIntegerArrayList: %s\n\n", myIntegerArrayList);

        System.out.println("Работа метода add(10):\n");
        myIntegerArrayList.add(10);

        System.out.println("Результат работы метода size():");
        System.out.printf("Размер массива myIntegerArrayList: %s\n\n", myIntegerArrayList.size());

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.printf("myIntegerArrayList: %s\n\n", myIntegerArrayList);

        System.out.println("Работа метода add(5):\n");
        myIntegerArrayList.add(5);
        System.out.println("Работа метода add(98):\n");
        myIntegerArrayList.add(98);

        System.out.println("Результат работы метода size():");
        System.out.printf("Размер массива myIntegerArrayList: %s\n\n", myIntegerArrayList.size());

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.printf("myIntegerArrayList: %s\n\n", myIntegerArrayList);


        System.out.println("Результат работы метода get(22): ");
        System.out.println("myIntegerArrayList[22] = " + myIntegerArrayList.get(22) + "\n");
        System.out.println("Результат работы метода get(-2): ");
        System.out.println("myIntegerArrayList[-2] = " + myIntegerArrayList.get(-2) + "\n");
        System.out.println("Результат работы метода get(2): ");
        System.out.println("myIntegerArrayList[2] = " + myIntegerArrayList.get(2) + "\n");

        System.out.println("Результат работы метода delete(9): ");
        System.out.println("Удаление элемента массива " + myIntegerArrayList.delete(9) + "\n");
        System.out.println("Результат работы метода delete(-2): ");
        System.out.println("Удаление элемента массива " + myIntegerArrayList.delete(-2) + "\n");
        System.out.println("Результат работы метода delete(2): ");
        System.out.println("Удаление элемента массива " + myIntegerArrayList.delete(2) + "\n");

        System.out.println("Результат работы метода size():");
        System.out.printf("Размер массива: %s\n\n", myIntegerArrayList.size());

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.println("myIntegerArrayList: " + myIntegerArrayList + "\n");

        System.out.println("Результат работы метода insert(9, 8): ");
        System.out.println("Вставка элемента массива " + myIntegerArrayList.insert(9,8) + "\n");

        System.out.println("Результат работы метода size():");
        System.out.printf("Размер массива: %s\n\n", myIntegerArrayList.size());

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.println("myIntegerArrayList: " + myIntegerArrayList + "\n");

        System.out.println("Результат работы метода insert(5, 5): ");
        System.out.println("Вставка элемента массива " + myIntegerArrayList.insert(5,5) + "\n");

        System.out.println("Результат работы метода size():");
        System.out.printf("Размер массива: %s\n\n", myIntegerArrayList.size());

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.println("myIntegerArrayList: " + myIntegerArrayList + "\n");

        System.out.println("Результат работы метода insert(333_222, 0): ");
        System.out.println("Вставка элемента массива " + myIntegerArrayList.insert(333_222,0) + "\n");

        System.out.println("Результат работы метода size():");
        System.out.printf("Размер массива: %s\n\n", myIntegerArrayList.size());

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.println("myIntegerArrayList: " + myIntegerArrayList + "\n");
    }
}
