package com.borman.leastpicked.services;

import com.borman.leastpicked.modls.request.UpdateSelectionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SelectionService {

    private Logger logger = LoggerFactory.getLogger(SelectionService.class);

    public ResponseEntity<String> updateSelection(UpdateSelectionRequest request) {
        logger.info("Updating user {}'s pick to {}", request.getUserEmail(), request.getNewSelected());
        return ResponseEntity.ok("Updated");
    }

}