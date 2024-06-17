package core.basesyntax.storage;

import core.basesyntax.model.Fruit;

import java.util.HashMap;
import java.util.Map;

public class FruitStorageImpl implements FruitStorage {
    private final Map<Fruit, Integer> storage = new HashMap<>();
    @Override
    public int getFruitCount(Fruit fruit) {
        return storage.get(fruit);
    }

    @Override
    public void supply(Fruit fruit, int count) {
        if (storage.containsKey(fruit)) {
            storage.put(fruit, storage.get(fruit) + count);
        } else {
            storage.put(fruit, count);
        }
    }

    @Override
    public void purchase(Fruit fruit, int count) {
        if (storage.containsKey(fruit) && storage.get(fruit) > count) {
            storage.put(fruit, storage.get(fruit) - count);
        } else {
            System.out.println("there is no " + fruit.getName());
        }
    }

    @Override
    public void returnFruit(Fruit fruit, int count) {
        if (storage.containsKey(fruit)) {
            storage.put(fruit, storage.get(fruit) + count);
        } else {
            storage.put(fruit, count);
        }
    }

    public Map<Fruit, Integer> getAll() {
        return storage;
    }
}
