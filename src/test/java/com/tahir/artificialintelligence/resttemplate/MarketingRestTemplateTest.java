//package com.tahir.artificialintelligence.resttemplate;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import com.tahir.artificialintelligence.models.DomainRequestBody;
//import com.tahir.artificialintelligence.models.MarketingData;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.test.util.ReflectionTestUtils;
//import org.springframework.web.client.RestTemplate;
//
//import java.io.File;
//import java.util.List;
//
//import static com.tahir.artificialintelligence.utils.TestUtils.okResponse;
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.when;
//
//@DisplayName("Unit Test for RestTemplate")
//@ExtendWith(MockitoExtension.class)
//public class MarketingRestTemplateTest {
//
//    @Mock
//    RestTemplate restTemplate;
//
//    @InjectMocks
//    MarketingRestTemplate marketingRestTemplate;
//
//    @BeforeEach
//    void setUp(){
//        ReflectionTestUtils.setField(marketingRestTemplate,"url","http://mz0m1.mocklab.io/marketing-data");
//    }
//
//    @Test
//    @DisplayName("Test case for getting data from mocklab")
//    void whenGetDataThenReturnNotNullResponse()throws Exception{
//        ObjectMapper objectMapper=new ObjectMapper();
//        objectMapper.registerModule(new JavaTimeModule());
//        List<MarketingData> marketingData=objectMapper.readValue(new File("./src/test/resources/marketing-data.json"),
//                new TypeReference<>() {
//                });
//        when(restTemplate.exchange(anyString(),any(),any(), eq(new ParameterizedTypeReference<List<MarketingData>>(){})))
//                .thenReturn(okResponse(marketingData));
//
//        DomainRequestBody requestBody= new DomainRequestBody();
//        requestBody.setPhoneNumber("");
//        requestBody.setRegion("");
//
//        List<MarketingData> marketingData1=marketingRestTemplate.exchangeData(requestBody);
//        Assertions.assertNotNull(marketingData1);
//    }
//
//
//
//
//}
