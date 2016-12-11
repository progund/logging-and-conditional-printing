package org.company.util;
import org.company.logging.Logger;
import java.io.*;

public class Util{
  // Create a logger for this class for DEBUG and higher levels
  static Logger logger;
  static{
    try{
      logger = new Logger(Logger.Level.DEBUG, new PrintStream(new FileOutputStream("logfile.log", true)));
    }catch(IOException ioe){
      System.err.println("Couldn't create log file stream: " + ioe.getMessage());
    }
  }
  public static void doSomething(){
    int i = 2;
    int j = 5*i;
    logger.debug("j is now " + j);
  }
}
