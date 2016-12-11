package org.company.logging;
import java.io.PrintStream;
public class Logger{
  public enum Level{
    ALL("ALL"),
    DEBUG("DEBUG"),
    LOG("LOG"),
    WARN("WARN"),
    SEVERE("SEVERE"),
    OFF("OFF");
    String tag;
    Level(String tag){
      this.tag = tag;
    }
    @Override
    public String toString(){
      return tag;
    }
    public static Level parse(String level){
      String theLevel = level.toUpperCase();
      switch(theLevel){
      case "ALL":
        return ALL;
      case "DEBUG":
        return DEBUG;
      case "LOG":
        return LOG;
      case "WARN":
        return WARN;
      case "SEVERE":
        return SEVERE;
      default: // Couldn't parse!
        return OFF;
      }
    }
  }
  private PrintStream out;
  private Level level;
  public Logger(Level level, PrintStream out){
    this.level = level;
    this.out = out;
  }
  public Logger(Level level){
    this(level, System.err);
  }
  public void setLevel(Level newLevel){
    this.level = newLevel;
  }
  
  public void debug(String s){
    if(level.compareTo(Level.DEBUG)>0){
      return;
    }
    _log(s, "DEBUG");
  }

  public void warn(String s){
    if(level.compareTo(Level.WARN)>0){
      return;
    }
    _log(s, "WARN");
  }

  public void severe(String s){
    if(level.compareTo(Level.SEVERE)>0){
      return;
    }
    _log(s, "SEVERE");
  }

  public void log(String s){
    if(level.compareTo(Level.LOG)>0){
      return;
    }
    _log(s, "LOG");
  }
  
  private void _log(String s, String type){
    StackTraceElement[] stElems;
    StringBuilder msg = new StringBuilder(new java.util.Date().toString());

    msg.append(" ").append(type).append(" ");
    try{
      stElems = Thread.currentThread().getStackTrace();
    }catch(Exception e){
      stElems = null;
      msg.append(" could not create stacktrace ");
      msg.append(e.getMessage());
    }
    msg.append(s);
    if(stElems != null){
      msg.append(" from ").append(stElems[3]);
    }
    out.println(msg);
  }
}
