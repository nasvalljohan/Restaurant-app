package com.nasvalljohan.myapplication

object Constants {
    const val BASE_URL = "https://food-delivery.umain.io/api/"
    val FILTERS = listOf(
        "5c64dea3-a4ac-4151-a2e3-42e7919a925d",
        "614fd642-3fa6-4f15-8786-dd3a8358cd78",
        "c67cd8a3-f191-4083-ad28-741659f214d7",
        "23a38556-779e-4a3b-a75b-fcbc7a1c7a20",
        "0017e59c-4407-453f-a5be-901695708015",
    )

    val filterToCategoryMap = mapOf(
        "5c64dea3-a4ac-4151-a2e3-42e7919a925d" to "Top Rated",
        "614fd642-3fa6-4f15-8786-dd3a8358cd78" to "Fast Food",
        "c67cd8a3-f191-4083-ad28-741659f214d7" to "Take Out",
        "23a38556-779e-4a3b-a75b-fcbc7a1c7a20" to "Fast Delivery",
        "0017e59c-4407-453f-a5be-901695708015" to "Eat-in",
    )
}
