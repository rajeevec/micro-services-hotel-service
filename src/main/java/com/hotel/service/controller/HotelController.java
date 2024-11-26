package com.hotel.service.controller;

import com.hotel.service.entities.Hotel;
import com.hotel.service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")  // Base URL for all hotel-related requests
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // Add a new hotel (POST /hotels)
    @PostMapping
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
        try {
            Hotel savedHotel = hotelService.addHotel(hotel);  // Call service to save hotel
            return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);  // Return 201 CREATED
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);  // 500 Internal Server Error
        }
    }

    // Get a list of all hotels (GET /hotels)
    @GetMapping
    public ResponseEntity<List<Hotel>> hotelList() {
        try {
            List<Hotel> hotels = hotelService.hotelList();  // Call service to get list of hotels
            if (hotels.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // 204 No Content if list is empty
            }
            return new ResponseEntity<>(hotels, HttpStatus.OK);  // 200 OK with the list
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);  // 500 Internal Server Error
        }
    }

    // Get a hotel by its ID (GET /hotels/{hotelId})
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelByHotelId(@PathVariable Long hotelId) {
        try {
            Hotel hotel = hotelService.getHotelByHotelId(hotelId);  // Call service to get hotel by ID
            if (hotel == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // 404 Not Found if hotel is not found
            }
            return new ResponseEntity<>(hotel, HttpStatus.OK);  // 200 OK with the hotel data
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);  // 500 Internal Server Error
        }
    }

    // Delete a hotel by its ID (DELETE /hotels/{hotelId})
    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Hotel> deleteHotelByHotelId(@PathVariable Long hotelId) {
        try {
            Hotel hotel = hotelService.deleteHotelByHotelId(hotelId);  // Call service to delete hotel
            if (hotel == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // 404 Not Found if hotel is not found
            }
            return new ResponseEntity<>(hotel, HttpStatus.NO_CONTENT);  // 204 No Content for successful delete
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);  // 500 Internal Server Error
        }
    }
}
