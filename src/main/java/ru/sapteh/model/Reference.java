package ru.sapteh.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "References")
public class Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int referencesID;

    @Column(name = "datereference")
    @NonNull
    private String dateReference;

    @Column(name = "diagnose")
    @NonNull
    private String diagnose;

    @Column(name = "cost")
    @NonNull
    private String cost;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Patients_id")
    private Patient patient;

    @Override
    public String toString() {
        return "Reference{" +
                "referencesID=" + referencesID +
                ", dateReference='" + dateReference + '\'' +
                ", diagnose='" + diagnose + '\'' +
                ", cost='" + cost + '\'' +
                ", patients=" + patient +
                '}';
    }
}
