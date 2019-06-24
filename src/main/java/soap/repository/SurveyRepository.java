package soap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import soap.entity.Survey;

import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {
    List<Survey> findAllBySpecialtyCode(String specialtyCode);
    List<Survey> findAllByCurse(int curse);
    List<Survey> findAllByDepartment(String department);
    List<Survey> findAllByInstitute(String institute);
    List<Survey> findAllBySpecialty(String specialty);
    List<Survey> findAllByStudyForm(String studyForm);

    @Query(value = "SELECT * FROM Survey group by institute", nativeQuery = true)
    List<Survey> findAllGroupByinstitute();

    @Query(value = "SELECT * FROM Survey group by department", nativeQuery = true)
    List<Survey> findAllGroupBydepartment();

    @Query(value = "SELECT * FROM Survey group by specialtyCode", nativeQuery = true)
    List<Survey> findAllGroupByspecialtyCode();

    @Query(value = "SELECT * FROM Survey group by specialty", nativeQuery = true)
    List<Survey> findAllGroupByspecialty();

    @Query(value = "SELECT * FROM Survey group by curse", nativeQuery = true)
    List<Survey> findAllGroupBycurse();

    @Query(value = "SELECT * FROM Survey group by studyForm", nativeQuery = true)
    List<Survey> findAllGroupBystudyForm();

}
