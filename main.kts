println("UW Complex Kotlin homework")

// write a lambda using map and fold to solve "FIZZBUZZ" for the first fifteen numbers (0..15)
// use map to return a list with "", "FIZZ" or "BUZZ" as necessary
// use fold to compress the array of strings down into a single string
// the final string should look like FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ
//
val mapFoldResults = (1..15).filter{
    it % 3 == 0 || it % 5 == 0
}
.map { value -> 
    if (value % 3 == 0 && value % 5 == 0) {
        "FIZZBUZZ"
    } else if (value % 3 == 0) {
        "FIZZ"
    } else {
        "BUZZ"
    }
}
.fold("", {word, next -> "${word}" + "${next}"})

// This is a utility function for your use as you choose, and as an
// example of an extension method
fun Int.times(block: () -> Unit): Unit {
    for (it in 1..this) {
        block()
    }
}

// Use this function
fun process(message: String, block: (String) -> String): String {
    return ">>> ${message}: {" + block(message) + "}"
}

// call process() with message "FOO" and a block that returns "BAR"
val r1 = process("FOO",
    { message: String ->
        if (message == "FOO") {
            "BAR"
        } else {
            "WRONG"
        }
    }
) 

// call process() with message "FOO" and a block that upper-cases 
// r2_message, and repeats it three times with no spaces: "WOOGAWOOGAWOOGA"
val r2_message = "wooga"
val r2 = process("FOO", 
    { message: String ->
        if (message == "FOO") {
            r2_message.toUpperCase().repeat(3)
        } else {
            "WRONG"
        }
    }
) 

// write an enum-based state machine between talking and thinking
enum class Philosopher {
    THINKING {
        override fun signal() = TALKING
        override fun toString() = "Deep thoughts...."
    },

    TALKING {
        override fun signal() = THINKING
        override fun toString() = "Allow me to suggest an idea..."
    };
    
    abstract fun signal(): Philosopher
}

// create an class "Command" that can be used as a function (provide an "invoke()" function)
// that takes a single parameter ("message" of type String)
// primary constructor should take a String argument ("prompt")
// when called, the Command object should return a String containing the prompt and then the message
class Command(val prompt: String) {
    operator fun invoke(message: String): String {
        return("${prompt}" + "${message}")
    }
}

/* EXTRA CREDIT:
    1) Seneca the Younger was a Roman philosopher, statesman, dramatist, and satirist. His plays 
       were all categorized as tragedies, and his essays dealt with moral issues.
    2) He is most often associated with the School of Stoicism.
    3) The School of Stoicism is a way of life by being pragmatic to overcome destructive emotions.
*/

// ================================
println("map fold test: " + if (mapFoldResults == "FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ") "." else "!")

println("r1 test: " + if (r1 == ">>> FOO: {BAR}") "." else "!")
 
println("r2 test: " + if (r2 == ">>> FOO: {WOOGAWOOGAWOOGA}") "." else "!")

var seneca = Philosopher.THINKING
print("Seneca, talk! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Allow me to suggest an idea...") "." else "!")
print("Seneca, think! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Deep thoughts....") "." else "!")
print("Seneca, talk! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Allow me to suggest an idea...") "." else "!")

print("Command tests: ")
print(if (Command("")("") == "") "." else "!")
print(if (Command("> ")("Hello!") == "> Hello!") "." else "!")
println("")

