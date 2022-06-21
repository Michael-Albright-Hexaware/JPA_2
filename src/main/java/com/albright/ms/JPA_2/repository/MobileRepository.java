package com.albright.ms.JPA_2.repository;

import com.albright.ms.JPA_2.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobileRepository extends JpaRepository<Mobile, Long> {
    /* examples of built queries */
//    List<Mobile> findByCompany(String mobileCompany);
//    List<Mobile> findByName(String mobileName);
//    List<Mobile> findByCompanyAndId(String mobileCompany, Long id);
//    List<Mobile> countByCompany(String mobileCompany);
//    List<Mobile> findByCompanyOrderById(String mobileCompany);
//    List<Mobile> deleteByCompany(String mobileCompany);

    /* CREATING YOUR OWN SCRATCH QUERIES */
        //JPQL
//    @Query("Select m From Mobile where mobile_name like 'Galaxy")
//    List<Mobile> mobilesNamedGalaxy();

    /* OR */
        // standard native SQL
//    @Query(value = "Select * From Mobile where mobile_name like 'Iphone'")
//    List<Mobile> getAllIPhones();

    /* OR */
    // if you have previously created any @NamedQuery you can run them here as well.
//    @Query(name = "query_get_pixels") //this query would have to be previously defined in Mobile.class!!
//    List<Mobile> getAllPixels();






}
