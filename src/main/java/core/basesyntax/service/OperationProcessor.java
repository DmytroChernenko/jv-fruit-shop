package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface OperationProcessor {
    void process(FruitTransaction transaction);

    void processAll(List<FruitTransaction> transactions);
}
