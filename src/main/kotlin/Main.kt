fun createBorrowerHistory(books: List<Books>, borrowers: List<Borrower>, newList: List<Int>): MutableMap<Int, Int> {
    val result = mutableMapOf<Int, Int>()

    for (i in 0 until books.size) {
        val bookId = books[i].bookId
        if (i >= newList.size) {
            continue
        }
        val userId = newList[i]
        val borrower = borrowers.firstOrNull { borrower -> borrower.borrowerId == userId }
        if (borrower == null) {
            continue
        }
        result[userId] = bookId
    }
    return result
}
fun main() {
    // create dummy of books
    val books = mutableListOf<Books>()
    for (i in 1..5) {
        books.add(Books(i, "Book $i", "Author $i"))
    }

    // borrower list without loop
    val borrowers = mutableListOf<Borrower>()
    for (i in 1..5) {
        borrowers.add(Borrower(i, "Borrower Name $i", i + 20))
    }

    val newList = listOf(10, 12, 1, 2, 3)
    val borrowerHistory = createBorrowerHistory(books, borrowers, newList)
    for ((userId, bookId) in borrowerHistory) {
        println("BookId: $bookId assigned to UserId: $userId")
    }
}
