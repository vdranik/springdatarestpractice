package com.springdatarest.practice.entities.projections;

import com.springdatarest.practice.entities.Event;
import org.springframework.data.rest.core.config.Projection;

import java.time.Instant;
import java.time.ZonedDateTime;

@Projection(name="partial", types = {Event.class})
public interface PartialEventProjection {

    //http://localhost:8080/eventmanagement-api/events/17?projection=partial

    String getName();
    ZonedDateTime getStartTime();
    ZonedDateTime getEndTime();
    //over JsonIgnore 'created' field
    Instant getCreated();

}
