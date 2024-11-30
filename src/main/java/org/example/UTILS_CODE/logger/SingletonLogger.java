package org.example.UTILS_CODE.logger;

public class SingletonLogger {
    private static Logger logger;
    private SingletonLogger(){}
    public static Logger getInstance() {
        if(logger == null)
        {
            synchronized (Logger.class)
            {
                if(logger == null)
                {
                    logger = new InfoLogger(new DebugLogger(new ErrorLogger(null)));
                }
            }
        }
        return logger;
    }
}
