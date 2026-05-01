package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.FruitStorage;

public class BalanceTransactionHandler implements TransactionHandler{

    private FruitStorage storage;

    public BalanceTransactionHandler(FruitStorage storage) {
        this.storage = storage;
    }

    @Override
    public void handleTransaction(FruitTransaction transaction) {
        storage.supply(new Fruit(transaction.getFruit()), transaction.getQuantity());
    }
}
