public class TestLogging{
  private static final boolean DO_DEBUG = true;
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
