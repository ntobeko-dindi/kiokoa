package com.ntobeko.kiokoa.data;

import android.database.Cursor;

import com.ntobeko.kiokoa.interfaces.IStorage;
import com.ntobeko.kiokoa.models.Credential;

public class FireBaseHelper implements IStorage<Credential, Cursor,String> {
    @Override
    public boolean writeData(Credential data) {
        return false;
    }

    @Override
    public boolean deleteData(String key) {
        return false;
    }

    @Override
    public Cursor getData() {
        return null;
    }

    @Override
    public Cursor getDataById(String id) {
        return null;
    }
}
