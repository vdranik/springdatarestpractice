package com.springdatarest.practice.entities.projections;

import com.springdatarest.practice.entities.Venue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="virtual", types = {Venue.class})
public interface StreetAddressProjection {

    //http://localhost:8080/eventmanagement-api/venues?projection=virtual
    @Value("#{target.streetAddress} #{target.streetAddress2}")
    String getCompleteStreetAddress();
}
