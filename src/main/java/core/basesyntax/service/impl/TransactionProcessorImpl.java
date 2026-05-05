package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.service.TransactionProcessor;
import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {

    private TransactionHandler transactionHandler;

    @Override
    public void process(FruitTransaction transaction) {
        
    }

    @Override
    public void processAll(List<FruitTransaction> transactions) {

    }
}
