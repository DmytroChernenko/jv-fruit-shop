package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.*;
import core.basesyntax.service.OperationProcessor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationProcessorImpl implements OperationProcessor {

    private Map<FruitTransaction.Operation, OperationHandler> transactionHandlerMap;

    private FruitStorage fruitStorage;

    public OperationProcessorImpl(FruitStorage fruitStorage) {
        this.transactionHandlerMap = new HashMap<>();
        this.fruitStorage = fruitStorage;
        transactionHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(fruitStorage));
        transactionHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(fruitStorage));
        transactionHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(fruitStorage));
        transactionHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(fruitStorage));
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
