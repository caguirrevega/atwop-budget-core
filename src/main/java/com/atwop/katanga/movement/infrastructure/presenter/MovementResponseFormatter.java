package com.atwop.katanga.movement.infrastructure.presenter;

import com.atwop.katanga.movement.model.MovementPresenter;
import com.atwop.katanga.movement.model.MovementResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MovementResponseFormatter implements MovementPresenter {
    @Override
    public MovementResponseModel prepareSuccessfulResponse(String id, Float amount) {
        return new MovementResponseModel(id, amount);
    }

    @Override
    public MovementResponseModel prepareBadRequestResponse(String error) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, error);
    }

    @Override
    public MovementResponseModel prepareNotFoundResponse(String error) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, error);
    }
}
