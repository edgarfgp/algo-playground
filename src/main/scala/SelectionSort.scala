import scala.collection.mutable.ArrayBuffer

object SelectionSort {


    // For this algorithm we wil need differentiate between:
    // Arrays and LinkedList
    // Arrays have a fast reads and slow inserts
    // Linked Lists has a slow reads and faster insets
    // Linked list are better if you add an element to the middle
    // List are also better if you want to delete an item.
    // O(n) => Linear time
    // O(1) => constant time
    // It is a good practice in Linked lists to keep track of the first and last element
    // So it will take O(1) to delete them

    // Arrays allows random access and sequential access(reading elements one by one)
    // Linked list can only do sequential access. If you want to read the 10th element you have to first read the first 9th


    // There is a hybrid data structure Array of linked lists
    // Searching ==> This new data structure is slower for reading than the Arrays but faster  reading than the Linked list
    // Inserting ==> faster than array for inserting and the the same amount of time for linked list

    def findSmallestIndexForElement(array: ArrayBuffer[Int]): Int = {
        var smallest = array(0)
        var smallestIndex = 0
        for(index <- Array.range(1, array.length)) {
            if(array(index) < smallest) {
                smallest = array(index)
                smallestIndex = index
            }
        }

        smallestIndex
    }

    def selectionSort(array: ArrayBuffer[Int]): ArrayBuffer[Int] = {
        val newArr: ArrayBuffer[Int] = ArrayBuffer()
        for(_ <- array) {
            val smallest = findSmallestIndexForElement(array)
            newArr.addOne(array(smallest))
            array.remove(smallest)
            array.trimToSize()
        }

        newArr
    }

    def main(args: Array[String]): Unit = {
        val result = selectionSort(ArrayBuffer(5,3,6,2,10))
        println(result)
    }

    // Recap :
    // Your computer's memory is like a giant set of drawers
    // Array allows fast read
    // Linked list and list in general allow fast inserts and deletes
}
