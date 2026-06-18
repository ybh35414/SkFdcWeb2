package com.hynix.fdcTest.dto;

import lombok.Data;

@Data
// 센서데이터 DTO
public class SvidReadingDto {
	private String svid;          // 센서 ID (SENSOR_ID)
    private String svidName;      // 센서명 (SENSOR_NAME)
    private Double svalue;        // 현재 측정값 (RAW_VALUE)
    private Double average;       // 공정 평균치 (MEAN_VALUE)
    private Double ucl;           // SPC 상한선 (UCL_VALUE)
    private Double lcl;           // SPC 하한선 (LCL_VALUE)
}
