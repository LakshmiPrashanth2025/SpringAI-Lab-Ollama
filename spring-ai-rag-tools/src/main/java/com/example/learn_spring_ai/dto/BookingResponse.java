package com.example.learn_spring_ai.dto;


import java.time.Instant;

import com.example.learn_spring_ai.entity.BookingStatus;

public record BookingResponse(Long id, String destination, Instant departureTime, BookingStatus status) {}