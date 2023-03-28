package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is the class to add new city or delete existing cities and count the number of city
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This will add a new city to the list if that city does not exist in the list
     * @param city
     *      the city to add we want to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list of cities
     */
    public List<City> getCities(int flag) {
        List<City> cityList = cities;
        if(flag==1){
            Collections.sort(cityList);
        }
        else
        {
            Collections.sort(cityList, new Comparator<City>() {
                @Override
                public int compare(City city, City t1) {
                    return city.getProvinceName().compareTo(t1.getProvinceName());
                }
            });
        }
        return cityList;
    }

    /**
     * this method will delete a existing city from the list
     * @param city
     *      the city we want to delete
     */

    public void Delete(City city){
        if(!cities.contains(city)){
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * count the total number of city
     * @return
     *      number of city in the list
     */

    public int count(){
        return cities.size();
    }
}
