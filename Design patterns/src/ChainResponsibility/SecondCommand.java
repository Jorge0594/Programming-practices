package ChainResponsibility;

import java.util.Map;

public class SecondCommand implements Command<Map<String, Integer>> {
    @Override
    public boolean execute(Map<String, Integer> context) {
        //Do stuff
        return false;
    }
}
