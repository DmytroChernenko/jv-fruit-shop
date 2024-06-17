package core.basesyntax.model;

public final class Fruit {
    private final String name;

    public Fruit(String name) {
        this.name = new String(name);
    }

    public String getName() {
        return new String(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fruit fruit = (Fruit) o;

        return name.equals(fruit.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
