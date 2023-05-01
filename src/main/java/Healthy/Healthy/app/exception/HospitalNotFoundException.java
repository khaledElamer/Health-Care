package Healthy.Healthy.app.exception;

public class HospitalNotFoundException extends RuntimeException{
        public HospitalNotFoundException(Long id) {
            super("Hospital not found with id: " + id);
        }
}
