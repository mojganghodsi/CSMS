package com.hastobe.csms;

import com.hastobe.csms.controller.ChargingProcessController;
import com.hastobe.csms.model.*;
import com.hastobe.csms.service.ChargingProcessService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author mojgan
 * test class for charging API testing
 *
 * using junit for testing
 * Mockito for mocking objects
 * JSONAssert for testing json strings
 */

@ContextConfiguration(classes = CsmsApplication.class)
@WebMvcTest(value = ChargingProcessController.class)
public class ChargingAPITest implements DateConverter, JsonMapper{
    @Autowired
    private MockMvc mvc;
    @MockBean
    private ChargingProcessService chargingProcessService;

    @BeforeEach
    void setUp(){

    }

    @Test
    public void chargeAPITest() throws Exception {
        Components components = new Components(3.277,2.767,1.0);
        ChargingProcessOutput chargingProcessOutput = new ChargingProcessOutput(7.04,components);
        String stringInput = "{\n" +
                "\"rate\": { \"energy\": 0.3, \"time\": 2, \"transaction\": 1 },\n" +
                "\"cdr\": { \"meterStart\": 1204307, \"timestampStart\": \"2021-04-05T10:04:00Z\", \"meterStop\": 1215230, \"timestampStop\":\n" +
                "\"2021-04-05T11:27:00Z\" }\n" +
                "}";
        String expectedOutput = "{\n" +
                "\"overall\": 7.04,\n" +
                "\"components\": { \"energy\": 3.277, \"time\": 2.767, \"transaction\": 1 }\n" +
                "}";
        Mockito.when(chargingProcessService.charge(Mockito.any())).thenReturn(chargingProcessOutput);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/chargeprocess/charge").content(stringInput).contentType(MediaType.APPLICATION_JSON_VALUE);
        MvcResult result = mvc.perform(requestBuilder).andReturn();
        /*
        in case of equal assertion for objects
        ChargingProcessOutput outputObject = mapFromJson(expectedOutput, ChargingProcessOutput.class);
        Assertions.assertEquals(outputObject,mapFromJson(result.getResponse().getContentAsString(), ChargingProcessOutput.class));
        */
        String actualOutPut = result.getResponse().getContentAsString();
        JSONAssert.assertEquals(expectedOutput, actualOutPut, false);
    }

}


