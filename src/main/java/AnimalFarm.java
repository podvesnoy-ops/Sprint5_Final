import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnimalFarm {
    private final List<String> farmAnimals;

    public AnimalFarm(List<String> farmAnimals) {
        this.farmAnimals = farmAnimals;
    }

    // ========== ЗАДАНИЕ 1: countedAnimals ==========
    public HashMap<Animal, Integer> countedAnimals() {
        HashMap<Animal, Integer> animalCount = new HashMap<>();

        for (String animalString : farmAnimals) {
            String[] parts = animalString.split(" ");

            if (parts.length == 0) {
                System.out.println("Please correct string " + animalString + ". Incorrect input data.");
                continue;
            }

            try {
                Animal animalType = Animal.valueOf(parts[0]);
                animalCount.put(animalType, animalCount.getOrDefault(animalType, 0) + 1);
            } catch (IllegalArgumentException e) {
                System.out.println("Please correct string " + animalString + ". Incorrect input data.");
            }
        }

        return animalCount;
    }

    // ========== ЗАДАНИЕ 2: uniqueNames ==========
    public Set<String> uniqueNames() {
        Set<String> uniqueNames = new HashSet<>();

        for (String animalString : farmAnimals) {
            String[] parts = animalString.split(" ");

            if (parts.length < 2) {
                System.out.println("Please correct string " + animalString + ". Incorrect input data.");
                continue;
            }

            uniqueNames.add(parts[1]);
        }

        return uniqueNames;
    }

    // ========== ЗАДАНИЕ 3: Три метода добавления ==========

    // 3.1 — по виду и имени
    public void addAnimal(Animal type, String name) {
        farmAnimals.add(type + " " + name);
    }

    // 3.2 — только по виду (имя = "N")
    public void addAnimal(Animal type) {
        farmAnimals.add(type + " N");
    }

    // 3.3 — только по имени (вид = NOT_DEFINED)
    public void addAnimal(String name) {
        farmAnimals.add(Animal.NOT_DEFINED + " " + name);
    }

    // ========== ЗАДАНИЕ 4: Переопределение toString ==========
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (String animalString : farmAnimals) {
            String[] parts = animalString.split(" ");
            if (parts.length >= 2) {
                result.append(parts[0]).append(":").append(parts[1]).append("\n");
            }
        }

        return result.toString().trim();
    }
}