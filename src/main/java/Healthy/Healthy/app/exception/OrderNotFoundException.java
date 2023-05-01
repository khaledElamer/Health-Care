package Healthy.Healthy.app.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("Orders not found with id: " + id);
    }

    {
    }
}
