package com.ntobeko.kiokoa.interfaces;

import java.util.ArrayList;

public interface IStorage <E> {
    boolean Write(E credential);
    ArrayList<E> ReadAll();
    E ReadByIndex();
}