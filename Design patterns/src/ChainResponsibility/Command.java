package ChainResponsibility;

public interface Command <T> {
    boolean execute (T context);
}
