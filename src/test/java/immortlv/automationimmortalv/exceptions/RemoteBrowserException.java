package immortlv.automationimmortalv.exceptions;

public class RemoteBrowserException extends RuntimeException {
    String info;

    public RemoteBrowserException(String info) {
        this.info = info;
    }
}
