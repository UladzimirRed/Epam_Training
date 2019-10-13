package by.epam.training.entity;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class LogisticBase {

    private static final Logger logger = LogManager.getLogger(LogisticBase.class);
    private static LogisticBase base;
    private static ReentrantLock lock = new ReentrantLock();
    private static AtomicBoolean isCreate = new AtomicBoolean(false);

    public static LogisticBase getInstance(){
        if(!isCreate.get()){
            try {
                lock.lock();
                if (base == null){
                    base = new LogisticBase();
                    isCreate.set(true);
                }
            }
            finally {
                lock.unlock();
            }
        }
        return base;
    }

}
