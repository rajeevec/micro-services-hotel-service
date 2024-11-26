package com.hotel.service.service;

import com.hotel.service.entities.Hotel;

import java.util.List;

public interface HotelService {

    public Hotel addHotel(Hotel hotel);

    public List<Hotel> hotelList();

    public Hotel getHotelByHotelId(Long hotelId);

    public Hotel deleteHotelByHotelId(Long hotelId);

}
