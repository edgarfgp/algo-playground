import scala.annotation.tailrec

object Recursion {

    // When you write a recursive function you have to tell it when to stop recursing. That is WHY every recursion function
    // Has to parts :
        // The Base case when the function does not call itself. So it does not going into infinite loop
        // The Recursive case => this is where the function calls itself

    @tailrec
    def countDown(number: Int): Unit = {
        println(number)
        if(number <= 1){
            return
            // Base case . It prevent got this to go into a infinite loop
        }else{
            countDown(number-1) // Recursive case
        }
    }

    // THe Stack
    // Recursive function uses a call stack  also
    // Stack has to operations . PUSH and POP
    // All function calls go onto the call stack
    // The call stack can get very large, which takes a lot of memery
    // an infinite look will eventually cause a StackOverflow exception

    // factorial(5) =>  5! = 5 * 4 * 3 * 2 * 1
    // factorial(3) =>  3! = 3 * 2 * 1
    def fact(x: Int) : Int = {
        if(x == 1) {
            println(x)
            1
        }else{
            println(x)
            // Note that each call of the fact method has it is owm copy of x
            (x * fact(x-1))
        }
    }


    def main(args: Array[String]): Unit = {
        //countDown(100)
        fact(30)
    }
}
