package ru.sapteh.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "Patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int patientID;

    @NonNull
    @Column(name = "lastname")
    private String lastName;

    @NonNull
    @Column(name = "firstname")
    private String firstName;

    @NonNull
    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "birthday")
    private String birthday;

    @ManyToMany(mappedBy = "Patients")
    private Set<Doctor> doctorSet;

    @Override
    public String toString() {
        return "Patient{" +
                "patientID=" + patientID +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
