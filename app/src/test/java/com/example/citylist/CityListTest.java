package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * this class will test the methods
 */

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("jossore", "khulna");
    }

    /**
     * this method will test the add method
     */

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("mirpur", "dhaka");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }

    /**
     * this method will test whether an exception is generated if we add a city that already exist in the list
     */

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * method to test the different types of sorting
     */

    @Test
    public void testGetCities() {
        CityList cityList = new CityList();
        City city=new City("A","X");
        City city1=new City("B","M");
        cityList.add(city);
        cityList.add(city1);
        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, city1.compareTo(cityList.getCities(1).get(1)));

        assertEquals(0, city.compareTo(cityList.getCities(2).get(1)));
        assertEquals(0,city1.compareTo(cityList.getCities(2).get(0)));
    }

    /**
     * method to test the delete method
     */

    @Test
    public void testDelete(){
        CityList cityList=new CityList();
        City city = new City("fulbari","Khulna");
        City city1 = new City("mirpur","Dhaka");
        cityList.add(city);
        cityList.add(city1);
        cityList.Delete(city);
        assertTrue(!cityList.getCities(1).contains(city));
    }

    /**
     * method to test whether an exception is generated while deleting a city that doesn't exist in the list
     */

    @Test
    public void testDeleteException(){
        CityList cityList = new CityList();
        City city=new City("jossore","khulna");
        City city1=new City("coxbazar","chittagong");
        cityList.add(city);
        cityList.add(city1);
        cityList.Delete(city1);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.Delete(city1);
        });
    }
}
