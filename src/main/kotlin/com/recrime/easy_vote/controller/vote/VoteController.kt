package com.recrime.easy_vote.controller.vote

import com.recrime.easy_vote.enums.ResponseCode
import com.recrime.easy_vote.request.vote.AddOptionVoteRequest
import com.recrime.easy_vote.request.vote.CreateVoteRequest
import com.recrime.easy_vote.request.vote.AnswerVoteRequest
import com.recrime.easy_vote.response.DefaultJsonResponse
import com.recrime.easy_vote.service.VoteService
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.*

@RequestMapping("/v1/")
@RequiredArgsConstructor
@RestController
class VoteController(
    private val voteService: VoteService
) {
    @PostMapping("create")
    fun createVote(@RequestBody request: CreateVoteRequest): DefaultJsonResponse {

        return DefaultJsonResponse(ResponseCode.OK, mapOf("code" to "value"))

    }

    @PostMapping("add-option")
    fun addAnswer(@RequestBody addOptionVoteRequest: AddOptionVoteRequest): DefaultJsonResponse  {

        return DefaultJsonResponse(ResponseCode.OK, mapOf("asdf" to "value"))
    }

    @PostMapping("answer")
    fun vote(@RequestBody answerVoteRequest: AnswerVoteRequest): DefaultJsonResponse  {

        return DefaultJsonResponse(ResponseCode.OK, mapOf("asdf" to "value"))
    }

}