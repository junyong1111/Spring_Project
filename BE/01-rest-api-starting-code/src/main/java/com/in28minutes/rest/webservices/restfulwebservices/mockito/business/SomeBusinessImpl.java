package com.in28minutes.rest.webservices.restfulwebservices.mockito.business;

import javax.xml.crypto.Data;

public class SomeBusinessImpl {
    private final DataService dataService;

    public SomeBusinessImpl(DataService dataService) {
        super();
        this.dataService = dataService;
    }


    public int findTheGreatestFromAllData(){
        int [] data = dataService.retrieveAllData();
        int greatestValue = Integer.MIN_VALUE;
        for(int value:data){
            if(greatestValue < value){
                greatestValue = value;
            }
        }
        return greatestValue;
    }
}

