package com.example.vote.controller;

import com.example.vote.entity.VoteRecord;
import com.example.vote.service.VoteRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/voterecords")
public class VoteRecordController {

    @Autowired
    private VoteRecordService voteRecordService;

    //獲取投票紀錄
    @GetMapping
    public List<VoteRecord> getAllVoteRecords(){
        return  voteRecordService.getAllVoteRecords();
    }
    //投票人和投票項進行投票
    @PostMapping("/vote")
    public void vote(@RequestParam String voter, @RequestParam List<Long> voteItemIds){
        //用htmlUtils來防止XSS攻擊
        voteRecordService.vote(voter, voteItemIds);
    }

    @GetMapping("/{id}")
    public VoteRecord getVoteRecord(@PathVariable Long id){
        return voteRecordService.getVoteRecordById(id);
    }

    @GetMapping("/search")
    public List<VoteRecord> searchVoteRecords(@RequestParam String voter, @RequestParam List<Long> voteItemIds) {
        return voteRecordService.getVoteRecordsByVoterAndVoteItems(voter, voteItemIds);
    }
}
