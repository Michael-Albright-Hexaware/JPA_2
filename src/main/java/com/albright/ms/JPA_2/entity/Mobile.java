package com.albright.ms.JPA_2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

// SINGLE_TABLE-> *BEST FOR PERFORMANCE* *SOME COLUMNS CAN BE NULL :(* one table holds all mobiles
// TABLE_PER_CLASS-> *REPEATING COLUMNS, DON'T USE** splits up purchase and lease to their own tables
// JOINED-> *BEST FOR DATA INTEGRITY* ALL VALUES ARE ONLY PRESENT ONCE, ALL COLUMNS CAN BE NULLABLE = FALSE
    // mobile, purchase, and lease will all have their own tables,
    // each table holds only columns from their entity meaning the common columns will be in the super table
    // and the to others will be in their respected tables.
    // finally, you would have to use a join query to get all the details together
//Another option for setting up the tables is to use @MappedSuperClass. *REPEATING COLUMNS, DONT USE*
    // there will be no Mobile class
    // the two tables (purchase, lease) will not be tied together,
    // they will only share information from the Super Class
@Inheritance(strategy = InheritanceType.JOINED)

// names the column that will tell me the type of payment, default = 'dtype'
@DiscriminatorColumn(name = "payment_type")
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

    @Column(name = "mobile_company", nullable = false)
    private String mobileCompany;

    @Column(name = "mobile_name", nullable = false)
    private String mobileName;

    @JsonIgnore
    @OneToMany(mappedBy = "mobile")
    private Set<App> apps = new HashSet<>();

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;


    public Mobile(String mobileCompany, String mobileName) {
        this.mobileCompany = mobileCompany;
        this.mobileName = mobileName;
    }

    public void addNewApp(App app) {
        this.apps.add(app);
    }

    }

