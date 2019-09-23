package by.epam.training.composite;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private static final String TABULATION = "\t";
    private static final String LINE_FEED = "\n";
    private static final String SPACE = "\u0020";

    private List<TextComponent> components = new ArrayList<>();
    private ComponentType type;

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
    public String toString() {                                                               //FIXME override toString
        final StringBuilder sb = new StringBuilder("TextComposite{");
        sb.append("components=").append(components);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
