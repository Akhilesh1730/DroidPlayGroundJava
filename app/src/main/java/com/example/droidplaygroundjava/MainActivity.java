package com.example.droidplaygroundjava;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ContactModel;
import com.example.db.DBOpenHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBOpenHelper helper = new DBOpenHelper(this);
        helper.addContacts("akhi1", "9876543");
        helper.addContacts("akhi2", "9876544");
        helper.addContacts("akhi3", "9876545");
        helper.addContacts("akhi4", "9876546");
        helper.addContacts("akhi5", "9876547");


        //helper.updateContacts(new ContactModel(1, "akhi1", "9876543"));

        helper.deleteContacts(new ContactModel(1, "akhi1", "9876543"));
        List<ContactModel> contactList = helper.getContacts();

        for (ContactModel model : contactList) {
            Log.d("###", "onCreate: " + model.getId() + " " + model.getName() + " " + model.getPhone_no());
        }
    }
}