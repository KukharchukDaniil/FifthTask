package entities;

import java.util.Objects;

public class Leaf implements Component{
    private String value;
    LeafType leafType;

    public Leaf(String value, LeafType leafType) {
        this.value = value;
        this.leafType = leafType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Leaf leaf = (Leaf) o;
        return Objects.equals(value, leaf.value) &&
                leafType == leaf.leafType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, leafType);
    }
}
