

import java.util.LinkedList;

public class Tuple {

    LinkedList<String> elements;

    public Tuple(LinkedList<String> elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return elements.toString();
    }

}
