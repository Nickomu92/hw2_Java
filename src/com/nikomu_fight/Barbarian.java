package com.nikomu_fight;

import com.nikomu_array_list.NikoMuArrayList;
import com.nikomu_enums.Color;

// Класс "Варвар" - наследуется от класс супер-класса "Personage" и
// реализует интерфейс "Warriorable"
public class Barbarian extends Personage implements Warriorable {

    public Barbarian(String name) {
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
    }

    @Override
    public int attack() {
        return this.randomAttack();
    }
}
