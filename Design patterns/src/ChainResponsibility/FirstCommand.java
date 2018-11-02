package ChainResponsibility;

import java.util.Map;

public class FirstCommand implements Command<Map<String, Integer>> {
    @Override
    public boolean execute(Map<String, Integer> context) {
        //do stuff
        return false;
    }
}
