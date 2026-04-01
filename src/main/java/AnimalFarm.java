import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.*;

public class AnimalFarm {
    private final List<String> farmAnimals;

    public AnimalFarm(List<String> farmAnimals) {
        this.farmAnimals = farmAnimals;
    }

    // ========== ЗАДАНИЕ 1: countedAnimals ==========
    public Map<Animal, Integer> countedAnimals() {
        Map<Animal, Integer> animalMap = new HashMap<>();

        for (String farmAnimal : farmAnimals) {
            // Проверка на пустую строку
            if (farmAnimal == null || farmAnimal.trim().isEmpty()) {
                System.out.printf("Please correct string %s. Incorrect input data. %n", farmAnimal);
                continue;
            }

            String[] parts = farmAnimal.split(" ");

            // Явная проверка длины массива (лучше чем ловить ArrayIndexOutOfBoundsException)
            if (parts.length == 0) {
                System.out.printf("Please correct string %s. Incorrect input data. %n", farmAnimal);
                continue;
            }

            try {
                // toUpperCase() для устойчивости к разному регистру
                Animal animal = Animal.valueOf(parts[0].toUpperCase());
                // getOrDefault() — современный способ (Java 8+)
                animalMap.put(animal, animalMap.getOrDefault(animal, 0) + 1);
            } catch (IllegalArgumentException e) {
                // Конкретное исключение вместо общего Exception
                System.out.printf("Please correct string %s. Incorrect input data. %n", farmAnimal);
            }
        }
        return animalMap;
    }

    // ========== ЗАДАНИЕ 2: uniqueNames ==========
    public Set<String> uniqueNames() {
        Set<String> uniqueNames = new HashSet<>();

        for (String farmAnimal : farmAnimals) {
            if (farmAnimal == null || farmAnimal.trim().isEmpty()) {
                System.out.printf("Please correct string %s. Incorrect input data. %n", farmAnimal);
                continue;
            }

            String[] parts = farmAnimal.split(" ");

            // Проверка: нужно минимум 2 элемента (вид и имя)
            if (parts.length < 2) {
                System.out.printf("Please correct string %s. Incorrect input data. %n", farmAnimal);
                continue;
            }

            uniqueNames.add(parts[1]);
        }
        return uniqueNames;
    }

    // ========== ЗАДАНИЕ 3: Три метода добавления ==========

    // 3.1 — по виду и имени
    public void addFarmAnimal(Animal animal, String name) {
        farmAnimals.add(animal.name() + " " + name);
    }

    // 3.2 — только по виду (имя = "N")
    public void addFarmAnimal(Animal animal) {
        farmAnimals.add(animal.name() + " N");
    }

    // 3.3 — только по имени (вид = NOT_DEFINED)
    public void addFarmAnimal(String name) {
        farmAnimals.add(Animal.NOT_DEFINED.name() + " " + name);
    }

    // ========== ЗАДАНИЕ 4: Переопределение toString ==========
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String farmAnimal : farmAnimals) {
            // replace() проще и элегантнее чем split() + append()
            String printFarmAnimal = farmAnimal.replace(" ", ":");
            stringBuilder.append(printFarmAnimal).append("\n");
        }
        // trim() убирает последний лишний перенос строки
        return stringBuilder.toString().trim();
    }
}