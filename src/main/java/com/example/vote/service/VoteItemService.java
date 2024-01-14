package com.example.vote.service;
import com.example.vote.entity.VoteItem;

import  java.util.List;
public interface VoteItemService {

    //取得所有投票項目
    List<VoteItem> getAllVoteItems();
    //根據ID取得投票項目
    VoteItem getVoteItemById(Long id);
    //創建新的投票項目
    VoteItem createVoteItem(VoteItem voteItem);
    //更新投票項目
    void updateVoteItem(Long id, VoteItem voteItem);
    //刪除投票項目
    void deleteVoteItem(Long id);
}
