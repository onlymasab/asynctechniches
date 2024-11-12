package org.example


data class Item(val name: String)
data class Token(val value : String = "example token")
data class Post(val content: String = "example post")


fun main() {

    val item = Item(name = "Example Item")

    postItem(item = item)

}



fun postItem(item: Item) {
    Thread {
        val token = preparePost()
        val post = submitPost(token, item)
        processPost(post)
    }.start()
}

fun preparePost(): Token {
    // makes a request and consequently blocks the main thread
    println("Preparing token .....")
    Thread.sleep(1000)
    return Token(value = "example token")
}


fun submitPost(token: Token, item: Item) : Post {
    println("Submitng the Post of item: ${item.name} and token: ${token.value}")
    Thread.sleep(1500)
    return  Post("Post content: ${item.name}")
}

fun processPost(post: Post) {
    println("Proccess post: ${post.content}")
}