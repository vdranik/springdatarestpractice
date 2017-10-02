package com.springdatarest.practice.repos;

import com.springdatarest.practice.entities.Venue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VenueRepository extends PagingAndSortingRepository<Venue, Long> {

    List<Venue> findByPostalCode(@Param("postalCode") String postalCode);

    //or
    //Page<Venue> findByPostalCode(@Param("postalCode") String postalCode, Pageable pageable);
}
