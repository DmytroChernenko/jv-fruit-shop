package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.storage.FruitStorage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionProcessorImpl implements TransactionProcessor {

    private Map<FruitTransaction.Operation, TransactionHandler> transactionHandlerMap;

    private FruitStorage fruitStorage;

    public TransactionProcessorImpl(FruitStorage fruitStorage) {
        this.transactionHandlerMap = new HashMap<>();
        this.fruitStorage = fruitStorage;
        transactionHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceTransactionHandler(fruitStorage));
        transactionHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyTransactionHandler(fruitStorage));
        transactionHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnTransactionHandler(fruitStorage));
        transactionHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseTransactionHandler(fruitStorage));
    }

    @Override
    public void process(FruitTransaction transaction) {
        transactionHandlerMap.get(transaction.getOperation()).handleTransaction(transaction);
    }

    @Override
    public void processAll(List<FruitTransaction> transactions) {
        transactions.forEach(this::process);
    }
}
