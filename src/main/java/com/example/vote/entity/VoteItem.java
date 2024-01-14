package com.example.vote.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "voteitem")
public class VoteItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //投票項目編號
    @Column
    private Integer voteNumber;
    //投票項目名稱
    private String voteItemN;
    private Long voteItemId;


    public Integer getVoteNumber() {
        return voteNumber;
    }

    public void setVoteNumber(Integer voteNumber) {
        this.voteNumber = voteNumber;
    }

    public String getVoteItemN() {
        return voteItemN;
    }

    public void setVoteItemN(String voteItemN) {
        this.voteItemN = voteItemN;
    }

    public void setId(Long voteItemId) {
        this.voteItemId = voteItemId;
    }
}
