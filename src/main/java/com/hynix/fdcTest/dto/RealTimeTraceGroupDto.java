package com.hynix.fdcTest.dto;

import java.util.List;
import lombok.Data;

@Data
// 초단위 그룹 래퍼 DTO
public class RealTimeTraceGroupDto {
	// List 분리 기준
	private String timestamp;
	
	// 그룹내 마지막 Data_Id
	private Long rawDataOid;
	
	private String eqpId;
	private String currentRecipe;
	
	// 동일 timestamp내 센서 데이터
	private List<SvidReadingDto> readings;
}
