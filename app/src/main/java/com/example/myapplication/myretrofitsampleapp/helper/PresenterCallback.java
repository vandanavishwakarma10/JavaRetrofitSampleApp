package com.example.myapplication.myretrofitsampleapp.helper;

public interface PresenterCallback<T> {
    void onSuccess(T objectClass);
    void onFailure(String failureMessage);
}
