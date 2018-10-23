package StrategyFactory;

import java.util.HashMap;
import java.util.Map;
/*
    Description:

    You just need to give the type of the object and one instance will be returned. In case that, the type doesn't exist will be return null.
 */
public class BuildingFactory {
    private static Map<String, Building> instances;

    static {
        instances = new HashMap<>();

        instances.put("house", new House());
        instances.put("edifice", new Edifice());
    }

    public static <T extends Building> T getInstance(String type){
        return (T)instances.get(type);
    }
}
