package Battle;

import droids.Droid;

import java.util.List;

public class Battle {
    public static void oneOnOne(Droid droid1, Droid droid2, List<String> battleSteps) {
        battleSteps.add("Бій 1 на 1 між " + droid1.getName() + " та " + droid2.getName() + " почався!");

        while (droid1.isAlive() && droid2.isAlive()) {
            droid1.attack(droid2);
            battleSteps.add(droid1.getName() + " атакує " + droid2.getName() + "!");
            battleSteps.add(droid2.getName() + " отримав пошкодження!");

            if (droid2.isAlive()) {
                droid2.attack(droid1);
                battleSteps.add(droid2.getName() + " атакує " + droid1.getName() + "!");
                battleSteps.add(droid1.getName() + " отримав пошкодження!");
            }
        }

        if (droid1.isAlive()) {
            battleSteps.add(droid1.getName() + " переміг!");
        } else {
            battleSteps.add(droid2.getName() + " переміг!");
        }
    }

    public static void teamBattle(List<Droid> team1, List<Droid> team2, List<String> battleSteps) {
        battleSteps.add("Бій команда на команду почався!");

        while (!team1.isEmpty() && !team2.isEmpty()) {
            for (int i = 0; i < Math.max(team1.size(), team2.size()); i++) {
                // Атака з команди 1
                if (i < team1.size() && i < team2.size()) {
                    Droid attacker = team1.get(i);
                    Droid defender = team2.get(i);
                    if (attacker.isAlive() && defender.isAlive()) {
                        attacker.attack(defender);
                        battleSteps.add(attacker.getName() + " атакує " + defender.getName() + "!");
                        battleSteps.add(defender.getName() + " отримав пошкодження!");
                    }
                    if (!defender.isAlive()) {
                        team2.remove(i);
                        battleSteps.add(defender.getName() + " знищено!");
                    }
                }
                if (team2.isEmpty()) break;

                // Атака з команди 2
                if (i < team2.size() && i < team1.size()) {
                    Droid attacker = team2.get(i);
                    Droid defender = team1.get(i);
                    if (attacker.isAlive() && defender.isAlive()) {
                        attacker.attack(defender);
                        battleSteps.add(attacker.getName() + " атакує " + defender.getName() + "!");
                        battleSteps.add(defender.getName() + " отримав пошкодження!");
                    }
                    if (!defender.isAlive()) {
                        team1.remove(i);
                        battleSteps.add(defender.getName() + " знищено!");
                    }
                }
            }
        }

        if (team1.isEmpty()) {
            battleSteps.add("Команда 2 перемогла!");
        } else {
            battleSteps.add("Команда 1 перемогла!");
        }
    }
}
