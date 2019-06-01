package soap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soap.entity.Specialty;

public interface SpecialtyRepository extends JpaRepository<Specialty, String> {
}
