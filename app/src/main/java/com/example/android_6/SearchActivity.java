package com.example.android_6;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private AutoCompleteTextView brandTextView, modelTextView;
    private Spinner yearFromSpinner, yearToSpinner;
    private EditText priceFromEditText, priceToEditText;
    private Button matchesButton;
    private List<Car> filteredCars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search);

        brandTextView = findViewById(R.id.brandTextView);
        modelTextView = findViewById(R.id.modelTextView);
        yearFromSpinner = findViewById(R.id.yearFromSpinner);
        yearToSpinner = findViewById(R.id.yearToSpinner);
        priceFromEditText = findViewById(R.id.priceFromEditText);
        priceToEditText = findViewById(R.id.priceToEditText);
        matchesButton = findViewById(R.id.matchesButton);

        CarApplication app = (CarApplication) getApplication();
        List<Car> carList = app.getCarList();

        Log.d("List cars", "cars:");
        for (Car car : carList) {
            Log.d("Car", car.getBrand());
        }

        initializeYearSpinners();

        matchesButton.setOnClickListener(v -> {
            filterCars(carList);
            Log.d("SearchActivity", "Button is pressed");
            if (!filteredCars.isEmpty())
            {
                Log.d("Test", "test");
                Intent intent = new Intent();
                intent.putParcelableArrayListExtra("filteredCars", new ArrayList<>(filteredCars));
                setResult(RESULT_OK, intent);
                finish();
            }
            else
            {
                Toast.makeText(SearchActivity.this, "Автомобили не найдены", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void filterCars(List<Car> carList)
    {
        filteredCars = new ArrayList<>();

        String selectedBrand = brandTextView.getText().toString().trim();
        String selectedModel = modelTextView.getText().toString().trim();
        String yearFromStr = yearFromSpinner.getSelectedItem().toString();
        String yearToStr = yearToSpinner.getSelectedItem().toString();
        String priceFromStr = priceFromEditText.getText().toString().trim();
        String priceToStr = priceToEditText.getText().toString().trim();

        Integer yearFrom = yearFromStr.isEmpty() ? null : Integer.parseInt(yearFromStr);
        Integer yearTo = yearToStr.isEmpty() ? null : Integer.parseInt(yearToStr);
        Double priceFrom = priceFromStr.isEmpty() ? null : Double.parseDouble(priceFromStr);
        Double priceTo = priceToStr.isEmpty() ? null : Double.parseDouble(priceToStr);

        for (Car car : carList)
        {
            boolean matches = true;

            if (!selectedBrand.isEmpty() && !car.getBrand().equalsIgnoreCase(selectedBrand))
            {
                matches = false;
            }

            if (!selectedModel.isEmpty() && !car.getModel().equalsIgnoreCase(selectedModel))
            {
                matches = false;
            }

            if (yearFrom != null && car.getYear() < yearFrom)
            {
                matches = false;
            }
            if (yearTo != null && car.getYear() > yearTo)
            {
                matches = false;
            }

            if (priceFrom != null && car.getCost() < priceFrom)
            {
                matches = false;
            }
            if (priceTo != null && car.getCost() > priceTo)
            {
                matches = false;
            }

            if (matches)
            {
                filteredCars.add(car);
            }
        }
    }

    private void initializeYearSpinners()
    {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        List<Integer> years = new ArrayList<>();
        for (int year = currentYear; year >= 1900; year--)
        {
            years.add(year);
        }

        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, years);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        yearFromSpinner.setAdapter(adapter);
        yearToSpinner.setAdapter(adapter);
    }
}