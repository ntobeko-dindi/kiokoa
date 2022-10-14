package com.ntobeko.kiokoa.Abstract;

import com.ntobeko.kiokoa.interfaces.IStorage;

import java.util.ArrayList;

public abstract class LocalStorage<E> implements IStorage {

    @Override
    public abstract ArrayList<E> ReadAll();

    @Override
    public abstract Object ReadByIndex();
}
