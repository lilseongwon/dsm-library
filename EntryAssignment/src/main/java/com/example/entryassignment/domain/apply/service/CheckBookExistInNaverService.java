package com.example.entryassignment.domain.apply.service;

import com.example.entryassignment.domain.apply.exception.BookIsNotExistInNaverException;
import com.example.entryassignment.domain.book.presentation.dto.response.QueryNaverBookInfoResponse;
import lombok.RequiredArgsConstructor;
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

    private final String CLIENT_ID = System.getenv("CLIENT_ID");
    private final String CLIENT_SECRET = System.getenv("CLIENT_SECRET");

    public void execute(String title, String isbn) {
        final HttpHeaders headers = new HttpHeaders();
        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/book.json")
                .queryParam("query", title)
                .queryParam("d_isbn", isbn)
                .encode()
                .build()
                .toUri();
        headers.set("X-Naver-Client-Id", CLIENT_ID);
        headers.set("X-Naver-Client-Secret", CLIENT_SECRET);

        final HttpEntity<String> entity = new HttpEntity<>(headers);
        if((Objects.requireNonNull(restTemplate.exchange(uri, HttpMethod.GET, entity,
                QueryNaverBookInfoResponse.class).getBody()).getDisplay() == 0))
            throw BookIsNotExistInNaverException.EXCEPTION;
    }
}
