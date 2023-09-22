import java.io.File

val hangman = listOf("""
     _______
     |      |
     |      0
     |     /|\
     |     / \
     |  
     ________
""".trimIndent(),
        """
     _______
     |      |
     |      0
     |     /|\
     |     / 
     |  
     ________
""".trimIndent(),"""
     _______
     |      |
     |      0
     |     /|\
     |     
     |  
     ________
""".trimIndent(),"""
     _______
     |      |
     |      0
     |     /|
     |   
     |  
     ________
""".trimIndent(),"""
     _______
     |      |
     |      0
     |     /
     |     
     |  
     ________
""".trimIndent(),"""
     _______
     |      |
     |      0
     |     
     |     
     |  
     ________
""".trimIndent(),"""
     _______
     |      |
     |      
     |     
     |     
     |  
     ________
""".trimIndent(),"""
     _______
     |      
     |     
     |     
     |     
     |  
     ________
""".trimIndent(),"""
     
     |      
     |      
     |     
     |     
     |  
     ________
""".trimIndent())
fun main(){
    val word = File("words.txt").readLines().random()
    var status = ".".repeat(word.length).toCharArray()
    var life = hangman.lastIndex

    println(word)
    println(status)
    println(life)

    while(life > 0 && String(status) != word){
        println(hangman[life])
        println(status)

        var input = readLine()!!


        if (input.length > 1){
            if (input == word){
                status = input.toCharArray()
            }else life--
        } else if (input in word){
            word.forEachIndexed { index, c ->
                if (c in input){
                    status[index] = c
                }
            }
        } else life--

    }

    println("---------------------------------------------------")

    if (life > 0 ) {
        println("GGWP")
    }
    else println("""
           //// GAME OVER ///
              _______
              |      |
              |      0
              |     /|\
              |      8===D
              |     / \
              |  
              ________
  
    """.trimIndent())
}