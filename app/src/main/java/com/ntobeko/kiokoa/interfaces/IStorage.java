package com.ntobeko.kiokoa.interfaces;

public interface IStorage <E,T,P> {
    boolean writeData(E data);
    boolean deleteData(P key);
    T getData();
    T getDataById(String id);
}