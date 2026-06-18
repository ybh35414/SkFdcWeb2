package com.hynix.fdcTest.dto;

import lombok.Data;

@Data
public class EquipmentChamberDto {
	private String eqpId;		// 장비 아이디
	private String chamberId;	// 챔버 아이디
	private String status;		// 상태 RUN, IDLE, FAULT
}
