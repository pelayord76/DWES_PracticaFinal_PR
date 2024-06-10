package com.spring.start.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/logs")
@Slf4j
public class LogController {

	@GetMapping("/info")
    public ResponseEntity<?> logInfo() {
        log.info("Esto es un log tipo info.");
        return ResponseEntity.ok("Esto es un log tipo info.");
    }

    @GetMapping("/error")
    public ResponseEntity<?> logError() {
        log.error("Esto es un log tipo error.");
        return ResponseEntity.ok("Esto es un log tipo error.");
    }

    @GetMapping("/debug")
    public ResponseEntity<?> logDebug() {
        log.debug("Esto es un log tipo debug.");
        return ResponseEntity.ok("Esto es un log tipo debug.");
    }
}
