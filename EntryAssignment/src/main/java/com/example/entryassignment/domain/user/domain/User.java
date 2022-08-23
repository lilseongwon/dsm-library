package com.example.entryassignment.domain.user.domain;

import com.example.entryassignment.domain.apply.domain.Apply;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String accountId;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(length = 4, nullable = false)
    private String name;

    @Column(length = 1, nullable = false)
    private Integer applyCount;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Apply> applyList = new ArrayList<>();

    @Builder
    public User(String accountId, String password, String name) {
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.applyCount = 0;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public void addCount() {
        this.applyCount = this.applyCount + 1;
    }

    public void subCount() {
        this.applyCount = this.applyCount - 1;
    }
}
