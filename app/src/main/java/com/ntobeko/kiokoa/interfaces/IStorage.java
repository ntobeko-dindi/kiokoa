package com.ntobeko.kiokoa.interfaces;

import com.ntobeko.kiokoa.models.Credential;

import java.util.ArrayList;

public interface IStorage <E,T,P> {
    boolean writeData(E data);
    boolean deleteData(P key);
    T getData();
    T getDataById(String id);
}