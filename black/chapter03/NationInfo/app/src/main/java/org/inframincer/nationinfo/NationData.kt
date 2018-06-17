package org.inframincer.nationinfo

/**
 * Created by yoon on 2018. 6. 17..
 */
data class NationData (
    var flagResId:Int,
    var name:String,
    var capital:String
)

data class NationDetailData (
    val name: String,
    val capital: String,
    val volume: String,
    val population: String,
    val language: String
)

data class GsonData(
    val data: ArrayList<NationDetailData>
)
