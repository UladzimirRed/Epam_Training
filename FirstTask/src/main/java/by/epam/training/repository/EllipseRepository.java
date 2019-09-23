package by.epam.training.repository;

import by.epam.training.entity.Ellipse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class EllipseRepository implements BaseRepository<Ellipse> {
    private static final Logger logger = LogManager.getLogger(EllipseRepository.class);
    private static EllipseRepository instance;

    private EllipseRepository() {
    }
    public static EllipseRepository getInstance() {
        if (instance == null) {
            instance = new EllipseRepository();
        }
        return instance;
    }

    private static final List<Ellipse> REPO = new ArrayList<>();

    @Override
    public void add(Ellipse ellipse) {
        logger.info("Ellipse with ID=" + ellipse.getId() + " was added");
        REPO.add((int) ellipse.getId(), ellipse);
    }

    @Override
    public Ellipse find(long id) {
        return REPO.get((int) id);
    }

    @Override
    public Ellipse delete(Ellipse ellipse) {
        logger.info("Ellipse with ID=" + ellipse.getId() + " was deleted");
        return REPO.remove((int) ellipse.getId());
    }

    public void printRepo() {
        for (Ellipse ellipse : REPO) {
            logger.info("Element of Repository: \n" + ellipse);
        }
    }
}
