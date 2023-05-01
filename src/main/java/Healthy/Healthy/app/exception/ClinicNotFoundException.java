package Healthy.Healthy.app.exception;

public class ClinicNotFoundException extends RuntimeException {

    public ClinicNotFoundException(Long id) {
        super("Could not find clinic with id: " + id);
    }

}
