import java.util.SplittableRandom;

public class WrongLoginException extends RuntimeException{
    public WrongLoginException(String message){
        super(message);
    }

}
