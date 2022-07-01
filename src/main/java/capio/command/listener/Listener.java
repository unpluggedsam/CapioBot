package capio.command.listener;

public interface Listener extends Runnable {

    @Override
    default void run() {
        execute();
    }

    void execute();
}
