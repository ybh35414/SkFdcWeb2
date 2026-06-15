package com.hynix.fdcTest.dto;


import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class SensorValueList1Dto {
	private String sensorId;
	private double value;
	
	// 오라클의 DATE 형식을 그대로 받아서 넘길때 변환한다.
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime timestamp;
	private String lotId;
}
