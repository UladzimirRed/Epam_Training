package by.epam.training.repository;

import by.epam.training.entity.Figure;

public interface BaseRepository<T extends Figure> {
    void add(T figure);
    Figure find(long id);
    Figure delete(T figure);
}
