package by.epam.training.xxx;

import by.epam.training.entity.Ellipse;
import by.epam.training.util.creator.EllipseBuilder;
import by.epam.training.util.parser.StringParser;

import by.epam.training.observer.EllipseObserver;
import by.epam.training.repository.EllipseRepository;
import by.epam.training.util.reader.FileReader;

import java.util.List;

public class Main {
    private static final String DEFAULT_PATH = "/data/data.txt";

    public static void main(String[] args) throws Exception {
        EllipseRepository ellipseRepository = EllipseRepository.getInstance();
        EllipseObserver ellipseObserver = new EllipseObserver();

        FileReader fileReader = new FileReader();
        List<String> list = fileReader.read(DEFAULT_PATH);
        for (String s : list) {
            double[] ellipseArrayCoordinate = StringParser.parseLineIntoArrayOfValues(s);
            Ellipse ellipse = EllipseBuilder.buildEllipse(ellipseArrayCoordinate[0], ellipseArrayCoordinate[1],
                    ellipseArrayCoordinate[2], ellipseArrayCoordinate[3]);
            ellipse.attach(ellipseObserver);
            ellipseRepository.add(ellipse);
        }
        ellipseRepository.printRepo();
        Ellipse ellipse = ellipseRepository.find(1);
        ellipse.setRadius2(-1);
        ellipseRepository.printRepo();
    }
}
