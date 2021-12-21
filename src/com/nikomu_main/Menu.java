package com.nikomu_main;

import com.nikomu_array_list.ArrayList;
import com.nikomu_linked_list.ForwardLinkedList;
import com.nikomu_fight.Fight;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String symbol;

        do {
            // Блок текта, представляющий информацию о возможных действиях
            String menu = """
                    [1] - Задание №1 (Ответ на вопрос);
                    [2] - Задание №2 (Создание ArrayList);
                    [3] - Задание №3 (Создание ForwardLinkedList);
                    [4] - Задание №4 (Создание игры \"Fight\");
                    
                    [q] - Выход из приложения.
                    """;

            System.out.println("\n\n\n\tДомашнее задание №2\n\tМулина Николая");
            System.out.println("\t\tГлавное меню");
            System.out.println(menu);
            System.out.print("Ваш выбор: ");
            symbol = input.nextLine();
            System.out.println();

            switch(symbol) {
                case "1":
                    Question.main(null);
                    break;
                case "2":
                    ArrayList.main(null);
                    break;
                case "3":
                    ForwardLinkedList.main(null);
                    break;
                case "4":
                    Fight.main(null);
                    break;
                case "q":
                case "Q":
                case "й":
                case "Й":
                    System.out.println("Выходим из приложения...");
                    break;
                default:
                    System.out.println("Нет такого пункта меню");
            }
            // Работаем в цикле пока пользователь не нажмет клавишу "q"
        } while(!symbol.equals("q") && !symbol.equals("Q") && !symbol.equals("й") && !symbol.equals("Й"));
    }
}
