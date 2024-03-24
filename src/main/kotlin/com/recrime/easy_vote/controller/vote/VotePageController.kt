package com.recrime.easy_vote.controller.vote

import com.recrime.easy_vote.service.VoteService
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@RequiredArgsConstructor
@Controller
class VotePageController(
    private val voteService: VoteService
) {
    @RequestMapping("")
    fun main(model: Model): String {

        model.addAttribute("data", "hello!!")
        return "main"
    }

    @RequestMapping("create")
    fun create(model: Model): String {

        model.addAttribute("data", "hello!!")
        return "create"
    }

    @RequestMapping("vote")
    fun result(model: Model, code: String): String {

        model.addAttribute("data", "hello!!")
        model.addAttribute("")
        return "vote"
    }
}