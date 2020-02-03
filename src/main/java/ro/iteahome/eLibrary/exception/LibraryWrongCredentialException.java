package ro.iteahome.eLibrary.exception;

public class LibraryWrongCredentialException extends LibraryBusinessException {

    public LibraryWrongCredentialException() {
    }

    public LibraryWrongCredentialException(String message, Throwable cause) {
        super(message, cause);
    }
}
