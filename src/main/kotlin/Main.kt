import java.util.Scanner

fun main() {
    val menuHandler = MenuHandler()
    val archives = mutableListOf<Archive>()
    1
    menuHandler.showMenu("Меню архивов", listOf("Создать архив" to {
        println("Введите название архива:")
        val name = readNonEmptyInput()
        archives.add(Archive(name))
        println("Архив '$name' создан.")
    }, "Просмотреть архивы" to {
        if (archives.isEmpty()) {
            println("Нет доступных архивов.")
        } else {
            menuHandler.showMenu(
                "Выбор архива",
                archives.map { it.name to { it.viewNotes(menuHandler) } })
        }
    }))
}


fun readNonEmptyInput(): String {
    while (true) {
        val input = Scanner(System.`in`).nextLine()
        if (input.isNotBlank()) return input
        else println("Поле не может быть пустым. Попробуйте снова:")
    }
}
