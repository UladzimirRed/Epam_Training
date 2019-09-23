package by.epam.training.composite;

public class TextElement implements TextComponent {
    private char element;

    public TextElement(char textElement) {
        this.element = element;
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.SYMBOL;
    }

    @Override
    public String toString() {
        return String.valueOf(element);
    }
}
