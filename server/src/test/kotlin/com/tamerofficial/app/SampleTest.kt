package com.tamerofficial.app

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class SampleTest : StringSpec({
    "test code here" {
        "name567890".length shouldBe 10
    }
})