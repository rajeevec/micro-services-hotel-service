package com.hotel.service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/staffs")
public class StaffsController {
    @GetMapping
    public ResponseEntity<?> staffList() {
        try {
            Map<String, Object> staffList = new HashMap<>();
            staffList.put("name", "Rajeev Kumar");
            staffList.put("email", "rajeevec75@gmail.com");
            staffList.put("mobileNumber", "9523563421");
            return ResponseEntity.ok(staffList);
        } catch (Exception e) {
            // Handle exception and return a meaningful response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while fetching the staff list.");
        }
    }

}
