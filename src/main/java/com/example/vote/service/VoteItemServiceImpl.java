package com.example.vote.service;

import com.example.vote.entity.VoteItem;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.vote.repository.VoteItemRepository;
import java.util.List;

public class VoteItemServiceImpl  implements  VoteItemService{

    @Autowired
    private VoteItemRepository voteItemRepository;
    //從資料庫查詢所有投票項
    @Override
    public List<VoteItem> getAllVoteItems() {
        return voteItemRepository.findAll();
    }

    @Override
    public VoteItem getVoteItemById(Long id) {
        return voteItemRepository.findById(id).orElse(null);
    }

    @Override
    public VoteItem createVoteItem(VoteItem voteItem) {
        return voteItemRepository.save(voteItem);
    }
    //更新資料庫現有投票項
    @Override
    public void updateVoteItem(Long id, VoteItem voteItem) {
        VoteItem existingVoteItem = voteItemRepository.findById(id).orElse(null);
        if(existingVoteItem != null){
            existingVoteItem.setVoteItemN(voteItem.getVoteItemN());
            voteItemRepository.save(existingVoteItem);
        }
    }
    //透過id從資料庫刪除投票項
    @Override
    public void deleteVoteItem(Long id) {
        voteItemRepository.deleteById(id);

    }
}
