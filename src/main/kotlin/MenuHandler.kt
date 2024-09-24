import java.util.Scanner

class MenuHandler {
    private val scanner = Scanner(System.`in`)

    // Функция для вывода меню и обработки выбора
    fun showMenu(title: String, options: List<Pair<String, () -> Unit>>) {
        while (true) {
            println("\n$title")
            options.forEachIndexed { index, option ->
                println("${index + 1}. ${option.first}")
            }
            println("0. Назад")

            val choice = readInput(options.size)
            if (choice == 0) return // Выход из меню
            options[choice - 1].second() // Вызов соответствующей лямбды
        }
    }

    // Функция для обработки пользовательского ввода
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