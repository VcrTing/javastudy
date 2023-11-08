package com.example.iogback.utii;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IogTooi {
    static Logger logger = LoggerFactory.getLogger(IogTooi.class);
    public static void info(Object msg) { logger.info(msg.toString()); }
}
