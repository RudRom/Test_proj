fun main() {
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
    var mounth = ""
    var resultWrongMonths = "Month with corrupted data: "
    //for (i in 0 until 4)
    //    println(data.filter { it.value.all { it >= 0 } }.map { it.value }[i])
    for (i in 0 until data.filter { it.value.all { it >= 0 } }.size){
        for(j in 0 until 4)
            temp += data.filter { it.value.all { it >= 0 } }.map { it.value}[i][j]
        monthlyProfit.add(temp)
        temp = 0
    }
    for ((key, value) in data){
        if (temp < value.sum()) {
            temp = value.sum()
            mounth = key
        }
    }
    for ((key, value) in data.filter { it.value.any { it < 0 }}){
        resultWrongMonths += "$key, "
    }

    monthlyProfit.sortDescending()
    println("Medium weekly profit: ${data.filter { it.value.all { it >= 0} }.flatMap{ it.value }.average()}")
    println("Medium monthly profit: ${monthlyProfit.average()}")
    println("Max monthly profit: ${monthlyProfit[0]}")
    println("Max monthly profit were in $mounth")
    for ((key, value) in data){
        if (temp > value.sum()) {
            temp = value.sum()
            mounth = key
        }
        if (temp == 0)
            temp = value.sum()
    }
    println("Min monthly profit: ${monthlyProfit.last()}")
    println("Min monthly profit were in $mounth")
    println(resultWrongMonths.substring(0, resultWrongMonths.length - 2))


}