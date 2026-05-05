package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {

    private FruitStorage storage;

    public BalanceOperationHandler(FruitStorage storage) {
        this.storage = storage;
    }

    @Override
    public void handleTransaction(FruitTransaction transaction) {
        storage.supply(new Fruit(transaction.getFruit()), transaction.getQuantity());
    }
}
