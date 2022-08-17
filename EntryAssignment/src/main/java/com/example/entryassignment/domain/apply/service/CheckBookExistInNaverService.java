package com.example.entryassignment.domain.apply.service;

import com.example.entryassignment.domain.apply.exception.BookIsNotExistInNaverException;
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
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class CheckBookExistInNaverService {
    private final RestTemplate restTemplate;

    @Value("${naver.url}")
    private String DETAIL_URL;
    @Value("${naver.id}")
    private String CLIENT_ID;
    @Value("${naver.secret}")
    private String CLIENT_SECRET;

    public void execute(String title, String isbn) {
        final HttpHeaders headers = new HttpHeaders();
        URI uri = UriComponentsBuilder
                .fromUriString(DETAIL_URL)
                .queryParam("d_title", title)
                .queryParam("d_isbn", isbn)
                .encode()
                .build()
                .toUri();
        headers.set("X-Naver-Client-Id", CLIENT_ID);
        headers.set("X-Naver-Client-Secret", CLIENT_SECRET);

        final HttpEntity<String> entity = new HttpEntity<>(headers);
        if((Objects.requireNonNull(restTemplate.exchange(uri, HttpMethod.GET, entity,
                QueryNaverBookInfoResponse.class).getBody()).getDisplay() != 1))
            throw BookIsNotExistInNaverException.EXCEPTION;
    }
}
