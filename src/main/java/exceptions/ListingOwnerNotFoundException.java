package exceptions;

public class ListingOwnerNotFoundException extends RuntimeException {
    public ListingOwnerNotFoundException(String message) {
        super(message);
    }
}
