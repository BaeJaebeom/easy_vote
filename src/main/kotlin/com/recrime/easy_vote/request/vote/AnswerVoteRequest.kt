package com.recrime.easy_vote.request.vote

data class AnswerVoteRequest(
    val voteIndex: Long,
    val optionIndex: Long,
    val answerer: String
)
