package core.basesyntax.storage;

import core.basesyntax.model.Fruit;

import java.util.Map;

public interface FruitStorage {
    int getFruitCount(Fruit fruit);
    void supply(Fruit fruit, int count);
    void purchase(Fruit fruit, int count);

    void returnFruit(Fruit fruit, int count);

    Map<Fruit, Integer> getAll();
}
