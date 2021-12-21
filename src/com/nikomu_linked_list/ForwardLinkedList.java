package com.nikomu_linked_list;

import com.nikomu_enums.Color;

public class ForwardLinkedList {
    public static void main(String[] args) {
        System.out.printf("%s\nЗадание: \"Создать свой ForwardLinkedList(add, delete, get, insert, size)\";%s\n\n", Color.ANSI_RED.getCode(), Color.ANSI_RESET.getCode());

        NikoMuLinkedList<String> myStringLinkedList = new NikoMuLinkedList<>();

        System.out.printf("\n%sРабота со строковым связанным списком\n\n%s", Color.ANSI_GREEN.getCode(), Color.ANSI_RESET.getCode());
        System.out.printf("Результат работы метода size(): %d\n\n", myStringLinkedList.size());

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.printf("myStringArrayList: %s \n\n", myStringLinkedList);

        System.out.println("Результат работы метода add(\"один\"):\n");
        myStringLinkedList.add("один");

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.printf("myStringArrayList: %s \n\n", myStringLinkedList);

        System.out.printf("Результат работы метода size(): %d\n\n", myStringLinkedList.size());

        System.out.println("Результат работы метода add(\"два\"):\n");
        myStringLinkedList.add("два");

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.printf("myStringArrayList: %s \n\n", myStringLinkedList);

        System.out.println("Результат работы метода add(\"три\"):\n");
        myStringLinkedList.add("три");

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.printf("myStringArrayList: %s \n\n", myStringLinkedList);

        System.out.println("Результат работы метода add(\"четыре\"):");
        myStringLinkedList.add("четыре");
        System.out.println("Результат работы метода add(\"пять\"):\n");
        myStringLinkedList.add("пять");

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.printf("myStringArrayList: %s \n\n", myStringLinkedList);

        System.out.printf("Результат работы метода size(): %d\n\n", myStringLinkedList.size());

        System.out.println("Результат работы метода get(2): ");
        System.out.println("myStringLinkedList[2] = " + myStringLinkedList.get(2) + "\n");

        System.out.printf("Результат работы метода delete(4) = %s\n\n", myStringLinkedList.delete(4));

        System.out.printf("Результат работы метода size(): %d\n\n", myStringLinkedList.size());

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.printf("myStringArrayList: %s \n\n", myStringLinkedList);

        System.out.printf("Результат работы метода size(): %d\n\n", myStringLinkedList.size());

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.printf("myStringArrayList: %s \n\n", myStringLinkedList);

        System.out.printf("Результат работы метода delete(2) = %s\n\n", myStringLinkedList.delete(2));

        System.out.printf("Результат работы метода size(): %d\n\n", myStringLinkedList.size());

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.printf("myStringArrayList: %s \n\n", myStringLinkedList);

        System.out.printf("Результат работы метода insert(\"100\", 100) = %s\n\n", myStringLinkedList.insert("100", 100));

        System.out.printf("Результат работы метода insert(\"1\", 1) = %s\n\n", myStringLinkedList.insert("1", 1));

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.printf("myStringArrayList: %s \n\n", myStringLinkedList);


        NikoMuLinkedList<Integer> myIntegerLinkedList = new NikoMuLinkedList<>();

        System.out.printf("\n%sРабота с целочисленным связанным списком\n\n%s", Color.ANSI_GREEN.getCode(), Color.ANSI_RESET.getCode());
        System.out.printf("Результат работы метода size(): %d\n\n", myIntegerLinkedList.size());

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.printf("myStringArrayList: %s \n\n", myIntegerLinkedList);

        System.out.printf("Результат работы метода insert(111, 0) = %s\n\n", myIntegerLinkedList.insert(111, 0));

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.printf("myStringArrayList: %s \n\n", myIntegerLinkedList);

        System.out.printf("Результат работы метода size(): %d\n\n", myIntegerLinkedList.size());

        System.out.printf("Результат работы метода insert(100, -100) = %s\n\n", myIntegerLinkedList.insert(100, 100));

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.printf("myStringArrayList: %s \n\n", myIntegerLinkedList);

        System.out.printf("Результат работы метода size(): %d\n\n", myIntegerLinkedList.size());

        System.out.println("Результат работы метода add(23):\n");
        myIntegerLinkedList.add(23);

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.printf("myStringArrayList: %s \n\n", myIntegerLinkedList);

        System.out.printf("Результат работы метода size(): %d\n\n", myIntegerLinkedList.size());

        System.out.printf("Результат работы метода insert(45_45, 1) = %s\n\n", myIntegerLinkedList.insert(45_45, 1));

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.printf("myStringArrayList: %s \n\n", myIntegerLinkedList);

        System.out.printf("Результат работы метода size(): %d\n\n", myIntegerLinkedList.size());

        System.out.printf("Результат работы метода delete(0) = %s\n\n", myIntegerLinkedList.delete(0));

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.printf("myStringArrayList: %s \n\n", myIntegerLinkedList);

        System.out.printf("Результат работы метода size(): %d\n\n", myIntegerLinkedList.size());

        System.out.printf("Результат работы метода delete(-5) = %s\n\n", myIntegerLinkedList.delete(-5));

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.printf("myStringArrayList: %s \n\n", myIntegerLinkedList);

        System.out.printf("Результат работы метода size(): %d\n\n", myIntegerLinkedList.size());

        System.out.printf("Результат работы метода delete(100) = %s\n\n", myIntegerLinkedList.delete(100));

        System.out.println("Результат работы перегруженного метода toString():");
        System.out.printf("myStringArrayList: %s \n\n", myIntegerLinkedList);

        System.out.printf("Результат работы метода size(): %d\n\n", myIntegerLinkedList.size());

        System.out.printf("Результат работы метода get(100) = %s\n\n", myIntegerLinkedList.get(100));
        System.out.printf("Результат работы метода get(-3) = %s\n\n", myIntegerLinkedList.get(-3));
        System.out.printf("Результат работы метода get(2) = %s\n\n", myIntegerLinkedList.get(2));

    }
}
