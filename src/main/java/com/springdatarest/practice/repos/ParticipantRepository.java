package com.springdatarest.practice.repos;

import com.springdatarest.practice.entities.Organizer;
import com.springdatarest.practice.entities.Participant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParticipantRepository extends PagingAndSortingRepository<Participant, Long> {

    List<Participant> findByIdAndEmail(@Param("id") Long id, @Param("email") String email);

    //or
    //Page<Participant> findByIdAndEmail(@Param("id") Long id, @Param("email") String email, Pageable pageable);
}
