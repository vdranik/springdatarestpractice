package com.springdatarest.practice.controllers;

import com.springdatarest.practice.entities.Participant;
import com.springdatarest.practice.exceptions.AlreadyCheckedException;
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
public class CheckInController {

    @Autowired
    private ParticipantRepository participantRepository;

    @PostMapping("/checkin/{id}")
    public ResponseEntity<PersistentEntityResource> checkIn(@PathVariable Long id, PersistentEntityResourceAssembler assembler){
        Participant participant = participantRepository.findOne(id);

        if(participant != null){
            if(participant.getCheckedIn()) {
                throw new AlreadyCheckedException();
            }

            participant.setCheckedIn(true);
            participantRepository.save(participant);
        }

        return ResponseEntity.ok(assembler.toResource(participant));
    }
}
