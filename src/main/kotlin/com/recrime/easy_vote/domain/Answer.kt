package com.recrime.easy_vote.domain

import java.time.LocalDateTime
import jakarta.persistence.*

@Entity
@Table(name = "answer")
class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_index")
    var answerIndex: Long? = null

    @ManyToOne
    @JoinColumn(name = "vote_index", nullable = false)
    lateinit var vote: Vote

    @ManyToOne
    @JoinColumn(name = "option_index", nullable = false)
    lateinit var option: Option

    @Column(name = "answerer", nullable = false, length = 30)
    lateinit var answerer: String

    @Column(name = "vote_time", nullable = false)
    var voteTime: LocalDateTime = LocalDateTime.now()
}