package by.epam.training.main;

import by.epam.training.entity.LogisticBase;
import by.epam.training.entity.Truck;
import by.epam.training.exception.ProjectDataException;
import by.epam.training.util.creator.TruckCreator;
import by.epam.training.util.parser.TruckStringParser;
import by.epam.training.util.reader.TruckDataReader;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    private static final String DATA_PATH = "/data/data.txt";
    private static final int NUMBER_OF_TERMINALS = 5;

    public static void main(String[] args) throws ProjectDataException, URISyntaxException {
        LogisticBase logisticBase = LogisticBase.getInstance();
        logisticBase.setNumberOfTerminals(NUMBER_OF_TERMINALS);

        List<String> trucksStrings;
        TruckDataReader truckDataReader = new TruckDataReader();
        trucksStrings = truckDataReader.readFromDataFile(DATA_PATH);
        TruckStringParser truckStringParser = new TruckStringParser();
        List<String> truckDataList = new ArrayList<>();
        for (String string : trucksStrings) {
            String[] truckDataArray = truckStringParser.parseLine(string);
            for (String element : truckDataArray) {
                truckDataList.add(element);
            }
        }
        List<Truck> trucks = new ArrayList<>();
        for (int i = 0; i < truckDataList.size(); i = i + 3) {
            trucks.add(new Truck(Long.parseLong(truckDataList.get(i))
                    , Boolean.parseBoolean(truckDataList.get(i + 1))
                    , Boolean.parseBoolean(truckDataList.get(i + 2))));
        }
        new Thread(new TruckCreator(trucks)).start();
        new Thread(logisticBase).start();
    }
}
