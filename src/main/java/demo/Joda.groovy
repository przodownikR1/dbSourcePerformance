package demo

@Grab(group="joda-time",module="joda-time",version="1.6")
class Joda {
  public static void main(String [] args){
      def today = new org.joda.time.DateTime();
      println today.toString("dd-MM-yyyy")
  }
}
