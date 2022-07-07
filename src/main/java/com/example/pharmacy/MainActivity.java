package com.example.pharmacy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pharmacy.Service.CustomerAPI;
import com.example.pharmacy.Service.RetrofitService;
import com.example.pharmacy.model.Customer;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();

    }
    private void initializeComponents(){
        EditText ID = findViewById(R.id.id);
        EditText name = findViewById(R.id.Name);
        EditText email =findViewById(R.id.email);
        EditText medicine = findViewById(R.id.medicine);
        Button submit = findViewById(R.id.button);

        RetrofitService retrofitService = new RetrofitService();
        CustomerAPI customerAPI = retrofitService.getRetrofit().create(CustomerAPI.class);

        submit.setOnClickListener(view -> {
            String Id = String.valueOf(ID.getText());
            String Name = String.valueOf(name.getText());
            String Email = String.valueOf(email.getText());
            String Medicine = String.valueOf(R.id.medicine);

            Customer customer = new Customer();
            customer.setName(Name);
            customer.setEmail(Email);
            customer.setMedicine(Medicine);

            customerAPI.save(customer)
                    .enqueue(new Callback<Customer>() {
                        @Override
                        public void onResponse(Call<Customer> call, Response<Customer> response) {
                            Toast.makeText(MainActivity.this, "save successful", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Customer> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "save failed!!!", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "Error occurred",t);

                        }
                    });

        });


        }
}