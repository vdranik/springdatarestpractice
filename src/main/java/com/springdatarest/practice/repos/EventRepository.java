package com.springdatarest.practice.repos;

import com.springdatarest.practice.entities.Event;
import com.springdatarest.practice.entities.projections.PartialEventProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.time.ZoneId;
import java.util.List;

//http://localhost:8080/eventmanagement-api/events?size=5
//http://localhost:8080/eventmanagement-api/events?page=1&size=2
//spring.data.rest.default-page-size=5

//http://localhost:8080/eventmanagement-api/events?sort=id,desc,sort=name

@RepositoryRestResource(excerptProjection = PartialEventProjection.class)
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

    //http://localhost:8080/eventmanagement-api/events/search/findByName?name=Spring Data Rest
    //List<Event> findByName(@Param("name") String name);
    Page<Event> findByName(@Param("name") String name, Pageable pageable);

    //http://localhost:8080/eventmanagement-api/events/search/findByNameAndZoneId?name=1&zoneId=US/Central&page=0&size=2
    Page<Event> findByNameAndZoneId(@Param("name") String name, @Param("zoneId") ZoneId zoneId, Pageable pageable);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(Long id);
}
