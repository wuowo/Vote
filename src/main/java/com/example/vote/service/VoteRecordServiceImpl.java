package com.example.vote.service;

import com.example.vote.entity.VoteItem;
import com.example.vote.entity.VoteRecord;
import com.example.vote.repository.VoteItemRepository;
import com.example.vote.repository.VoteRecordRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteRecordServiceImpl implements VoteRecordService {

    @Autowired
    private VoteRecordRepository voteRecordRepository;
    @Autowired
    private VoteItemRepository voteItemRepository;

    @Override
    public List<VoteRecord> getAllVoteRecords() {
        return voteRecordRepository.findAll();
    }

    @Override
    public List<VoteRecord> getVoteRecordsByVoterAndVoteItems(String voter, List<Long> voteItemIds) {
        List<VoteItem> voteItems = voteItemRepository.findAllById(voteItemIds);
        return voteRecordRepository.findByVoterAndVoteItemIn(voter, voteItems);
    }

    //允許用戶重複投票
    @Transactional
   @Override
   public void vote(String voter, List<Long> voteItemIds) {
       // 直接创建新的投票记录，允许用户重复投票
       for (Long voteItemId : voteItemIds) {
           VoteRecord newRecord = new VoteRecord();
           newRecord.setVoter(voter);

           VoteItem voteItem = new VoteItem();
           voteItem.setId(voteItemId);
           newRecord.setVoteItem(voteItem);

           voteRecordRepository.save(newRecord);
       }
   }

    @Override
    public VoteRecord getVoteRecordById(Long id) {
        return (VoteRecord) voteRecordRepository.findById(id).orElse(null);
    }

}
