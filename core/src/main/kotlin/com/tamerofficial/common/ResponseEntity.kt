package com.tamerofficial.common

data class ResponseEntity<T>(val code : String, val message: String, val data : T? = null)