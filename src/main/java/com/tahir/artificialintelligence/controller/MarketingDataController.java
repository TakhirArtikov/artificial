package com.tahir.artificialintelligence.controller;

import com.tahir.artificialintelligence.models.MarketingData;
import com.tahir.artificialintelligence.models.DomainRequestBody;
//import com.tahir.artificialintelligence.models.ResponseData;
import com.tahir.artificialintelligence.models.ResponseData;
import com.tahir.artificialintelligence.service.MarketingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class MarketingDataController {


    private final MarketingService marketingService;

    @Operation(summary = "Marketing Data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MarketingData.class))))
    })
    @GetMapping(value = "/marketing-data",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseData getMarketingData(
            @Schema(example = "Name") @RequestParam @NotBlank String name,
            @Schema(example = "Type") @RequestParam @NotBlank String type,
            @RequestBody DomainRequestBody request) {
        return marketingService.getData(name,type,request);
    }
}
