package com.tahir.artificialintelligence.service;

import com.tahir.artificialintelligence.models.DomainRequestBody;
import com.tahir.artificialintelligence.models.ResponseData;

public interface MarketingService {
    ResponseData getData(String name, String type, DomainRequestBody request);
}
