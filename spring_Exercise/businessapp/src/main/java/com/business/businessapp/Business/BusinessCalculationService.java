package com.business.businessapp.Business;

import java.util.Arrays;

import com.business.businessapp.Data.MongoDbDataService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.business.businessapp.Data.DataService;
import org.springframework.stereotype.Component;



@Component
public class BusinessCalculationService {
    private final DataService dataService;

    public BusinessCalculationService(DataService dataService) {
        super();
        this.dataService = dataService;
    }
    public int findMax()
    {
        return Arrays.stream(dataService.retrieveData())
                .max().orElse(0);
    }


}
