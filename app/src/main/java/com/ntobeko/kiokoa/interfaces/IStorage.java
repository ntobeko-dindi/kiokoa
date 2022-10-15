package com.ntobeko.kiokoa.interfaces;

import com.ntobeko.kiokoa.models.Credential;

import java.util.ArrayList;

public interface IStorage <E,T> {
    boolean writeData(E data);
    boolean deleteData(E data);
    T getData();
}