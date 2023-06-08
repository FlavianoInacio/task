package com.flaviano.task.data.task.model

enum class TaskType(val id: Int) {
    STUDY(1), WORK(2), SPORT(3), LEISURE(4), BUY(5);

    fun TaskType.title(): String = when (this) {
        STUDY -> TODO()
        WORK -> TODO()
        SPORT -> TODO()
        LEISURE -> TODO()
        BUY -> TODO()
    }
}
