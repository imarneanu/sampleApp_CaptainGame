package com.udemy.captaingame

data class CaptainState(
    var treasuresFound: Int = 0,
    var direction: String = "North",
    var stormOrTreasure: String = "",
)
