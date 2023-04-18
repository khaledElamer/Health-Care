package Healthy.Healthy.app.repository;

import Healthy.Healthy.app.Model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Long> {

}
