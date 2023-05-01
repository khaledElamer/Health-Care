package Healthy.Healthy.app.exception;

public class MedicationNotFoundException extends RuntimeException {
    public MedicationNotFoundException(Long id) {
        super("Medication not found with id: " + id);
    }

}
