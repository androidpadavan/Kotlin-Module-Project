import java.util.Scanner

class Archive(val name: String) {
    private val notes = mutableListOf<Note>()

    fun archiveMenu(menuHandler: MenuHandler) {
        menuHandler.showMenu("Меню архива '$name'", listOf(
            "Добавить заметку" to { addNote() },
            "Просмотреть заметки" to { viewNotes(menuHandler) }
        ))
    }

    fun addNote() {
        println("Введите название заметки:")
        val title = readNonEmptyInput()
        println("Введите текст заметки:")
        val content = readNonEmptyInput()
        notes.add(Note(title, content))
        println("Заметка '$title' добавлена.")
    }

    fun viewNotes(menuHandler: MenuHandler) {
        if (notes.isEmpty()) {
            println("Нет заметок в архиве.")
            return
        }

        menuHandler.showMenu("Выбор заметки", notes.map { it.title to { it.viewNote() } })
    }

    private fun readNonEmptyInput(): String {
        while (true) {
            val input = Scanner(System.`in`).nextLine()
            if (input.isNotBlank()) return input
            else println("Поле не может быть пустым. Попробуйте снова:")
        }
    }
}