package org.company.main;
import org.company.logging.Logger;
import org.company.util.Util;

public class Main{
  public static void main(String[] args){
    // Use the user-specified log level provided via
    // the -DLOG_LEVEL=SOME_LEVEL flag:
    Logger logger = getLogger();
    
    logger.log("logging Hello");
    logger.debug("This is a debug message");
    logger.warn("This is the final warning!");
    logger.severe("This is as bad as it gets!");
    Util.doSomething();

  }

  private static Logger getLogger(){
    String logLevel = System.getProperty("LOG_LEVEL");
    if(logLevel==null){
      return new Logger(Logger.Level.OFF);
    }
    return new Logger(Logger.Level.parse(logLevel));
  }
}
