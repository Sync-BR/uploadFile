package com.uploadFile.uploadFile.service.interfaces;

public interface ServiceInterface<T> {
    void save(T dto);
    void delete(T dto);
    T update(T dto);
}
