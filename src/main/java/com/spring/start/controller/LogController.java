package com.spring.start.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.start.dto.ApiResponse;
import com.spring.start.util.ResponseUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/log")
@Slf4j
public class LogController {

	@GetMapping("/info")
	public ResponseEntity<ApiResponse<Object>> logInfo() {
		log.info("Esto es un log tipo info.");
		return ResponseUtil.response(null, HttpStatus.OK, "Esto es un log de tipo info");
	}

	@GetMapping("/error")
	public ResponseEntity<ApiResponse<Object>> logError() {
		log.error("Esto es un log tipo error.");
		return ResponseUtil.response(null, HttpStatus.OK, "Esto es un log de tipo error");
	}

	@GetMapping("/debug")
	public ResponseEntity<ApiResponse<Object>> logDebug() {
		log.debug("Esto es un log tipo debug.");
		return ResponseUtil.response(null, HttpStatus.OK, "Esto es un log de tipo debug");
	}
}
