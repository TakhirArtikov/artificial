package com.tahir.artificialintelligence.resttemplate;

import com.tahir.artificialintelligence.exceptions.NotFoundException;
import com.tahir.artificialintelligence.models.MarketingData;
import com.tahir.artificialintelligence.models.DomainRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Component
public class MarketingRestTemplate {

    private final RestTemplate restTemplate;

    @Value("${getMarketingDataURl}")
    private String url;

    public List<MarketingData> exchangeData(DomainRequestBody request) {
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Auth", "Bearer");
        HttpEntity<DomainRequestBody> httpEntity=new HttpEntity<>(request,httpHeaders);
        try {
            ResponseEntity<List<MarketingData>> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
                    new ParameterizedTypeReference<>() {
                    });
            if (response.hasBody())
                return response.getBody();
        }
        catch (HttpClientErrorException.NotFound e){
            throw new NotFoundException();
        }
        catch (Exception e){
            throw e;
        }
        return null;
    }


}
