public class TestLogging{
  private static final boolean DO_DEBUG;
  static{
    //If we don't care what the value of DO_DEBUG is,
    //just that it is set to something, this works fine:
    //DO_DEBUG = System.getProperty("DO_DEBUG") != null;

    // If we need it to be set to "true" (or "TRUE" etc):
    DO_DEBUG = Boolean.parseBoolean(System.getProperty("DO_DEBUG"));
  }
  public static void main(String[] args){
    String tag = "TestLogging.main";
    debug(tag, "args.length: " + args.length);
    for(int i = 0; i<args.length; i++){
      debug(tag, "i: " + i);
      System.out.println(args[i].toUpperCase());      
    }
  }

  public static void debug(String tag, String msg){
    if(DO_DEBUG){
      System.out.println("DEBUG: " + tag + " " + msg); 
    }
  }
}
