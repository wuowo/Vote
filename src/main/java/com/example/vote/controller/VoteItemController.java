package com.example.vote.controller;

import com.example.vote.entity.VoteItem;
import com.example.vote.service.VoteItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voteitem")
public class VoteItemController {


    private VoteItemService voteItemService;

    @GetMapping
    public List<VoteItem> getAllVoteItem(){
        return voteItemService.getAllVoteItems();
    }

    @PostMapping
    public VoteItem createVoteItem(@RequestBody VoteItem voteItem){
        return voteItemService.createVoteItem(voteItem);
    }

    @PutMapping("/{id}")
    public void updateVoteItem(@PathVariable Long id, @RequestBody VoteItem voteItem) {
        voteItemService.updateVoteItem(id, voteItem);
    }

    @DeleteMapping("/{id}")
    public void deleteVoteItem(@PathVariable Long id) {
        voteItemService.deleteVoteItem(id);
    }
}
