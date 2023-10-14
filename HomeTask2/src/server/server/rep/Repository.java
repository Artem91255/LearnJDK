package server.server.rep;

public interface Repository {
    String readLog();
    void saveInLog(String text);
}
