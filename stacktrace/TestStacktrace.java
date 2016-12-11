public class TestStacktrace{
  public static void main(String[] args){
    test();
  }
  static void test(){
    try{
      StackTraceElement[]  elems = Thread.currentThread().getStackTrace();
      System.out.println(java.util.Arrays.toString(elems));
    }catch(Exception e){}
  }
}
