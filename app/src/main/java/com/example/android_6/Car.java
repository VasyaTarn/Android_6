package com.example.android_6;

import android.os.Parcel;
import android.os.Parcelable;

public class Car implements Parcelable {
    private String brand;
    private String model;
    private int year;
    private String description;
    private double cost;
    private int imageResource;

    public Car(String brand, String model, int year, String description, double cost, int imageResource)
    {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.description = description;
        this.cost = cost;
        this.imageResource = imageResource;
    }

    protected Car(Parcel in)
    {
        brand = in.readString();
        model = in.readString();
        year = in.readInt();
        description = in.readString();
        cost = in.readDouble();
        imageResource = in.readInt();
    }

    public static final Creator<Car> CREATOR = new Creator<Car>()
    {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(brand);
        dest.writeString(model);
        dest.writeInt(year);
        dest.writeString(description);
        dest.writeDouble(cost);
        dest.writeInt(imageResource);
    }

    public String getBrand()
    {
        return brand;
    }

    public String getModel()
    {
        return model;
    }

    public int getYear()
    {
        return year;
    }

    public String getDescription()
    {
        return description;
    }

    public double getCost()
    {
        return cost;
    }

    public int getImageResource()
    {
        return imageResource;
    }
}
