package com.tahir.artificialintelligence.entity;

import com.tahir.artificialintelligence.models.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "marketing_data")
@NoArgsConstructor
@AllArgsConstructor
public class MarketingDataEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "price_information_details")
    private String priceMoreInformationDetails;
    @Column(name = "level_2_hero")
    private String level2Hero;
    @Column(name = "product_details_page_url")
    private String productDetailsPageUrl;
    @Column(name = "product_information_dowload_url")
    private String productInformationDownloadUrl;
    @Column(name = "price_information_header")
    private String priceMoreInformationHeader;
    @Column(name = "level_1_hero")
    private String level1Hero;
    @Column(name = "product_details_link_text")
    private String productDetailsLinkText;
    @Column(name = "price")
    private String price;
    @Column(name = "start_date")
    private LocalDateTime startDateTime;
    @Column(name = "end_date")
    private LocalDateTime endDateTime;

}
