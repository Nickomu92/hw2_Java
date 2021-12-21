package com.nikomu_fight;

import com.nikomu_array_list.NikoMuArrayList;
import com.nikomu_enums.Color;

// Класс "Ведьма" - наследуется от класс супер-класса "Personage" и
// реализует 2 интерфейса - "Warriorable" и "Sorcererable"
public class Witch extends Personage implements Warriorable, Sorcererable {

    public Witch(String name) {
        super(name);
    }

    @Override
    public void Action(NikoMuArrayList<Personage> army, Personage personage, int action) {
        if(action == 1) {
            int attack = this.attack();
            attack = (int)(attack * personage.getCurseRate());
            personage.setHitPoints((personage.getHitPoints() - attack > 0) ? (personage.getHitPoints() - attack) : 0);
            System.out.printf("\n%s\"%s\"%s нанес %s%d hp%s %s\"%s\"%s. Осталось %s%d hp%s\n",
                    Color.ANSI_BLUE.getCode(), this.getName(), Color.ANSI_RESET.getCode(),
                    Color.ANSI_RED.getCode(), attack, Color.ANSI_RESET.getCode(),
                    Color.ANSI_BLUE.getCode(), personage.getName(), Color.ANSI_RESET.getCode(),
                    Color.ANSI_RED.getCode(), personage.getHitPoints(), Color.ANSI_RESET.getCode());

            if(personage.getHitPoints() == 0) {
                System.out.printf("\n%s\"%s\" погиб на поле битвы!%s\n",
                        Color.ANSI_RED.getCode(), personage.getName(), Color.ANSI_RESET.getCode());
                army.delete(army.indexOf(personage.getName()));
            }
        }

        else {
            float curse = this.curse();
            personage.setCurseRate(personage.getCurseRate() * curse);
            System.out.printf("\n%s\"%s\"%s наложил(-а) проклятие с коєф. %s%3.2f%s на %s\"%s\"%s. Общий коєф. проклятия %s%3.2f%s\n",
                    Color.ANSI_BLUE.getCode(), this.getName(), Color.ANSI_RESET.getCode(),
                    Color.ANSI_RED.getCode(), curse,  Color.ANSI_RESET.getCode(),
                    Color.ANSI_BLUE.getCode(), personage.getName(),  Color.ANSI_RESET.getCode(),
                    Color.ANSI_RED.getCode(), personage.getCurseRate(), Color.ANSI_RESET.getCode());
        }
    }

    @Override
    public int attack() {
        return this.randomAttack();
    }

    @Override
    public float curse() {
        return this.randomCurse();
    }
}
