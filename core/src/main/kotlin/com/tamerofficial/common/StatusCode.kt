package com.tamerofficial.common

import com.tamerofficial.common.StatusCode.TK_PL_00100

object StatusCode {
    const val TK_PL_00100 = "TK_PL_00100"
}

open class ResponseStatus(
    val statusCode: String,
    val statusMessage: String
)

object SuccessStatus : ResponseStatus(statusCode = TK_PL_00100,statusMessage = "요청 정상 수신")