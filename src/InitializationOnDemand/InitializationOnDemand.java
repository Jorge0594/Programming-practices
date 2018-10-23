package InitializationOnDemand;

/*
    Description:

    This pattern is similar to the singlenton pattern but it has a advantage it's a thread safe pattern.
    With this pattern you can avoid the synchronized implementation as result your code run faster.
 */

public class InitializationOnDemand {
    private InitializationOnDemand(){

    }

    private static  SinglentonSample getInstance(){
        return SinglentonSample.INSTANCE;
    }

    private static class SinglentonSample{
        private static final SinglentonSample INSTANCE = new SinglentonSample();
    }


}
