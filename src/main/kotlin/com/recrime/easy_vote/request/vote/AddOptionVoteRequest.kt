package com.recrime.easy_vote.request.vote

data class AddOptionVoteRequest (
    val voteIndex: Long,
    val name: String
)