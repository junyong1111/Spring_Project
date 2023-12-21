package com.in28minutes.rest.webservices.restfulwebservices;

import com.in28minutes.rest.webservices.restfulwebservices.mockito.business.DataService;
import com.in28minutes.rest.webservices.restfulwebservices.mockito.business.SomeBusinessImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplTest {
    @Mock
    private DataService dataServiceMock;
    @InjectMocks
    private SomeBusinessImpl businessImpl;

    @Test
    void test(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{25, 5, 15});
        assertEquals(25, businessImpl.findTheGreatestFromAllData());
    }
}

