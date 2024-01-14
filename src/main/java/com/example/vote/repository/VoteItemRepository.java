package com.example.vote.repository;

import com.example.vote.entity.VoteItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VoteItemRepository extends JpaRepository<VoteItem,Long> {
    //Stored Procedure存取
    @Modifying
    @Query("SELECT v FROM  VoteItem v WHERE v.voteItemN = ?1")
    List<VoteItem> findByVoteItemN(String voteItemN);
}
