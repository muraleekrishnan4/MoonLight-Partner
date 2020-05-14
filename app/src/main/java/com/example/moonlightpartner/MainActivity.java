package com.example.moonlightpartner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements Runnable{

    RecyclerView recyclerView;
    MyListAdapter adapter;

    ArrayList<MyListData> myListData;

    FirebaseFirestore db;

    static TextView txt_no_orders;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txt_no_orders = findViewById(R.id.txt_no_orders);
        recyclerView = findViewById(R.id.recyclerview);
        db = FirebaseFirestore.getInstance();


        myListData = new ArrayList<>();

        getData();


        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        adapter = new MyListAdapter(myListData,getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    private void getData() {

        db.collection("order").document("orderMain").collection("orderDetails")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            ArrayList<MyListData> list = new ArrayList<>();

                            for (QueryDocumentSnapshot doc : task.getResult()) {
                                String name = doc.getString("customerName");
                                String address = doc.getString("customerAddress");
                                String number = doc.getString("customerNumber");
                                int orderID = doc.getLong("orderID").intValue();
                                List<String> foodID = (List<String>) doc.get("foodID");
                                List<String> foodQuantity = (List<String>) doc.get("foodQuantity");

                                MyListData order = new MyListData(name,address,number,foodID,foodQuantity,orderID);
                                list.add(order);
                            }

                            adapter = new MyListAdapter(list,getApplicationContext());
                            recyclerView.setAdapter(adapter);
                        }
                    }

                });
    }

    @Override
    public void run() {
        getData();
    }
}
