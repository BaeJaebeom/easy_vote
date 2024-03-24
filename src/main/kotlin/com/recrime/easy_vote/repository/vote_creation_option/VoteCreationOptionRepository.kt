package com.recrime.easy_vote.repository.vote_creation_option

import com.recrime.easy_vote.domain.Vote
import com.recrime.easy_vote.domain.VoteCreationOption
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface VoteCreationOptionRepository : JpaRepository<VoteCreationOption, Long>,
    QuerydslPredicateExecutor<VoteCreationOption> {
}