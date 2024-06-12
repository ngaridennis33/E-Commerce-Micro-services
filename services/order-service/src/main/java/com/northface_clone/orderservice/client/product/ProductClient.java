package com.northface_clone.orderservice.client.product;

import com.northface_clone.orderservice.dto.request.PurchaseRequestDTO;
import com.northface_clone.orderservice.dto.response.PurchaseResponseDTO;
import com.northface_clone.orderservice.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
@RequiredArgsConstructor
public class ProductClient {

    @Value("${application.config.product-url}")
    private String productUrl;
    private final RestTemplate restTemplate;

    public List<PurchaseResponseDTO> purchaseProducts(List<PurchaseRequestDTO> requestBody){
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_VALUE);

        HttpEntity<List<PurchaseRequestDTO>> requestEntity = new HttpEntity<>(requestBody,headers);
        ParameterizedTypeReference<List<PurchaseResponseDTO>> responseType =
                 new ParameterizedTypeReference<>() {};
        ResponseEntity<List<PurchaseResponseDTO>> responseEntity = restTemplate.exchange(
                productUrl + "/purchase",
                POST,
                requestEntity,
                responseType
        );
        if (responseEntity.getStatusCode().isError()){
            throw new BusinessException("An error occurred while processing the products purchase: " + responseEntity.getStatusCode());
        }
        return responseEntity.getBody();
    }
}
