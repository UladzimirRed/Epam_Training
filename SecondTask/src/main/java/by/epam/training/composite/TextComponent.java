package by.epam.training.composite;

import java.util.LinkedList;
import java.util.List;

public interface TextComponent {

    LinkedList<TextComponent> getComponents();

    void add(TextComponent component);

    void remove(TextComponent component);

    TextComponent getChild(int index);

    ComponentType getType();

    void addAll(List<TextComponent> components);
}
