package com.hynix.fdcTest.exception;


import com.hynix.fdcTest.dto.FdcErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 분기점 1: InvalidSvidFormatException이 발생했을 때 여기로 옴!
    @ExceptionHandler(InvalidSvidFormatException.class)
    public ResponseEntity<FdcErrorResponse> handleSvidError(InvalidSvidFormatException ex, HttpServletRequest request) {
        log.warn("SVID 파싱 에러: {}", ex.getMessage());
        return createResponse(ex.getErrorType(), ex.getMessage(), request, HttpStatus.BAD_REQUEST);
    }

    // 분기점 2: RecipeNotFoundException이 발생했을 때 여기로 옴!
    @ExceptionHandler(RecipeNotFoundException.class)
    public ResponseEntity<FdcErrorResponse> handleRecipeError(RecipeNotFoundException ex, HttpServletRequest request) {
        log.warn("레시피 조회 에러: {}", ex.getMessage());
        // 레시피가 없는 건 서버 쪽 세팅 문제일 수 있으므로 404 상태코드 반환
        return createResponse(ex.getErrorType(), ex.getMessage(), request, HttpStatus.NOT_FOUND);
    }

    // 분기점 3: 위 1, 2번에서 정의하지 않은 다른 'FdcBusinessException'의 자식들이 발생하면 여기로 옴! (포괄적 처리)
    @ExceptionHandler(FdcBusinessException.class)
    public ResponseEntity<FdcErrorResponse> handleGeneralBusinessError(FdcBusinessException ex, HttpServletRequest request) {
        log.error("기타 FDC 비즈니스 로직 에러: {}", ex.getMessage());
        return createResponse(ex.getErrorType(), ex.getMessage(), request, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 분기점 4: 최후의 보루 (NullPointerException 등 모든 예외의 부모인 Exception이 발생하면 여기로 옴!)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<FdcErrorResponse> handleAllExceptions(Exception ex, HttpServletRequest request) {
        log.error("예상치 못한 시스템 에러", ex);
        return createResponse("SYSTEM_ERROR", "알 수 없는 에러가 발생했습니다.", request, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 응답 객체 생성을 도와주는 공통 메서드
    private ResponseEntity<FdcErrorResponse> createResponse(String type, String message, HttpServletRequest request, HttpStatus status) {
        FdcErrorResponse response = FdcErrorResponse.builder()
                .timeStamp(LocalDateTime.now())
                .status(status.value())
                .errorType(type)
                .message(message)
                .path(request.getRequestURI())
                .build();
        return new ResponseEntity<>(response, status);
    }
}
