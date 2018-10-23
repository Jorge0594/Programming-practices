package Singlenton;
/*
    Description:

    The object only instance once and the private constructor prevents that the people can instantiate it outside the class.
*/

public class Singlenton {
    private static Singlenton instance = null;

    private Singlenton() {
    }

    private static Singlenton  getInstance(){
        if(instance == null){
            return new Singlenton();
        }

        return instance;
    }
}
