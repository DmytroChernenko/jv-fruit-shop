package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface TransactionHandler {
    void handleTransaction(FruitTransaction transaction);
}
