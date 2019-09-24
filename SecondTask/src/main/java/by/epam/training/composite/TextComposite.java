package by.epam.training.composite;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private List<TextComponent> components = new ArrayList<>();
    private ComponentType type;
    private static boolean isOutputText = true;

    public TextComposite() {
    }

    public TextComposite(ComponentType currentType) {
        this.type = currentType;
    }

    @Override
    public List<TextComponent> getComponents() {
        return components;
    }

    @Override
    public void add(TextComponent component, ComponentType currentType) {
        this.type = currentType;
        components.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        components.remove(component);
    }

    @Override
    public void setIsOutputText(boolean isReading) {
        isOutputText = isReading;
    }

    @Override
    public ComponentType getComponentType() {
        return this.type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextComposite that = (TextComposite) o;
        if (!components.equals(that.components)) return false;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        int result = components.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {                                      // FIXME
        StringBuilder stringBuilder = new StringBuilder();
        for (TextComponent component : components) {
            stringBuilder.append(component.toString());
        }
        if (type == ComponentType.EXPRESSION && isOutputText) {
            stringBuilder.delete(0, stringBuilder.length());
            stringBuilder.append(" ");
        } else {
            if (type == ComponentType.SENTENCE) {
                stringBuilder.append("\n");
            } else {
                if (type == ComponentType.WORD && isOutputText) {
                    stringBuilder.append(" ");
                }
            }
        }
        return stringBuilder.toString();
    }
}
