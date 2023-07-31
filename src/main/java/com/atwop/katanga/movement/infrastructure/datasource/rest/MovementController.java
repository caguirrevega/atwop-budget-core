package com.atwop.katanga.movement.infrastructure.datasource.rest;

import com.atwop.katanga.movement.model.MovementInputBoundary;
import com.atwop.katanga.movement.model.MovementRequestModel;
import com.atwop.katanga.movement.model.MovementResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MovementController {

    private final MovementInputBoundary movementInputBoundary;

    @PostMapping("/movement")
    public MovementResponseModel create(@RequestBody MovementRequestModel requestModel){
        return movementInputBoundary.create(requestModel);
    }
}
