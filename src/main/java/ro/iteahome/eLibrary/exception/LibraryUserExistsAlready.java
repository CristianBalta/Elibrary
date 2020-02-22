package ro.iteahome.eLibrary.exception;

public class LibraryUserExistsAlready extends LibraryBusinessException {
    public LibraryUserExistsAlready() {
    }

    public LibraryUserExistsAlready(String message, Throwable cause) {
        super(message, cause);
    }
}
