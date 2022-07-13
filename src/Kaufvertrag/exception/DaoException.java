package Kaufvertrag.exception;

public class DaoException {
    private final String message;

    public DaoException(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
