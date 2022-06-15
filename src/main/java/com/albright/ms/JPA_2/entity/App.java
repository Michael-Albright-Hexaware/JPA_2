package com.albright.ms.JPA_2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class App {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(name = "app_name")
    private String appName;

    @JoinColumn(name = "mobile_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Mobile mobile;

    public App(String appName) {
        this.appName = appName;
    }
}
