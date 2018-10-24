package ChainResponsibility;

import java.util.Arrays;
import java.util.List;

/*
    Description:

    This pattern provides a separate logic in just one place, so it makes out code more decoupled, easier to understand and more easy to test.
 */

public class Chain {
    private List<Command> commands;

    public Chain(Command... commands) {
        this.commands = Arrays.asList(commands);
    }

    public Chain(List<Command> commands){
        this.commands = commands;
    }

    public void start(Object context){
        for (Command command : commands) {
            boolean stopLoop = command.execute(context);

            if(stopLoop) return;
        }
    }
}
