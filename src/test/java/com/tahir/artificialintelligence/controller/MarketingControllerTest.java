//package com.tahir.artificialintelligence.controller;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import com.tahir.artificialintelligence.models.DomainRequestBody;
//import com.tahir.artificialintelligence.models.Response;
//import com.tahir.artificialintelligence.service.MarketingService;
//import lombok.SneakyThrows;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.util.ReflectionTestUtils;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.awt.*;
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//import static com.tahir.artificialintelligence.utils.TestUtils.asJsonString;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@DisplayName("Test for Marketing Data Controller class")
//@WebMvcTest(MarketingDataController.class)
//public class MarketingControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @MockBean
//    private MarketingService marketingService;
//
//
//    @SneakyThrows
//    @Test
//    void WhenMarketingDataThenReturnOkResponse()throws Exception{
//        ObjectMapper objectMapper=new ObjectMapper();
//        objectMapper.registerModule(new JavaTimeModule());
//        List<Response> responseList=objectMapper.readValue(new File("./src/test/resources/response.json"),
//                new TypeReference<>() {
//                });
//        DomainRequestBody requestBody= new DomainRequestBody();
//        requestBody.setPhoneNumber("");
//        requestBody.setRegion("");
//        Mockito.when(marketingService.getData("Name", "Type", requestBody).getResponse())
//                .thenReturn(responseList);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                .get("v1/marketing-data")
//                .header("name","Name")
//                .header("type","Type")
//                .content(asJsonString(requestBody))
//                .contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }
//
//
//
//}
