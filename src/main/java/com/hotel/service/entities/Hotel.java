package com.hotel.service.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hotels") // Specifies the table name in the database
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the hotelId
    @Column(name = "hotel_id") // Optional, explicitly specifying the column name
    private Long hotelId;

    @Column(name = "hotel_name") // Maps to "hotel_name" column in the table
    private String hotelName;

    @Column(name = "hotel_location") // Maps to "hotel_location" column in the table
    private String hotelLocation;

    @Column(name = "hotel_about") // Maps to "hotel_about" column in the table
    private String hotelAbout;

    // Getter and Setter for hotelId
    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    // Getter and Setter for hotelName
    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    // Getter and Setter for hotelLocation
    public String getHotelLocation() {
        return hotelLocation;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }

    // Getter and Setter for hotelAbout
    public String getHotelAbout() {
        return hotelAbout;
    }

    public void setHotelAbout(String hotelAbout) {
        this.hotelAbout = hotelAbout;
    }
}
