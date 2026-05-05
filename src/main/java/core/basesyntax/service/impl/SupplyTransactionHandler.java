package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.storage.FruitStorage;

public class SupplyTransactionHandler implements TransactionHandler {
    private FruitStorage storage;

    public SupplyTransactionHandler(FruitStorage storage) {
        this.storage = storage;
    }

    @Override
    public void handleTransaction(FruitTransaction transaction) {
        storage.supply(new Fruit(transaction.getFruit()), transaction.getQuantity());
    }
}
