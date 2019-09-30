package by.epam.training.composite;

import java.util.LinkedList;
import java.util.List;

public class TextElement implements TextComponent {
    private static final LinkedList<TextComponent> ELEMENT_COMPONENTS_MOCK = new LinkedList<>();
    private ElementType elementType;
    private char element;

    public TextElement(ElementType elementType, char element) {
        this.elementType = elementType;
        this.element = element;
    }

    public ElementType getElementType() {
        return elementType;
    }

    public void setElementType(ElementType elementType) {
        this.elementType = elementType;
    }

    public char getElement() {
        return element;
    }

    public void setElement(char element) {
        this.element = element;
    }

    @Override
    public LinkedList<TextComponent> getComponents() {
        return ELEMENT_COMPONENTS_MOCK;
    }

    @Override
    public void add(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public TextComponent getChild(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ComponentType getType() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addAll(List<TextComponent> components) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextElement that = (TextElement) o;

        if (element != that.element) return false;
        return elementType == that.elementType;
    }

    @Override
    public int hashCode() {
        int result = elementType != null ? elementType.hashCode() : 0;
        result = 31 * result + (int) element;
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(element);
    }
}
