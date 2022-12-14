package com.family.family_members_api.family;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SendRequestsService {

    private final RestTemplate restTemplate;

    public SendRequestsService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getPostsPlainJSON(String url) {
        return this.restTemplate.getForObject(url, String.class);
    }

    public List getListResponse(String url) {
        return this.restTemplate.getForObject(url, List.class);
    }
}