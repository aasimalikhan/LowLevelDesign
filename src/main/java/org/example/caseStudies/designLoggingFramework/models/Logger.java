package org.example.caseStudies.designLoggingFramework.models;

import static org.example.caseStudies.designLoggingFramework.models.LogManager.buildChainOfLogger;
import static org.example.caseStudies.designLoggingFramework.models.LogManager.buildSubject;

public class Logger {
    private volatile static Logger singletonObject;
    private volatile static AbstractLogger chainOfLogger;
    private volatile static LogSubject logSubject;
    private Logger()
    {
        if(singletonObject != null)
        {
            throw new IllegalStateException("Object already created");
        }
    }
    public static Logger getInstance()
    {
        if(singletonObject == null)
        {
            synchronized (Logger.class)
            {
                if(singletonObject == null)
                {
                    singletonObject = new Logger();
                    chainOfLogger = buildChainOfLogger();
                    logSubject = buildSubject();
                }
            }
        }
        return singletonObject;
    }
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    private void createLog(int level, String message, LogSubject logSubject)
    {
        chainOfLogger.logMessage(level, message, logSubject);
    }

    public void info(String message)
    {
        createLog(1, message, logSubject);
    }
    public void error(String message)
    {
        createLog(2, message, logSubject);
    }
    public void debug(String message)
    {
        createLog(3, message, logSubject);
    }
}
