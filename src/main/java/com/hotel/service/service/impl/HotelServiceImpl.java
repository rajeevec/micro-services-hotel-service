package com.hotel.service.service.impl;

import com.hotel.service.entities.Hotel;

import com.hotel.service.repository.HotelRepository;
import com.hotel.service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    private static final Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class); // Logger instance

    // Add a new hotel
    @Override
    public Hotel addHotel(Hotel hotel) {
        try {
            // Attempt to save the hotel to the database
            return hotelRepository.save(hotel);  // Will save the hotel and return the saved entity
        } catch (Exception e) {
            logger.error("Error occurred while adding hotel: ", e);  // Log the error
            throw new RuntimeException("Unable to add hotel due to an internal error.");
        }
    }

    // Get the list of all hotels
    @Override
    public List<Hotel> hotelList() {
        try {
            // Fetch all hotels from the database
            return hotelRepository.findAll();  // Will return a list of all hotels
        } catch (Exception e) {
            logger.error("Error occurred while retrieving hotels list: ", e);  // Log the error
            throw new RuntimeException("Unable to fetch hotels due to an internal error.");
        }
    }

    // Get a hotel by its ID
    @Override
    public Hotel getHotelByHotelId(Long hotelId) {
        try {
            // Check if a hotel with the given ID exists
            Optional<Hotel> hotelOptional = hotelRepository.findById(hotelId);
            // Return the hotel if found, otherwise throw an exception
            return hotelOptional.orElseThrow(() -> new RuntimeException("Hotel not found with ID: " + hotelId));
        } catch (Exception e) {
            logger.error("Error occurred while retrieving hotel with ID {}: ", hotelId, e);  // Log the error
            throw new RuntimeException("Unable to fetch hotel details due to an internal error.");
        }
    }

    // Delete a hotel by its ID
    @Override
    public Hotel deleteHotelByHotelId(Long hotelId) {
        try {
            // Fetch the hotel first
            Optional<Hotel> hotelOptional = hotelRepository.findById(hotelId);

            if (hotelOptional.isPresent()) {
                Hotel hotel = hotelOptional.get();
                hotelRepository.delete(hotel);  // Delete the hotel from the database
                return hotel;  // Return the deleted hotel
            } else {
                throw new RuntimeException("Hotel not found with ID: " + hotelId);  // Handle the case where hotel is not found
            }
        } catch (Exception e) {
            logger.error("Error occurred while deleting hotel with ID {}: ", hotelId, e);  // Log the error
            throw new RuntimeException("Unable to delete hotel due to an internal error.");
        }
    }
}
