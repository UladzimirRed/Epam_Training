package by.epam.training.entity;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class LogisticBase implements Runnable {

    private static final Logger logger = LogManager.getLogger(LogisticBase.class);
    private static LogisticBase base;
    private static ReentrantLock lock = new ReentrantLock();
    private static AtomicBoolean isCreate = new AtomicBoolean(false);

    private int numberOfTerminals;

    private LogisticBase() {
    }

    public static LogisticBase getInstance() {
        if (!isCreate.get()) {
            try {
                lock.lock();
                if (base == null) {
                    base = new LogisticBase();
                    isCreate.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return base;
    }

    public int getNumberOfTerminals() {
        return numberOfTerminals;
    }

    public void setNumberOfTerminals(int numberOfTerminals) {
        try {
            lock.lock();
            this.numberOfTerminals = numberOfTerminals;
        } finally {
            lock.unlock();
        }

    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfTerminals; i++) {
            new Thread(new Terminal()).start();
        }
    }
}
