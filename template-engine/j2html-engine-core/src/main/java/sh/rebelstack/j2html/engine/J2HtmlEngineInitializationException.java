package sh.rebelstack.j2html.engine;

public class J2HtmlEngineInitializationException extends RuntimeException {
    public J2HtmlEngineInitializationException(String message) {
        super(message);
    }

    public J2HtmlEngineInitializationException(String message, Throwable cause) {
        super(message, cause);
    }
}
