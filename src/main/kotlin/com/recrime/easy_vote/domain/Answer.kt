package com.recrime.easy_vote.domain

import java.time.LocalDateTime
import jakarta.persistence.*

@Entity
@Table(name = "answer")
class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_index", insertable = false, updatable = false)
    val answerIndex: Long? = null

    @Column(name = "vote_index", nullable = false)
    var voteIndex: Long = 0

    @Column(name = "option_index", nullable = false)
    var optionIndex: Long = 0

    @Column(name = "answerer", nullable = false, length = 30)
    lateinit var answerer: String

    @Column(name = "vote_time", nullable = false)
    var voteTime: LocalDateTime = LocalDateTime.now()
}