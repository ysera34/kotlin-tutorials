package org.inframincer.weathercast.data

import java.util.*

data class CityArray(val city: ArrayList<CityData>)
data class CityData(val _id: String, val name: String)
