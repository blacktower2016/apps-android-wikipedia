package org.wikipedia.homeworks.homework04

import org.wikipedia.homeworks.homework04.Days.FRIDAY
import org.wikipedia.homeworks.homework04.Days.MONDAY
import org.wikipedia.homeworks.homework04.Days.SATURDAY
import org.wikipedia.homeworks.homework04.Days.SUNDAY
import org.wikipedia.homeworks.homework04.Days.THURSDAY
import org.wikipedia.homeworks.homework04.Days.TUESDAY
import org.wikipedia.homeworks.homework04.Days.WEDNESDAY
import java.time.LocalTime
import java.time.format.DateTimeFormatter.ISO_LOCAL_TIME

typealias OnSchedule = Schedule.() -> Unit

data class ScheduleEntity(val lesson: String, val startTime: LocalTime, val endTime: LocalTime)

enum class Days {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

class Schedule {

    private val scheduleOfWeek = mutableMapOf<Days, MutableList<ScheduleEntity>>()
    private val timeFormatter = ISO_LOCAL_TIME

    private var currentDay = MONDAY

    fun monday(function: OnSchedule) = setDay(MONDAY, function)
    fun tuesday(function: OnSchedule) = setDay(TUESDAY, function)
    fun wednesday(function: OnSchedule) = setDay(WEDNESDAY, function)
    fun thursday(function: OnSchedule) = setDay(THURSDAY, function)
    fun friday(function: OnSchedule) = setDay(FRIDAY, function)
    fun saturday(function: OnSchedule) = setDay(SATURDAY, function)
    fun sunday(function: OnSchedule) = setDay(SUNDAY, function)

    infix fun Pair<LocalTime, LocalTime>.schedule(lesson: String) {
        addSchedule(currentDay, ScheduleEntity(lesson, this.first, this.second))
    }

    operator fun String.rangeTo(to: String): Pair<LocalTime, LocalTime> {
        val startTime = LocalTime.parse(this, timeFormatter)
        val endTime = LocalTime.parse(to, timeFormatter)
        return startTime to endTime
    }

    fun addSchedule(day: Days, scheduleEntity: ScheduleEntity) {
        scheduleOfWeek.getOrPut(day) { mutableListOf() }.add(scheduleEntity)
    }

    override fun toString(): String {
        return scheduleOfWeek.toSortedMap()
            .map { (day, list) ->
                list.sortedBy { it.startTime }
                    .joinToString("\n") {
                        "%-15s${it.startTime.format(timeFormatter)} - ${
                            it.endTime.format(
                                timeFormatter
                            )
                        }".format("\t${it.lesson}:")
                    }.let {
                        "${day.name.lowercase().replaceFirstChar { day.name[0].uppercase() }}:\n$it"
                    }
            }.joinToString("\n\n")
    }

    private fun setDay(day: Days, function: OnSchedule) {
        currentDay = day
        function()
    }
}

fun schedule(init: OnSchedule): Schedule {
    val schedule = Schedule()
    schedule.init()
    return schedule
}

fun main() {

    var schedule = Schedule()

    // Так добавляется расписание без DSL
    schedule.addSchedule(
        MONDAY,
        ScheduleEntity("Biology", LocalTime.of(10, 30), LocalTime.of(11, 10))
    )
    schedule.addSchedule(
        MONDAY,
        ScheduleEntity("Chemistry", LocalTime.of(11, 15), LocalTime.of(11, 55))
    )


    // Так добавляется расписание с использованием DSL
    schedule = schedule {

        monday {
            "10:30".."11:10" schedule "Biology"
            "11:15".."11:55" schedule "Chemistry"
            "09:00".."09:40" schedule "Mathematics"
            "09:45".."10:25" schedule "History"
        }

        tuesday {
            "09:00".."09:40" schedule "English"
            "09:45".."10:25" schedule "Geography"
            "11:15".."11:55" schedule "Art"
            "10:30".."11:10" schedule "Physics"
        }

        wednesday {
            "11:15".."11:55" schedule "Biology"
            "09:00".."09:40" schedule "Literature"
            "10:30".."11:10" schedule "History"
            "09:45".."10:25" schedule "Mathematics"
        }

        thursday {
            "11:15".."11:55" schedule "Physics"
            "10:30".."11:10" schedule "Geography"
            "09:00".."09:40" schedule "Chemistry"
            "09:45".."10:25" schedule "English"
        }

        friday {
            "09:45".."10:25" schedule "Literature"
            "11:15".."11:55" schedule "History"
            "09:00".."09:40" schedule "Art"
            "10:30".."11:10" schedule "Mathematics"
        }
    }

    println(schedule.toString())
}
