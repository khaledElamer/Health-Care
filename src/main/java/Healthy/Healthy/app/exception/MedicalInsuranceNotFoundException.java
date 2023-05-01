package Healthy.Healthy.app.exception;

public class MedicalInsuranceNotFoundException extends RuntimeException {
    public MedicalInsuranceNotFoundException(Long id) {
        super("MedicalInsurance not found with id: " + id);
    }


}
