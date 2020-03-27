package com.borman.leastpicked.services;

import com.borman.leastpicked.modls.request.UpdateSelectionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SelectionService {


    public ResponseEntity<String> updateSelection(UpdateSelectionRequest request) {
        System.out.println(String.format("Updating user %s's pick to %s", request.getUserEmail(), request.getNewSelected()));



        return ResponseEntity.ok("Updated");

    }


}