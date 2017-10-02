package com.springdatarest.practice.entities.projections;

import com.springdatarest.practice.entities.Event;
import com.springdatarest.practice.entities.Participant;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="participantPartial", types = {Participant.class})
public interface PartialParticipantProjection {

    //http://localhost:8080/eventmanagement-api/participants?projection=participantPartial
    String getName();
    Boolean getCheckedIn();
}
