package com.recrime.easy_vote.response

import com.recrime.easy_vote.enums.ResponseCode

data class DefaultJsonResponse(
    val responseCode: ResponseCode,
    val data: Map<String, Any>? = null
)