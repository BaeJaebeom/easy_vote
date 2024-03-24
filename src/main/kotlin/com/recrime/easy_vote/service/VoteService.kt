package com.recrime.easy_vote.service

import com.recrime.easy_vote.repository.answer.AnswerRepository
import com.recrime.easy_vote.repository.option.OptionRepository
import com.recrime.easy_vote.repository.vote.VoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.stereotype.Service

@Service
class VoteService(
    private val voteRepository: VoteRepository,
    private val optionRepository: OptionRepository,
    private val answerRepository: AnswerRepository
) {

    fun makeVote() {

    }
}