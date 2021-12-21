package com.nikomu_fight;

import com.nikomu_array_list.NikoMuArrayList;
import com.nikomu_enums.Color;

// Абстрактный супер-класс "Персонаж"
public abstract class Personage {
    // Поле (свойство) Имя
    String name;
    // Поле (свойство) Жизнь
    int hitPoints;
    // Поле (свойство) Коэффициент проклятия - проклятие увечивает урон наносимый противником
    float curseRate;

    // Конструктор супер-класса (класса-родителя)
    public Personage(String name) {
        this.name = name;
        this.hitPoints = 100;
        this.curseRate = 1;
    }

    // Метод для получения имени "Персонажа"
    public String getName() {
        return this.name;
    }

    // Метод для установки имени "Персонажа"
    public void setName(String name) {
        this.name = name;
    }

    // Метод для получения жизни "Персонажа"
    public int getHitPoints() {
        return this.hitPoints;
    }

    // Метод для установки жизни "Персонажа"
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    // Метод для получения коэффициента проклятия "Персонажа"
    public float getCurseRate() {
        return this.curseRate;
    }

    // Метод для установки коэффициента проклятия "Персонажа"
    public void setCurseRate(float curseRate) {
        this.curseRate = curseRate;
    }

    // Абстрактный метод "Действие Персонажа"
    public abstract void Action(NikoMuArrayList<Personage> arrayList, Personage personage, int action);

    // Метод для рандомизации удара (от 30 до 70)
    protected int randomAttack() {
        return (int)(Math.random() * 40 + 30);
    }

    // Метод для рандомизации исцеления (от 20 до 50)
    protected int randomHeal() {
        return (int)(Math.random() * 30 + 20);
    }

    // Метод для рандомизации проклятия (от 1.1 до 1.3)
    protected float randomCurse() {
        return ((float)(Math.random() * 2 + 11) / 10);
    }

    // Переопределенный метод toString() для вывода информации о персонаже
    @Override
    public String toString() {
        return String.format("%s\"%s\" - %s%s hp%s", Color.ANSI_CYAN.getCode(), this.name, Color.ANSI_RED.getCode(),
                this.hitPoints, Color.ANSI_RESET.getCode());
    }
}
