package com.recrime.easy_vote.controller

import com.recrime.easy_vote.service.VoteService
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@RequiredArgsConstructor
@Controller
class VoteController(
    private val voteService: VoteService
) {

    @RequestMapping("")
    fun asdf(model: Model): String {
        println(voteService.asdf())
        model.addAttribute("data", "hello!!")
        return "index"
    }
}