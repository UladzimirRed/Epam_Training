package by.epam.training.parser;

public interface SourceParsable<T, R> {
    R parseText(T data);
}
