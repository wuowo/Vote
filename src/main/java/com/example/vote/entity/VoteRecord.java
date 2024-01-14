package com.example.vote.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class VoteRecord {
    @Id
    private Long id;
    private String voter;

    private int voteNumber;

    public VoteRecord(String voter, int voteNumber) {
        this.voter = voter;
        this.voteNumber = voteNumber;
    }

    public VoteRecord() {

    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setVoteItem(VoteItem voteItem) {
    }

    public void setVoter(String voter) {
    }
}
