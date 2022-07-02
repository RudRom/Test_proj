fun main(args: Array<String>) {
    val datas = mapOf (
        "Jan" to listOf(100,100,100,100),
        "Feb" to listOf(200,200,-190,200),
        "March" to listOf(300,180,300,100),
        "April" to listOf(250,-250,100,300),
        "May" to listOf(200,100,400,300),
        "June" to listOf(200,100,300,300)
    )
    printInfo (datas)
}
fun printInfo (data: Map<String, List<Int>>){
    val monthlyProfit = MutableList<Int>(0){0}
    var temp = 0
    //for (i in 0 until 4)
    //    println(data.filter { it.value.all { it >= 0 } }.map { it.value }[i])
    for (i in 0 until data.filter { it.value.all { it >= 0 } }.size){
        for(j in 0 until 4)
            temp += data.filter { it.value.all { it >= 0 } }.map { it.value}[i][j]
        monthlyProfit.add(temp)
        temp = 0
    }
    println("Medium weekly profit: ${data.filter { it.value.all { it >= 0} }.flatMap{ it.value }.average()}")
    println("Medium monthly profit: ${monthlyProfit.average()}")
    println("Max monthly profit: ${1}")
    println("Max monthly profit were in ${1}")
    println("Min monthly profit: ${1}")
    println("Min monthly profit were in ${1}")
    println("Month with corrupted data: ${1}")


}