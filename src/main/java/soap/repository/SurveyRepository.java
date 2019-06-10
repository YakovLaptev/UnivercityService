package soap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soap.entity.Survey;

import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {

    List<Survey> findByCurse(int curse);
    List<Survey> findBySpecialtyCode(String specialtyCode);
}
