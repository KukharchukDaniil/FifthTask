package entities;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    List<Component> childNodes = new ArrayList<Component>();

    public Composite() {
    }
    public Composite(List<Component> childNodes) {
        this.childNodes = childNodes;
    }

    public void add(Component component){
        childNodes.add(component);
    }

    public List<Component> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(List<Component> childNodes) {
        this.childNodes = childNodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Composite composite = (Composite) o;

        return childNodes != null ? childNodes.equals(composite.childNodes) : composite.childNodes == null;
    }

    @Override
    public int hashCode() {
        return childNodes != null ? childNodes.hashCode() : 0;
    }
}
