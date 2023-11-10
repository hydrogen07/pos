package net.htlgrieskirchen.pos3.streams;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Weapon> weapons = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Path.of("numbers.csv"))) {
            stream.map(line -> line.split(";"))
                    .filter(line -> Arrays.equals(line, "name;combatType;damageType;damage;speed;strength;value".split(";")))
                    .forEach(line -> weapons.add(new Weapon(line[0], CombatType.valueOf(line[1]), DamageType.valueOf(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5]), Integer.parseInt(line[6]))));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        Comparator damage = Comparator.comparingInt(Weapon::getDamage);
        Comparator alphabet = (Weapon w1, Weapon w2) -> String.valueOf(w1.getDamageType()).compareTo(String.valueOf(w2.getDamageType()));
    }
}
