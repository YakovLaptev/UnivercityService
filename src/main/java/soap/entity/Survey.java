package soap.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;


@Entity
@Table(name = "survey")
@Proxy(lazy = false)
public class Survey extends ModelBase {

    @Column(name = "institute")
    private String institute;

    @Column(name = "department")
    private String department;

    @Column(name = "specialtyCode")
    private String specialtyCode;

    @Column(name = "specialty")
    private String specialty;

    @Column(name = "curse")
    private int curse;

    @Column(name = "studyForm")
    private String studyForm;

    @Column(name = "answer1")
    private String answer1;

    @Column(name = "answer2")
    private String answer2;

    public Survey() {
    }


    public String getInstitute() {
        return this.institute;
    }

    public void setInstitute(String value) {
        this.institute = value;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String value) {
        this.department = value;
    }

    public String getSpecialtyCode() {
        return this.specialtyCode;
    }

    public void setSpecialtyCode(String value) {
        this.specialtyCode = value;
    }

    public String getSpecialty() {
        return this.specialty;
    }

    public void setSpecialty(String value) {
        this.specialty = value;
    }

    public int getCurse() {
        return this.curse;
    }

    public void setCurse(int value) {
        this.curse = value;
    }

    public String getStudyForm() {
        return this.studyForm;
    }

    public void setStudyForm(String value) {
        this.studyForm = value;
    }

    public String getAnswer1() {
        return this.answer1;
    }

    public void setAnswer1(String value) {
        this.answer1 = value;
    }

    public String getAnswer2() {
        return this.answer2;
    }

    public void setAnswer2(String value) {
        this.answer2 = value;
    }
}