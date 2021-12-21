package com.nikomu_fight;

import com.nikomu_enums.Color;
import com.nikomu_array_list.NikoMuArrayList;

import java.util.Scanner;

public class Fight {
    // Статическое поле (свойство) для хранения состояния использовал или нет наш герой
    // в текущей атаке действие "Атаковать"
    static boolean isAtack = false;
    // Статическое поле (свойство) для хранения состояния использовал или нет наш герой
    // в текущей атаке действие "Исцелять"
    static boolean isHeal = false;
    // Статическое поле (свойство) для хранения состояния использовал или нет наш герой
    // в текущей атаке действие "Проклинать"
    static boolean isCourse = false;
    // Статическое поле (свойство) для хранения чья сайчас атака - наша или противника
    static boolean isYouFirst = false;

    public static void main(String[] args) {
        createHeroesAndArmy();
    }

    // Метод для создания героев и армий
    public static void createHeroesAndArmy() {
        // Создаем наших героев
        Barbarian myBarbarian = new Barbarian("Мой Варвар");
        Magician myMagician = new Magician("Мой Маг");
        Witch myWitch = new Witch("Моя Ведьма");

        // Создаем нашу армию и добавляем в неё героев
        NikoMuArrayList<Personage> myArmy = new NikoMuArrayList<>();
        myArmy.add(myBarbarian);
        myArmy.add(myMagician);
        myArmy.add(myWitch);

        // Создаем героев противника
        Barbarian pcBarbarian = new Barbarian("Варвар противника");
        Magician pcMagician = new Magician("Маг противника");
        Witch pcWitch = new Witch("Ведьма противника");

        // Создаем армию противника и добавляем в неё героев
        NikoMuArrayList<Personage> pcArmy = new NikoMuArrayList<>();
        pcArmy.add(pcBarbarian);
        pcArmy.add(pcMagician);
        pcArmy.add(pcWitch);

        preparationForBattle(myArmy, pcArmy);
    }

    // Метод подготовки перед боем
    public static void preparationForBattle(NikoMuArrayList<Personage> myArmy, NikoMuArrayList<Personage> pcArmy) {
        System.out.println("\n\tБитва началась!");

        // Для определения кто первый будет атаковать рандомим число от 0 до 100
        int first = (int)(Math.random() * 100);

        if(first % 2 == 0) {
            isYouFirst = true;
        }

        else {
            isYouFirst = false;
        }

        Scanner input = new Scanner(System.in);
        String symbol = "";

        do {
            isAtack = false;
            isHeal = false;
            isCourse = false;

            if(pcArmy.size() == 0) {
                System.out.println(Color.ANSI_GREEN.getCode() + "\nУра! Вы одержали победу!" + Color.ANSI_RESET.getCode());
                return;
            }

            if(myArmy.size() == 0) {
                System.out.println(Color.ANSI_RED.getCode() + "\nУвы, но Вы потерпели поражение!" + Color.ANSI_RESET.getCode());
                return;
            }

            if(isYouFirst) {
                System.out.println(Color.ANSI_YELLOW.getCode() + "\n\tВы атакуете!" + Color.ANSI_RESET.getCode());

                System.out.println("\n\tВаша армия:");
                for (int i = 0; i < myArmy.size(); i++) {
                    System.out.printf("[%d] - %s\n", i + 1, myArmy.get(i));
                }
                System.out.println("[q] - Капитуляция (выход из приложения) ...");

                System.out.print("Выберите персонаж: ");
                symbol = input.nextLine();

                if((symbol.equals("1") && !isAtack) || (symbol.equals("2") && !isAtack && !isHeal)  || (symbol.equals("3") && !isAtack && !isCourse)) {
                    selectAction(Integer.parseInt(symbol) - 1, myArmy, pcArmy);
                    isYouFirst = false;
                }

                else if(symbol.equals("q") || symbol.equals("Q") || symbol.equals("й") || symbol.equals("Й")) {
                    System.out.println("Капитуляция (выходим из приложения) ...");
                }

                else {
                    System.out.println(Color.ANSI_RED.getCode() + "Нет такого персонажа" + Color.ANSI_RESET.getCode());
                }
            }

            else {
                System.out.println(Color.ANSI_YELLOW.getCode() + "\n\tКомпьютер атакует!" + Color.ANSI_RESET.getCode());
                pcArmy.get(0).Action(myArmy, myArmy.get(0), 1);
                isYouFirst = true;
            }
        } while(!symbol.equals("q") && !symbol.equals("Q") && !symbol.equals("й") && !symbol.equals("Й"));
    }

    // Статический метод выбора действий для нашего персонажа
    public static void selectAction(int heroId, NikoMuArrayList<Personage> myArmy, NikoMuArrayList<Personage> pcArmy) {
        Scanner input = new Scanner(System.in);
        String symbol;
        String menu = "";

        do {
            // Если у противника закончились жизни у героев
            if(pcArmy.size() == 0) {
                return;
            }

            // Возможние варианты действий для "Варвара"
            if(myArmy.get(heroId) instanceof Barbarian) {
                if(!isAtack) {
                    menu = "[1] - Атаковать;\n[q] - Отступить (выход из боя).";
                }

                else {
                    return;
                }
            }

            // Возможние варианты действий для "Мага"
            if(myArmy.get(heroId) instanceof Magician) {
                if(!isAtack && !isHeal) {
                    menu = "[1] - Атаковать;\n[2] - Исцелять своих\n[q] - Отступить (выход из боя).";
                }

                else if(!isAtack && isHeal) {
                    menu = "[1] - Атаковать;\n[q] - Отступить (выход из боя).";
                }

                else if(!isHeal && isAtack) {
                    menu = "[2] - Исцелять своих\n[q] - Отступить (выход из боя).";
                }

                else {
                    return;
                }
            }

            // Возможние варианты действий для "Ведьмы"
            if(myArmy.get(heroId) instanceof Witch) {
                if(!isAtack && !isCourse) {
                    menu = "[1] - Атаковать;\n[2] - Наложить проклятие\n[q] - Отступить (выход из боя).";
                }

                else if(!isAtack && isCourse) {
                    menu = "[1] - Атаковать;\n[q] - Отступить (выход из боя).";
                }

                else if(!isCourse && isAtack) {
                    menu = "[2] - Наложить проклятие\n[q] - Отступить (выход из боя).";
                }

                else {
                    return;
                }
            }

            System.out.println("\n\tВозможные действия");
            System.out.println(menu);
            System.out.print("Выберите действие: ");
            symbol = input.nextLine();

            if(symbol.equals("1") || symbol.equals("2")) {
                if(symbol.equals("1") && myArmy.get(heroId) instanceof Barbarian && !isAtack) {
                    selectHero(heroId, myArmy, pcArmy, Integer.parseInt(symbol));
                    isAtack = true;
                }

                else if(symbol.equals("1") && myArmy.get(heroId) instanceof Magician && !isAtack) {
                    selectHero(heroId, myArmy, pcArmy, Integer.parseInt(symbol));
                    isAtack = true;
                }

                else if(symbol.equals("1") && myArmy.get(heroId) instanceof Witch && !isAtack) {
                    selectHero(heroId, myArmy, pcArmy, Integer.parseInt(symbol));
                    isAtack = true;
                }

                else if(symbol.equals("2") && myArmy.get(heroId) instanceof Magician && !isHeal) {
                    selectHero(heroId, myArmy, pcArmy, Integer.parseInt(symbol));
                    isHeal = true;
                }

                else if(symbol.equals("2") && myArmy.get(heroId) instanceof Witch && !isCourse) {
                    selectHero(heroId, myArmy, pcArmy, Integer.parseInt(symbol));
                    isCourse = true;
                }

                else {
                    System.out.println(Color.ANSI_RED.getCode() + "Нет такого действия" + Color.ANSI_RESET.getCode());
                }
            }

            else if(symbol.equals("q") || symbol.equals("Q") || symbol.equals("й") || symbol.equals("Й")) {
                System.out.println("Отступаем (выходим из из боя) ...");
            }

            else {
                System.out.println(Color.ANSI_RED.getCode() + "Нет такого действия" + Color.ANSI_RESET.getCode());
            }
        } while(!symbol.equals("q") && !symbol.equals("Q") && !symbol.equals("й") && !symbol.equals("Й"));
    }

    // Статический метод выбора объекта к кому применятся действия нашего персонажа
    public static void selectHero(int heroId, NikoMuArrayList<Personage> myArmy, NikoMuArrayList<Personage> pcArmy, int action) {
        Scanner input = new Scanner(System.in);
        String symbol;

        do {
            if(myArmy.get(heroId) instanceof Magician && action == 2) {
                if(myArmy.size() > 0) {
                    System.out.println("\n\tМоя армия:");
                    for (int i = 0; i < myArmy.size(); i++) {
                        System.out.printf("[%d] - %s\n", i + 1, myArmy.get(i));
                    }
                }
            }

            else {
                if(pcArmy.size() > 0) {
                    System.out.println("\n\tАрмия противника:");
                    for (int i = 0; i < pcArmy.size(); i++) {
                        System.out.printf("[%d] - %s\n", i + 1, pcArmy.get(i));
                    }
                }
            }

            System.out.print("[q] - Отступить (выход из боя).\nВыберите персонаж: ");
            symbol = input.nextLine();

            if(symbol.equals("1") || symbol.equals("2") || symbol.equals("3")) {
                if(myArmy.get(heroId) instanceof Magician & action == 2) {
                    if((Integer.parseInt(symbol) - 1 < myArmy.size()) && !isHeal) {
                        myArmy.get(heroId).Action(myArmy, myArmy.get(Integer.parseInt(symbol) - 1), action);
                        return;
                    }
                }

                else {
                    if (Integer.parseInt(symbol) - 1 < pcArmy.size()) {
                        if(action == 1 && !isAtack) {
                            myArmy.get(heroId).Action(pcArmy, pcArmy.get(Integer.parseInt(symbol) - 1), action);
                        }

                        if(action == 2 && !isCourse) {
                            myArmy.get(heroId).Action(pcArmy, pcArmy.get(Integer.parseInt(symbol) - 1), action);
                        }
                        return;
                    }
                }
            }

            if(symbol.equals("q") || symbol.equals("Q") || symbol.equals("й") || symbol.equals("Й")) {
                System.out.println("Отменить действие...");
            }

            else {
                System.out.println(Color.ANSI_RED.getCode() + "Нет такого персонажа" + Color.ANSI_RESET.getCode());
            }

        } while(!symbol.equals("q") && !symbol.equals("Q") && !symbol.equals("й") && !symbol.equals("Й"));
    }
}
