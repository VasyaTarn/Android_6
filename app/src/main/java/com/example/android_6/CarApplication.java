package com.example.android_6;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class CarApplication extends Application {
    private List<Car> carList;

    @Override
    public void onCreate() {
        super.onCreate();
        carList = new ArrayList<>();
        carList.add(new Car("Toyota", "Camry", 2019, "desc1", 20000.0, R.drawable.camry));
        carList.add(new Car("Ford", "Focus", 2018, "desc2", 15000.0, R.drawable.focus));
        carList.add(new Car("Honda", "Civic", 2020, "desc3", 18000.0, R.drawable.civic));
        carList.add(new Car("Chevrolet", "Malibu", 2017, "desc4", 16000.0, R.drawable.malibu));
        carList.add(new Car("BMW", "3 Series", 2019, "desc5", 25000.0, R.drawable.bmw_3_series));
        carList.add(new Car("Audi", "A4", 2021, "desc6", 30000.0, R.drawable.audi_a4));
        carList.add(new Car("Mercedes-Benz", "C-Class", 2018, "desc7", 28000.0, R.drawable.mercedes_c_class));
        carList.add(new Car("Nissan", "Altima", 2020, "desc8", 22000.0, R.drawable.nissan_altima));
        carList.add(new Car("Hyundai", "Elantra", 2019, "desc9", 17000.0, R.drawable.hyundai_elantra));
        carList.add(new Car("Kia", "Optima", 2017, "desc10", 15000.0, R.drawable.kia_optima));
    }

    public List<Car> getCarList()
    {
        return carList;
    }
}
