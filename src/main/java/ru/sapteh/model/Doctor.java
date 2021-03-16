package ru.sapteh.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "Doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int doctorID;

    @NonNull
    @Column(name = "lastname")
    private String lastName;

    @NonNull
    @Column(name = "firstname")
    private String firstName;

    @NonNull
    @Column(name = "patronymic")
    private String patronymic;

    @NonNull
    @Column(name = "speciality")
    private String speciality;

    @NonNull
    @Column(name = "category")
    private String category;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Doctors_has_Patients",
        joinColumns = @JoinColumn(name = "Doctors_id"),
        inverseJoinColumns = @JoinColumn(name = "Patients_id")
    )
    private Set<Patient> patientSet;

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorID=" + doctorID +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", speciality='" + speciality + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}