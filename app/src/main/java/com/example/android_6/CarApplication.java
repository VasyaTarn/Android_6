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
        carList.add(new Car("Toyota", "Camry", 2019, "Прекрасне авто", 20000.0, R.drawable.camry));
        carList.add(new Car("Ford", "Focus", 2018, "Добре авто для міста", 15000.0, R.drawable.focus));
        carList.add(new Car("Honda", "Civic", 2020, "Надійне авто з невеликим пробігом", 18000.0, R.drawable.civic));
        carList.add(new Car("Chevrolet", "Malibu", 2017, "Комфортний седан з просторим салоном", 16000.0, R.drawable.malibu));
        carList.add(new Car("BMW", "3 Series", 2019, "Спортивний автомобіль преміум-класу", 25000.0, R.drawable.bmw_3_series));
        carList.add(new Car("Audi", "A4", 2021, "Стильний і швидкий", 30000.0, R.drawable.audi_a4));
        carList.add(new Car("Mercedes-Benz", "C-Class", 2018, "Преміальний автомобіль з високим комфортом", 28000.0, R.drawable.mercedes_c_class));
        carList.add(new Car("Nissan", "Altima", 2020, "Економічний і надійний", 22000.0, R.drawable.nissan_altima));
        carList.add(new Car("Hyundai", "Elantra", 2019, "Зручний для міста", 17000.0, R.drawable.hyundai_elantra));
        carList.add(new Car("Kia", "Optima", 2017, "Доступний седан з хорошим дизайном", 15000.0, R.drawable.kia_optima));
    }

    public List<Car> getCarList()
    {
        return carList;
    }
}
