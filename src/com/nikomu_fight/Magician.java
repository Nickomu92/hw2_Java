package com.nikomu_fight;

import com.nikomu_array_list.NikoMuArrayList;
import com.nikomu_enums.Color;

// Класс "Маг" - наследуется от класс супер-класса "Personage" и
// реализует 2 интерфейса - "Warriorable" и "Healerable"
public class Magician extends Personage implements Warriorable, Healerable {

    public Magician(String name) {
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
            int heal = this.heal();
            personage.setHitPoints((personage.getHitPoints() + heal <= 100) ? (personage.getHitPoints() + heal) : 100);
            System.out.printf("\n%s\"%s\"%s вылечил %s\"%s\"%s на %s%d hp%s. Общее здоровье -  %s%d hp%s\n",
                    Color.ANSI_BLUE.getCode(), this.getName(), Color.ANSI_RESET.getCode(),
                    Color.ANSI_BLUE.getCode(), personage.getName(), Color.ANSI_RESET.getCode(),
                    Color.ANSI_RED.getCode(), heal, Color.ANSI_RESET.getCode(),
                    Color.ANSI_RED.getCode(), personage.getHitPoints(), Color.ANSI_RESET.getCode());
        }
    }

    @Override
    public int attack() {
        return this.randomAttack();
    }

    @Override
    public int heal() {
        return this.randomHeal();
    }
}