package com.example.entryassignment.domain.apply.domain;

import com.example.entryassignment.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Apply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60, nullable = false)
    private String title;

    @Column(length = 20, nullable = false)
    private String isbn;

    @Builder
    public Apply(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }
}
