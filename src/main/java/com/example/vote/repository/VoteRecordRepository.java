package com.example.vote.repository;

import com.example.vote.entity.VoteRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.vote.entity.VoteItem;

import java.util.List;

public interface VoteRecordRepository  extends JpaRepository {


    List<VoteRecord> findByVoterAndVoteItemIn(String voter, List<VoteItem> voteItems);
}
