package com.recrime.easy_vote.request.vote

data class CreateVoteRequest(
    val name: String,
    val description: String?,
    val answers: List<String>
)