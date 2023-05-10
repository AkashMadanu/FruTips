package com.example.foodtips.DataSource

import com.example.foodtips.*
import com.example.foodtips.model.*

class Foods
{
    fun loadFoodCards() : List<FoodCards>
    {
        return listOf<FoodCards>(
                FoodCards(R.drawable.banana,R.string.food1,R.string.food1_description,R.string.food1_benefits),
                FoodCards(R.drawable.dragon,R.string.food2,R.string.food2_description,R.string.food2_benefits),
                FoodCards(R.drawable.grapes,R.string.food3,R.string.food3_description,R.string.food3_benefits),
                FoodCards(R.drawable.kiwi,R.string.food4,R.string.food4_description,R.string.food4_benefits),
                FoodCards(R.drawable.mango,R.string.food5,R.string.food5_description,R.string.food5_benefits),
                FoodCards(R.drawable.papaya,R.string.food6,R.string.food6_description,R.string.food6_benefits),
                FoodCards(R.drawable.pinapple,R.string.food7,R.string.food7_description,R.string.food7_benefits),
        )
    }
}