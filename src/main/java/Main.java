import java.util.Scanner;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try{
            Future<Integer> inputNum = executor.submit(getCallableInteger());
            int outputNum = inputNum.get();
            System.out.println(outputNum);
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }

        executor.shutdown();
    }
    public static Callable<Integer> getCallableInteger() {
        // your code here
        try(Scanner scanner = new Scanner(System.in)){

            System.out.println("Please write a integer: ");
            int inputInteger = scanner.nextInt();
            return new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return inputInteger;
                }
            };

        }


    };
}