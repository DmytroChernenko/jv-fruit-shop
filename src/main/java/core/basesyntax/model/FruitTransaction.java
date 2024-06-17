package core.basesyntax.model;

public final class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(String operation, String fruit, int quantity) {
        this.fruit = new String(fruit);
        this.quantity = quantity;

        switch (operation) {
        case "b":
            this.operation = Operation.BALANCE;
            break;
        case "s":
            this.operation = Operation.SUPPLY;
            break;
        case "p":
            this.operation = Operation.PURCHASE;
            break;
        case "r":
            this.operation = Operation.RETURN;
            break;
        default:
            throw new RuntimeException("incorrect operation: " + operation);
        }
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return new String(fruit);
    }

    public int getQuantity() {
        return quantity;
    }
    // getters, setters, ...

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    @Override
    public String toString() {
        return "FruitTransaction{" +
                "operation=" + operation +
                ", fruit='" + fruit + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}