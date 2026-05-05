package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionHandler;

public class ReturnTransactionHandler implements TransactionHandler {
    private FruitStorage storage;

    public ReturnTransactionHandler(FruitStorage storage) {
        this.storage = storage;
    }

    @Override
    public void handleTransaction(FruitTransaction transaction) {
        storage.returnFruit(new Fruit(transaction.getFruit()), transaction.getQuantity());
    }
}
