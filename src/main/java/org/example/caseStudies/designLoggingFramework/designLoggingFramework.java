package org.example.caseStudies.designLoggingFramework;

import org.example.caseStudies.designLoggingFramework.models.Logger;

public class designLoggingFramework {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.info("calling A method");
        logger.debug("calling B method");
        logger.error("calling C method");
    }
}
