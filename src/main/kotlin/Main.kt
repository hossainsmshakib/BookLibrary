fun createBorrowerHistory(books: List<Books>, borrowers: List<Borrower>, newList: List<Int>): MutableMap<Int, Int> {
    val borrowerHistory = mutableListOf<BorrowerHistory>()
    val result = mutableMapOf<Int, Int>()
    var currentBook = 0
    for (userId in newList) {
        val borrower = borrowers.firstOrNull { it.borrowerId == userId }
        if (borrower != null) {
            if (currentBook >= books.size) {
                continue
            }
            borrowerHistory.add(BorrowerHistory(books[currentBook].bookId, borrower.borrowerId))
            result[userId] = books[currentBook].bookId
            currentBook++
        }
    }
    return result
}
fun main() {
    // create dummy of books
    val books = mutableListOf<Books>()
    for (i in 1..50) {
        books.add(Books(i, "Book $i", "Author $i"))
    }

    // borrower list without loop
    val borrowers = mutableListOf<Borrower>()
    for (i in 1..5) {
        borrowers.add(Borrower(i, "Borrower Name $i", i + 20))
    }

    val newList = listOf(100, 56, 5, 1, 2, 4, 25, 3, 1000)
    val borrowerHistory = createBorrowerHistory(books, borrowers, newList)
    for ((userId, bookId) in borrowerHistory) {
        println("BookId: $bookId assigned to UserId: $userId ")
    }
}

