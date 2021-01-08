import Array._

object QuickSort {

    // Divide and conquer

    // This algo is much faster than Selection Search
    //Divide and conquer algorithms are recursive.
    // Steps :
        // 1.- Figure out the base case, This should be the simplest possible case (Base case)
        // 2.- Divide or decrease you problem until it becomes a base case(Recursive case)
    // Divide and Conquer is not an easy algorithm that you can apply to a problem.
    // Instead is a way to think about a problem

    // When you are writing a recursive function that involves an array , the base case is an empty array or an array with one
    // element

    def sumAllImperative(array: Array[Int]) : Int = {
        var total = 0
        for(index <- array.indices){
            total = total + array(index)
        }

        total
    }

    def sumAllFunctional(array: Array[Int]) : Int = {
        array.sum
    }

    def sumAllRecursive(array: Array[Int]) : Int = {
        if(array.isEmpty){
            0
        }else{
            array(0) + sumAllRecursive(array.slice(1, array.length))
        }
    }

    def listCountRecursive(list: List[Int]) : Int = {
        if(list.isEmpty){
            0
        }else{
            1 + listCountRecursive(list.slice(1, list.length))
        }
    }

    def findMaxNumber(list: List[Int]) : Int = {
        if(list.length == 2) {
            if(list.head > list(1)) {
                return list.head
            }else {
                return list(1)
            }
        }

        val subMax = findMaxNumber(list.slice(1, list.length))
        if(list.head > subMax){
            list.head
        }else {
            subMax
        }
    }

    // First : Pick an element from the array. This element is called pivot
    // Second: Find the element smaller than the pivot and the element larger than the pivot
    // Third : Partitioning =>
        // SubArray of all the numbers less than the pivot
        // The pivot
        // SubArray of all elements greater than the pivot
        // The 2 SubArrays are not sorted. They are just partitioned
        // If the SubArray were sorted, then you can just combine the whole think like left [] + pivot + right []
    // How you sort the SubArrays ?
        // QuickSort already knows how to sort arrays of two elements

    def quickSort(array: Array[Int]) : Array[Int] = {
        if(array.length < 2) {
            array // Base case . Array already sorted
        }else {
            val pivot = array(0)
            val less = array.filter(i => i < pivot)
            val greater = array.filter (i => i > pivot)
            concat(quickSort(less), Array(pivot), quickSort(greater))
        }
    }

    def quickSortFunc(list: List[Int]): List[Int] = {
        list match {
            case Nil        => Nil
            case a :: Nil   => List(a)
            case a :: tail  => quickSortFunc(tail.filter(x=> x <= a)) ::: List(a) ::: quickSortFunc(tail.filter(x => x > a))
        }
    }


    def main(args: Array[String]): Unit = {
//        println(sumAllImperative(Array(1,2,3,4)))
//        println(sumAllFunctional(Array(1,2,3,4)))
//        println(sumAllRecursive(Array(1,2,3,4)))
//        println(listCountRecursive(List(1,2,3,4)))
//        println(findMaxNumber(List(1,2,3,4, 10)))
//        quickSort(Array(9, 8, 6, 99, 13, 1, 10)).foreach(println)
        quickSortFunc(List(9, 8, 6, 99, 13, 1, 10)).foreach(println)
    }

}
