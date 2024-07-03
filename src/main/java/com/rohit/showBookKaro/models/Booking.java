package com.rohit.showBookKaro.models;

import com.rohit.showBookKaro.models.enumerations.BookingStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Booking {
    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;


    private int no_of_seats;
    private BookingStatus bookingStatus;

    private LocalDate bookedOn;

}
