package com.bmt.vendor.advice;

import com.common.exception.InvalidJwtSignatureException;
import com.common.exception.InvalidJwtTokenException;
import com.common.exception.InvalidVendorException;
import com.common.exception.VendorNotFoundException;
import com.common.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidJwtSignatureException.class)
    public ResponseEntity<ApiResponse<Void>> handleInvalidJwtSignatureException(InvalidJwtSignatureException ex, HttpServletRequest request) {
        Map<String, String> errorDetails = Map.of("reason", ex.getMessage());

        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(ApiResponse.failure("Invalid Signature", errorDetails, request.getRequestURI()));
    }

    @ExceptionHandler(InvalidJwtTokenException.class)
    public ResponseEntity<ApiResponse<Void>> handleInvalidJwtTokenException(InvalidJwtTokenException ex, HttpServletRequest request) {
        Map<String, String> errorDetails = Map.of("reason", ex.getMessage());

        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(ApiResponse.failure("Invalid Token", errorDetails, request.getRequestURI()));
    }

    @ExceptionHandler(VendorNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleVendorNotFoundException(VendorNotFoundException ex, HttpServletRequest request) {
        Map<String, String> errorDetails = Map.of("reason", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.failure("Vendor not Found", errorDetails, request.getRequestURI()));
    }

    @ExceptionHandler(InvalidVendorException.class)
    public ResponseEntity<ApiResponse<Void>> handleInvalidVendorException(InvalidVendorException ex, HttpServletRequest request) {
        Map<String, String> errorDetails = Map.of("reason", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.failure("Invalid Vendor", errorDetails, request.getRequestURI()));
    }

    /**
     * Method to handle incorrect arguments received in request body using validation framework
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        Map<String, String> errorDetails = Map.of("reason", ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.failure("Invalid Request Parameters", errorDetails, request.getRequestURI()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGenericException(Exception ex, HttpServletRequest request) {
        Map<String, String> errorDetails = Map.of("reason", ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.failure("An unexpected error occurred", errorDetails, request.getRequestURI()));
    }
}
