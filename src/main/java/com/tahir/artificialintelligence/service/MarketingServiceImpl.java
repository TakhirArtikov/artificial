package com.tahir.artificialintelligence.service;


import com.tahir.artificialintelligence.entity.MarketingDataEntity;
import com.tahir.artificialintelligence.models.MarketingData;
import com.tahir.artificialintelligence.models.DomainRequestBody;
import com.tahir.artificialintelligence.models.Response;
import com.tahir.artificialintelligence.models.ResponseData;
import com.tahir.artificialintelligence.repository.MarketingDataRepository;
import com.tahir.artificialintelligence.resttemplate.MarketingRestTemplate;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MarketingServiceImpl implements MarketingService{

    private final MarketingRestTemplate marketingRestTemplate;

    private final MarketingDataRepository marketingDataRepository;

    @SneakyThrows
    public ResponseData getData(String name, String type, DomainRequestBody request) {

        List<Response> responseList = new ArrayList<>();
        List<MarketingData> marketingDataList = marketingRestTemplate.exchangeData(request);

        marketingDataList.forEach(marketingData -> {
            Response response = new Response();
            response.setLevel1Hero(marketingData.getLevel1Hero());
            response.setLevel2Hero(marketingData.getLevel2Hero());
            response.setPriceMoreInformationDetails(marketingData.getPriceMoreInformationDetails());
            response.setPriceMoreInformationHeader(marketingData.getPriceMoreInformationHeader());
            response.setProductDetailsLinkText(marketingData.getProductDetailsLinkText());
            response.setPrice("19.99");
            response.setProductDetailsPageUrl(marketingData.getProductDetailsPageUrl());
            response.setProductInformationDownloadUrl(marketingData.getProductInformationDownloadUrl());
            response.setValidFor(marketingData.getValidFor());
            responseList.add(response);

            MarketingDataEntity entity = new MarketingDataEntity();
            BeanUtils.copyProperties(response,entity);
            entity.setEndDateTime(response.getValidFor().getEndDateTime());
            entity.setStartDateTime(response.getValidFor().getStartDateTime());
            marketingDataRepository.save(entity);

        });

        return new ResponseData(responseList);
    }

}