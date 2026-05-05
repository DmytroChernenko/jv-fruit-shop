package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.*;
import core.basesyntax.service.OperationProcessor;
import java.util.List;
import java.util.Map;

public class OperationProcessorImpl implements OperationProcessor {

    private Map<FruitTransaction.Operation, OperationHandler> transactionHandlerMap;


    public OperationProcessorImpl(Map<FruitTransaction.Operation, OperationHandler> transactionHandlerMap) {
        this.transactionHandlerMap = transactionHandlerMap;
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
