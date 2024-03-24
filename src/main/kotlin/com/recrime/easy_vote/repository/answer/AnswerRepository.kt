package com.recrime.easy_vote.repository.answer

import com.recrime.easy_vote.domain.Answer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface AnswerRepository : JpaRepository<Answer, Long>, QuerydslPredicateExecutor<Answer> {
}