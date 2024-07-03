package com.rohit.showBookKaro.models;

import com.rohit.showBookKaro.models.enumerations.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CinemaHallSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int row;
    private  int col;
    private SeatType seatType;
}
