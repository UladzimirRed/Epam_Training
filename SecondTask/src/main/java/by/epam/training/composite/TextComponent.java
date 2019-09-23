package by.epam.training.composite;

import java.util.ArrayList;
import java.util.List;

public interface TextComponent {
    default List<TextComponent> getComponents() {
        return new ArrayList<>();
    }

    default void add(TextComponent component, ComponentType type) {
    }

    default void remove(TextComponent component) {
    }

    ComponentType getComponentType();
}
