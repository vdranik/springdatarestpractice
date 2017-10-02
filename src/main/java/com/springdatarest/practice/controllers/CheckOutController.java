package com.springdatarest.practice.controllers;

import com.springdatarest.practice.entities.Participant;
import com.springdatarest.practice.exceptions.AlreadyCheckedException;
import com.springdatarest.practice.exceptions.NotCheckInException;
import com.springdatarest.practice.repos.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RepositoryRestController
@RequestMapping("/events")
public class CheckOutController {

    @Autowired
    private ParticipantRepository participantRepository;

    //http://localhost:8080/eventmanagement-api/events/checkout/1
    @PostMapping("/checkout/{id}")
    public ResponseEntity<PersistentEntityResource> checkOut(@PathVariable Long id, PersistentEntityResourceAssembler assembler){
        Participant participant = participantRepository.findOne(id);

        if(participant != null){
            if(participant.getCheckedIn()) {
                participant.setCheckedIn(false);
                participantRepository.save(participant);
            } else throw new NotCheckInException("Participant is not check in");
        }

        return ResponseEntity.ok(assembler.toResource(participant));
    }
}
