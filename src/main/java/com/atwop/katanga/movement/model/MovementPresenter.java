package com.atwop.katanga.movement.model;

public interface MovementPresenter {
    MovementResponseModel prepareSuccessfulResponse(String id, Float amount);
    MovementResponseModel prepareBadRequestResponse(String error);

    MovementResponseModel prepareNotFoundResponse(String error);
}
