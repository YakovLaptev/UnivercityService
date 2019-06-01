package soap.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;


@Entity
@Table(name = "specialty")
@Proxy(lazy = false)
public class Specialty {

    @Id
    @Column(name = "code", nullable = false, length = 10)
    private String code;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "shortName", length = 6)
    private String shortName;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 8)
    private SpecialtyType type;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public SpecialtyType getType() {
        return type;
    }

    public void setType(SpecialtyType type) {
        this.type = type;
    }

    public Specialty() {
    }

    public Specialty(String code, String name, String shortName, SpecialtyType type) {
        this.code = code;
        this.name = name;
        this.shortName = shortName;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", type=" + type +
                '}';
    }
}