package by.epam.training.composite;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TextComposite implements TextComponent {
    private LinkedList<TextComponent> components;
    private ComponentType type;

    public TextComposite(ComponentType currentType) {
        this.type = currentType;
        this.components = new LinkedList<>();
    }

    @Override
    public LinkedList<TextComponent> getComponents() {
        return components;
    }

    @Override
    public void add(TextComponent component) {
        components.add(component);
    }

    @Override
    public void addAll(List<TextComponent> components) {
        this.components.addAll(components);
    }

    @Override
    public void remove(TextComponent component) {
        components.remove(component);
    }

    @Override
    public TextComponent getChild(int index) {
        return components.get(index);
    }

    @Override
    public ComponentType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextComposite that = (TextComposite) o;

        if (components != null ? !components.equals(that.components) : that.components != null) return false;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        int result = components != null ? components.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        ArrayList<String> strings = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (TextComponent textDataComponent : components) {
            strings.add(textDataComponent.toString());
        }
        if (ComponentType.PARAGRAPH.equals(type)) {
            strings.add(0, "    ");
            strings.add("\n");
        }
        if (ComponentType.LEXEME.equals(type)) {
            strings.add(" ");
        }
        for (String string : strings) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
}
