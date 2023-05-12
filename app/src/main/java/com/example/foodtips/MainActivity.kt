package com.example.foodtips

import android.os.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.foodtips.DataSource.*
import com.example.foodtips.model.*
import com.example.foodtips.ui.theme.FoodTipsTheme
import javax.sql.DataSource

class MainActivity : ComponentActivity()
{
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent {
            FoodTipsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(topBar = {
                    TopAppBar(
                            
                            title = {
                                Row(
                                        modifier = Modifier.fillMaxWidth(0.959f).background(Color(0xFFFFFFFF)),
                                        verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                            imageVector = Icons.Default.FoodBank,
                                            contentDescription = null,
                                            modifier = Modifier.size(64.dp),
                                            tint = Color.Black
                                    )
                                    Text(
                                            text = "FruTips",
                                            style = MaterialTheme.typography.titleMedium
                                    )
    
                                }
                            },
                            
                    )
                    }
                    ) { values ->
                        FoodsCardList(FoodsData().loadFoodCards(),values)
                    
                
                }
            }
        }
    }
}

@Composable
fun FoodCardInterface(foodCards: FoodCards){
    
    var expanded by remember {
        mutableStateOf(false)
    }
    
    Card(
            modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_medium))
                    .height(
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S)
                            {
                                if (!expanded) dimensionResource(id = R.dimen.card_height_android_greater_than_12) else dimensionResource(
                                        id = R.dimen.card_expanded_height_android_greater_than_12
                                )
                            } else
                            {
                                if (!expanded) dimensionResource(id = R.dimen.card_height_android_less_than_13) else dimensionResource(
                                        id = R.dimen.card_expanded_height_android_less_than_13
                                )
                            }
        
                    ),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            
        
            ) {
        Box(modifier = Modifier
                .fillMaxSize()
                .background(
                
                        brush = Brush.verticalGradient(
                                colors = if (expanded)
                                {
                                    listOf(
                                    
                                            Color(0xFFF6BFDD),
                                            Color(0xFFD3C0F0),
                                    
                                            )
                                } else
                                {
                                    listOf(
                                            Color(0xFFf1e8fa),
                                            Color(0xFFf1e8fa),
                                    )
                            
                                }
                
                        )
        
                )
        ) {
    
            Column(
                    modifier = Modifier
                            .padding(dimensionResource(id = R.dimen.padding_medium))
            ) {
                Image(
                        painter = painterResource(id = foodCards.imageRes),
                        contentDescription = stringResource(id = foodCards.nameRes),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(topStart = 29.dp, bottomEnd = 29.dp))
                                .height(dimensionResource(id = R.dimen.image_height))
                )
                Text(
                        text = stringResource(id = foodCards.nameRes),
                        style = MaterialTheme.typography.bodyLarge
                )
        
                Text(
                        text = stringResource(id = foodCards.Description),
                        style = MaterialTheme.typography.bodyMedium
                )
        
                Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                            text = stringResource(id = R.string.see_all_benefits),
                            style = MaterialTheme.typography.headlineMedium
                    )
                    FoodItemButton(
                            expanded,
                            onClick = { expanded = !expanded },
                            modifier = Modifier
                    )
                }
        
                Spacer(modifier = Modifier.height(6.dp))
        
                Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                            text = stringResource(id = foodCards.Benifits),
                            style = MaterialTheme.typography.bodySmall
                    )
                }
        
            }
        }
    }
}

@Composable
fun FoodItemButton(expanded : Boolean,onClick :() -> Unit,modifier: Modifier)
{
    
    IconButton(onClick = onClick) {
        
        Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = null
        )
        
    }
    
}

@Composable
fun FoodsCardList(foods: List<FoodCards>,values: PaddingValues){
    LazyColumn(contentPadding = values){
        items(foods){
            food ->
            FoodCardInterface(foodCards = food)
        }
    }
}


@Preview(showSystemUi = false, showBackground = false)
@Composable
fun GreetingPreview()
{
    FoodTipsTheme {
        
        FoodCardInterface(foodCards = FoodCards(
                imageRes = R.drawable.kiwi,
                nameRes = R.string.food4,
                Benifits = R.string.food4_benefits,
                Description = R.string.food4_description
        ))
    }
}}