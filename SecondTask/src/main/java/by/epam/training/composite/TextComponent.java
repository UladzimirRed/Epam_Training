package by.epam.training.composite;

import java.util.LinkedList;

public interface TextComponent {

    LinkedList<TextComponent> getComponents();

    void add(TextComponent component);

    void remove(TextComponent component);

    TextComponent getChild(int index);

    ComponentType getType();
}
