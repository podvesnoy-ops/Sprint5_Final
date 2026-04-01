import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Praktika {
    public static void main(String[] args) {
        // Создаём тестовые данные
        List<String> animals = new ArrayList<>();
        animals.add("DOG Жучка");
        animals.add("CAT Мурка");
        animals.add("DOG Бобик");
        animals.add("COW Зорька");
        animals.add("HORSE Грива");
        animals.add("CAT Барсик");
        animals.add("bird Чижик");      // тест: нижний регистр
        animals.add("Пушок");           // тест: нет вида
        animals.add("");                // тест: пустая строка
        animals.add("CAT");             // тест: нет имени

        // Создаём ферму
        AnimalFarm farm = new AnimalFarm(animals);

        // ===== Тест Задания 1 =====
        System.out.println("=== Задание 1: Подсчёт животных ===");
        Map<Animal, Integer> counts = farm.countedAnimals();
        System.out.println(counts);

        // ===== Тест Задания 2 =====
        System.out.println("\n=== Задание 2: Уникальные имена ===");
        Set<String> names = farm.uniqueNames();
        System.out.println(names);

        // ===== Тест Задания 3 =====
        System.out.println("\n=== Задание 3: Добавление животных ===");
        farm.addFarmAnimal(Animal.DOG, "Шарик");    // по виду и имени
        farm.addFarmAnimal(Animal.CAT);              // только по виду
        farm.addFarmAnimal("Том");                   // только по имени
        System.out.println(farm);

        // ===== Тест Задания 4 =====
        System.out.println("\n=== Задание 4: toString ===");
        System.out.println(farm.toString());
    }
}