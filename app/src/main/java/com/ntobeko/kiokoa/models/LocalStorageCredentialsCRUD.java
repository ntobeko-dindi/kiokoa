package com.ntobeko.kiokoa.models;

import com.ntobeko.kiokoa.Abstract.LocalStorage;

import java.util.ArrayList;

public class LocalStorageCredentialsCRUD extends LocalStorage {

    private Credential credential;

    public LocalStorageCredentialsCRUD(Credential credential){
        this.credential = credential;
    }

    @Override
    public boolean Write(Object credential) {

        if(credential == null)
            return false;




        return true;
    }

    @Override
    public ArrayList<Credential> ReadAll() {
        return null;
    }

    @Override
    public Credential ReadByIndex() {
        return null;
    }
}
