//package com.tahir.artificialintelligence.service;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import com.tahir.artificialintelligence.models.DomainRequestBody;
//import com.tahir.artificialintelligence.models.MarketingData;
//import com.tahir.artificialintelligence.models.Response;
//import com.tahir.artificialintelligence.models.ResponseData;
//import com.tahir.artificialintelligence.repository.MarketingDataRepository;
//import com.tahir.artificialintelligence.resttemplate.MarketingRestTemplate;
//import com.tahir.artificialintelligence.service.MarketingService;
//import com.tahir.artificialintelligence.service.MarketingServiceImpl;
//import org.aspectj.util.Reflection;
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
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//import static com.tahir.artificialintelligence.utils.TestUtils.okResponse;
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.when;
//
//@DisplayName("Test for Marketing Service")
//@ExtendWith(MockitoExtension.class)
//public class MarketingServiceTest {
//
//    @Mock
//    MarketingRestTemplate marketingRestTemplate;
//
//    @InjectMocks
//    MarketingServiceImpl marketingServiceImpl;
//
//    @BeforeEach
//    void setUp(){
//        ReflectionTestUtils.setField(marketingServiceImpl,"marketingRestTemplate",marketingRestTemplate);
//    }
//
//    @Test
//    void whenGetMarketingServiceImplThenReturnNotNullResponse()throws IOException{
//        ObjectMapper objectMapper=new ObjectMapper();
//        objectMapper.registerModule(new JavaTimeModule());
//        List<Response> responseList=objectMapper.readValue(new File("./src/test/resources/response.json"),
//                new TypeReference<>() {
//                });
//
//        List<MarketingData> marketingDataList=objectMapper.readValue(new File("./src/test/resources/marketing-data.json"),
//                new TypeReference<>() {
//                });
//        when(marketingRestTemplate.exchangeData(any(DomainRequestBody.class))).thenReturn(marketingDataList);
//        DomainRequestBody requestBody= new DomainRequestBody();
//        requestBody.setPhoneNumber("");
//        requestBody.setRegion("");
//        List<Response> expectedList = marketingServiceImpl.getData("Name", "Type", requestBody).getResponse();
//        Assertions.assertEquals(responseList,expectedList);
//
//    }
//
//
//}
