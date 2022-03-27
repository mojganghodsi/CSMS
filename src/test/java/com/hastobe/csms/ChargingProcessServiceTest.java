package com.hastobe.csms;

import com.hastobe.csms.model.*;
import com.hastobe.csms.service.ChargingProcessService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author mojgan
 * test class for service class test
 *
 * using junit for testing
 * Mockito for mocking objects
 * JSONAssert for testing json strings
 */

@SpringBootTest
public class ChargingProcessServiceTest implements DateConverter {
    @Autowired
    ChargingProcessService chargingProcessService;

    @BeforeEach
    void setup(){

    }

    @Test
    void ChargingProcessTest() throws Exception{
        Rate rate = new Rate(0.3,2.0,1.0);
        CDR cdr = new CDR(1204307L, stringToDate("2021-04-05T10:04:00Z"),1215230L, stringToDate("2021-04-05T11:27:00Z"));
        ChargingProcessInput chargingProcessInput = new ChargingProcessInput(rate,cdr);
        Components components = new Components(3.277,2.767,1.0);
        ChargingProcessOutput chargingProcessOutput = new ChargingProcessOutput(7.04,components);
        Assert.assertEquals(chargingProcessService.charge(chargingProcessInput),chargingProcessOutput);
    }

}
