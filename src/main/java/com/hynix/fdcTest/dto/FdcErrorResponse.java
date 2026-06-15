package com.hynix.fdcTest.dto;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@Builder
public class FdcErrorResponse {
	// ec 1.11
	private LocalDateTime timeStamp; // 에러발생식간
	private int status; // HTTP 상태 코드
	private String errorType; // 에러 종류
	private String message; // 상세에러
	private String path; // 요청했던 API 경로
}
