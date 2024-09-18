class Note(val title: String, private val content: String) {

    fun viewNote() {
        println("\nЗаметка: $title")
        println(content)
    }
}
