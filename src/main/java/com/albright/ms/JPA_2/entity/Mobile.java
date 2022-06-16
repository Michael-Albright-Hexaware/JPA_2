package com.albright.ms.JPA_2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Mobile {

    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    private Long id;

    @Column(name = "mobile_company")
    private String mobileCompany;

    @Column(name = "mobile_name")
    private String mobileName;

    @JsonIgnore
    @OneToMany(mappedBy = "mobile")
    private Set<App> apps = new HashSet<>();

    public Mobile(String mobileCompany, String mobileName) {
        this.mobileCompany = mobileCompany;
        this.mobileName = mobileName;
    }

    public void addNewApp(App app) {
        this.apps.add(app);
    }

    }

