import java.util.*

fun main() {
    println("Введите время в секундах")
    val scanner = Scanner(System.`in`)
    val secondsAgo = scanner.nextInt()

    agoToText(secondsAgo)
}

fun agoToText(secondsAgo: Int) {
    val fewMinutes = secondsAgo / 60
    val hour = 60 * 60
    val hours: Int = secondsAgo / hour
    val userWas = when (secondsAgo) {
        in 0..60 -> "Был(-а) в сети только что"
        in 61..hour -> "Был(-а) в сети $fewMinutes ${minuteAgo(secondsAgo)} назад"
        in hour + 1..24 * hour -> "Был(-а) в сети $hours ${hoursAgo(secondsAgo)} назад"
        in 24 * hour + 1..2 * 24 * hour -> "Был(-а) в сети вчера"
        in 2 * 24 * hour + 1..3 * 24 * hour -> "Был(-а) в сети позавчера"
        else -> "Был(-а) в сети давно"
    }
    println(userWas)
}

fun minuteAgo(secondsAgo: Int): String {
    val minutesAgo = when (secondsAgo / 60) {
        1, 21, 31, 41, 51 -> "минуту"
        in 2..4, in 22..24, in 32..34, in 42..44, in 52..54 -> "минуты"
        else -> "минут"
    }
    return minutesAgo
}

fun hoursAgo(secondsAgo: Int): String {
    val hour = 60 * 60
    val hoursAgo = when (secondsAgo / hour) {
        1, 21 -> "час"
        in 5..20 -> "часов"
        else -> "часа"
    }
    return hoursAgo
}