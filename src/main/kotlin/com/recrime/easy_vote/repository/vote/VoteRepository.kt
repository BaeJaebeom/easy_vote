package com.recrime.easy_vote.repository.vote

import com.recrime.easy_vote.domain.Vote
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface VoteRepository : JpaRepository<Vote, Long>, QuerydslPredicateExecutor<Vote> {

}