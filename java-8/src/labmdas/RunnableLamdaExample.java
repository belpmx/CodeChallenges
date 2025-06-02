package labmdas;

public class RunnableLamdaExample {
    public static void main(String[] args){
        //prior java 8
  Runnable runnable = new Runnable() {
      @Override
      public void run() {
        System.out.println("Inside runnable java 7 and prior");
      }

  };
        new Thread(runnable).start();

        //java 8 lambda
        // ()-> {};

        Runnable runnableLambda = () -> {
            System.out.println("java 8 multiline");
        };
        //you need to create a thread
        new Thread(runnableLambda).start();

        Runnable runnableLambda2 =() -> System.out.println("java 8 single line");

        //you need to create a thread
        new Thread(runnableLambda2).start();
        //create a Thread () and inside the lambda ()-> then put the function println
        new Thread(() -> System.out.println("Lambda on the thread")).start();

    }
}