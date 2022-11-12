package com.tahir.artificialintelligence.models;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ValidFor{
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
}
