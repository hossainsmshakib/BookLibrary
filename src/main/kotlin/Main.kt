//private val Int.bookId: Int
//    get() {return bookId}
//
//fun createBorrowerHistory(books: Int, borrower: Borrower): BorrowerHistory {
//    return BorrowerHistory(books.bookId, borrower.borrowerId)
//}

fun getBorrowerHistory(books: List<Books>, borrowers: List<Borrower>): List<BorrowerHistory> {
    val borrowerHistory = mutableListOf<BorrowerHistory>()
    for (book in books) {
        for (borrower in borrowers) {
            // Check if borrower has borrowed the book
            if (borrower.borrowerId == book.bookId) {
                borrowerHistory.add(BorrowerHistory(book.bookId, borrower.borrowerId))
                break
            }
        }
    }
    return borrowerHistory
}
fun main(args: Array<String>) {
    val books = mutableListOf<Books>()
    for (i in 1..5) {
        books.add(Books(i, "Book $i", "Author $i"))
    }

    val borrowers = listOf(
        Borrower(1, "Borrower 1", 21),
        Borrower(2, "Borrower 2", 22),
        Borrower(3, "Borrower 3", 23)
    )

//    val borrowerHistory = mutableListOf<BorrowerHistory>()
//    for (book in books) {
//        for (borrower in borrowers) {
//            // Check if borrower has borrowed the book
//            if (borrower.borrowerId == book.bookId) {
//                borrowerHistory.add(BorrowerHistory(book.bookId, borrower.borrowerId))
//            }
//            else {
//                continue
//            }
//        }
//    }
//    for (history in borrowerHistory) {
////      println("Borrower History: $borrowerHistory")
//        println("BookId: ${history.bookId} BorrowerId: ${history.borrowerId}")
//    }
    val borrowerHistory = getBorrowerHistory(books, borrowers)
    for (history in borrowerHistory) {
        println("BookId: ${history.bookId} BorrowerId: ${history.borrowerId}")
    }
}
