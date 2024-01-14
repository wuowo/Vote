package com.example.vote.service;

import com.example.vote.entity.VoteRecord;

import java.util.List;

public interface VoteRecordService {
    List<VoteRecord> getAllVoteRecords();

    abstract List<VoteRecord> getVoteRecordsByVoterAndVoteItems(String voter, List<Long> voteItemIds);


    //允許用戶重複投票
    void vote(String voter, List<Long> voteItemIds);

    VoteRecord getVoteRecordById(Long id);
}
