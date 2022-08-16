package com.example.entryassignment.domain.book.service;

import com.example.entryassignment.domain.book.presentation.dto.response.QueryNaverBookInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@Service
public class QueryNaverBookInfoService {

    private final RestTemplate restTemplate;

    @Value("${naver.url2}")
    private final String NAVER_URL;
    @Value("${naver.id}")
    private final String CLIENT_ID;
    @Value("${naver.secret}")
    private final String CLIENT_SECRET;

    public QueryNaverBookInfoResponse execute(String keyword) {
        final HttpHeaders headers = new HttpHeaders();
        URI uri = UriComponentsBuilder
                .fromUriString(NAVER_URL)
                .queryParam("query", keyword)
                .encode()
                .build()
                .toUri();
        headers.set("X-Naver-Client-Id", CLIENT_ID);
        headers.set("X-Naver-Client-Secret", CLIENT_SECRET);

        final HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(uri, HttpMethod.GET, entity, QueryNaverBookInfoResponse.class).getBody();
    }
}
