package com.springdatarest.practice.repos;

import com.springdatarest.practice.entities.Event;
import com.springdatarest.practice.entities.Organizer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OreganizerRepository extends PagingAndSortingRepository<Organizer, Long> {
}
