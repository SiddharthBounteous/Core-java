package importantConcepts;

class Logger{

    private static Logger logger;
    //private constructor
    //prevents object creation from outside the class.
    private Logger(){
        System.out.println("Inside Constructor");
    }

    //static method to return instance of Logger
    //now thread safe with synchronized
    public static synchronized Logger getInstance(){
        //check if the instance is null
        if(logger==null){
            logger=new Logger();
        }
        return logger;
    }

    public String logData(){
        return "Data logged";
    }
}
public class SingletonDemo {
    public static void main(String[] args) {
        //get instance of logger
        Logger logger=Logger.getInstance();
        System.out.println(logger.logData());

        Logger logger2=Logger.getInstance();
        System.out.println(logger2.logData());

        System.out.println(logger==logger2);
    }
}
