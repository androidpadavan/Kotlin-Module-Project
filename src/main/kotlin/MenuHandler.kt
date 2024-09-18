import java.util.Scanner

class MenuHandler {
    private val scanner = Scanner(System.`in`)


    fun showMenu(title: String, options: List<Pair<String, () -> Unit>>) {
        while (true) {
            println("\n$title")
            options.forEachIndexed { index, option ->
                println("${index + 1}. ${option.first}")
            }
            println("0. Назад")

            val choice = readInput(options.size)
            if (choice == 0) return
            options[choice - 1].second()
        }
    }


    private fun readInput(max: Int): Int {
        while (true) {
            print("Введите номер пункта: ")
            val input = scanner.nextLine()

            try {
                val num = input.toInt()
                if (num in 0..max) return num
                else println("Нет такого пункта меню.")
            } catch (e: NumberFormatException) {
                println("Введите корректное число.")
            }
        }
    }
}
