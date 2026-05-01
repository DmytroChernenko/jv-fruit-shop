package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.FruitStorage;

public class PurchaseTransactionHandler implements TransactionHandler{

    private FruitStorage storage;

    public PurchaseTransactionHandler(FruitStorage storage) {
        this.storage = storage;
    }

    @Override
    public void handleTransaction(FruitTransaction transaction) {
        storage.purchase(new Fruit(transaction.getFruit()), transaction.getQuantity());
    }
}
