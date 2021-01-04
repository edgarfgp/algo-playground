

object BinarySearch extends App {

    // Notes:
    // Binary search only works when your list is sorted
    // Binary search returns the position where is located. Otherwise returns null
    // When you search for an element using simple search in the worst case you might have to look at every single element
    // Simple search runs in a linear time
    // Binary search runs in a logarithmic time (log time)
    // When using Binary search you have to check t her logn in the worst case.
    // For example for a list of 8 elements Log 8 == 3, because 2 epx 3 == 8
    def binarySearch(list : List[Int], item: Int): Int = {
        var guess = 0
        var high = list.length - 1
        var mid = 0
        var low = 0
        while (low <= high) {
            mid = (low + high) / 2
            guess = list(mid)
            if(guess == item) return mid
            if(guess > item)
                high = mid - 1
            else
                low = mid + 1
        }

        null
    }

    println(binarySearch(List.range(1, 1000000), 999))

    // Question: For a list of  128 sorted names . What is the maximum number of steps that it would take ?
    // Answer:  Log2 of 128 = 2 exp 7 -> 7 Steps
    // 128 | 2
    // 64  | 2
    // 32  | 2
    // 16  | 2
    // 8   | 2
    // 4   | 2
    // 2   | 2
    // 1   |

    // Question :  What about if you double the size of the list to 256 ?
    // Answer: Log2 of 256 = 2 exp 8 -. 8 Steps
    // 256 | 2
    // 128 | 2
    // 64  | 2
    // 32  | 2
    // 16  | 2
    // 8   | 2
    // 4   | 2
    // 2   | 2
    // 1   |


    // Recap
    // Binary search is a lot faster than Simple search
    // O(logn) is faster than O(n) , but it gets faster once the list of items you are searching through grows
    // BigO notation is about the worst case scenario
    // BigO -> Big notation tells you how fast an algorithm grows
    // For Simple search the BigO running time can be expressed as O(n)
    // For Binary search can be expressed as O(logn)
    // Algorithms speed is not measured in seconds
    // Algorithms times are measured in terms of growth of an algorithm

}
