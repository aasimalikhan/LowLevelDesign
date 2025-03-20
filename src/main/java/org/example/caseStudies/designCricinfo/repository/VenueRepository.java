package org.example.caseStudies.designCricinfo.repository;

import org.example.caseStudies.designCricinfo.exceptions.DuplicateEntityException;
import org.example.caseStudies.designCricinfo.exceptions.EntityNotFoundException;
import org.example.caseStudies.designCricinfo.models.Venue;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class VenueRepository {
    private final Map<String, Venue> venueStore;
    private final AtomicInteger idCounter = new AtomicInteger(0);

    private static VenueRepository venueRepository;

    public static VenueRepository getInstance()
    {
        if(venueRepository == null)
        {
            synchronized (VenueRepository.class)
            {
                venueRepository = new VenueRepository();
            }
        }
        return venueRepository;
    }

    private VenueRepository() {
        this.venueStore = new HashMap<>();
    }

    public Venue save(Venue venue) {
        if(venue.getVenueId() != null && venueStore.containsKey(venue.getVenueId())) {
            throw new DuplicateEntityException("Venue", venue.getVenueId());
        }

        if(venue.getVenueId() == null) {
            String id = "VENUE-" + idCounter.incrementAndGet();
            venue.setVenueId(id);
        }

        venueStore.put(venue.getVenueId(), venue);
        return venue;
    }

    public Optional<Venue> findById(String venueId) {
        return Optional.ofNullable(venueStore.get(venueId));
    }

    public Venue getById(String venueId) {
        return findById(venueId).orElseThrow(() -> new EntityNotFoundException("Venue", venueId));
    }

    public Venue update(Venue venue) {
        if(venue.getVenueId() == null || !venueStore.containsKey(venue.getVenueId())) {
            throw new EntityNotFoundException("Venue", venue.getVenueId() == null ? "null" : venue.getVenueId());
        }

        venueStore.put(venue.getVenueId(), venue);
        return venue;
    }

    public void deleteById(String venueId) {
        if(!venueStore.containsKey(venueId)) {
            throw new EntityNotFoundException("Venue", venueId);
        }
        venueStore.remove(venueId);
    }

    public boolean existsById(String venueId) {
        return venueStore.containsKey(venueId);
    }

    public List<Venue> findAll() {
        return new ArrayList<>(venueStore.values());
    }

    public List<Venue> findByLocation(String location) {
        return venueStore.values().stream()
                .filter(venue -> venue.getLocation().equals(location))
                .toList();
    }

    public List<Venue> findByPitchType(String pitchType) {
        return venueStore.values().stream()
                .filter(venue -> venue.getPitchType().equals(pitchType))
                .toList();
    }

    public List<Venue> findByMinimumCapacity(int minCapacity) {
        return venueStore.values().stream()
                .filter(venue -> venue.getCapacity() >= minCapacity)
                .toList();
    }

    public Optional<Venue> findByName(String venueName) {
        return venueStore.values().stream()
                .filter(venue -> venue.getVenueName().equals(venueName))
                .findFirst();
    }
}