import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Praktika {
    public static void main(String[] args) {
        // Создаём список животных для тестирования
        List<String> animals = new ArrayList<>();
        animals.add("DOG Жучка");
        animals.add("CAT Мурка");
        animals.add("DOG Бобик");
        animals.add("COW Зорька");
        animals.add("HORSE Грива");
        animals.add("CAT Барсик");
        animals.add("BIRD Чижик"); // Ошибочная строка для теста
        animals.add("Пушок"); // Ошибочная строка для теста

        // Создаём ферму
        AnimalFarm farm = new AnimalFarm(animals);

        // ===== Тест Задания 1 =====
        System.out.println("=== Задание 1: Подсчёт животных ===");
        HashMap<Animal, Integer> counts = farm.countedAnimals();
        System.out.println(counts);

        // ===== Тест Задания 2 =====
        System.out.println("\n=== Задание 2: Уникальные имена ===");
        Set<String> names = farm.uniqueNames();
        System.out.println(names);

        // ===== Тест Задания 3 =====
        System.out.println("\n=== Задание 3: Добавление животных ===");
        farm.addAnimal(Animal.DOG, "Шарик");      // по виду и имени
        farm.addAnimal(Animal.CAT);                // только по виду
        farm.addAnimal("Том");                     // только по имени
        System.out.println(farm);

        // ===== Тест Задания 4 =====
        System.out.println("\n=== Задание 4: toString ===");
        System.out.println(farm.toString());
    }
}