package com.example.foodtips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.foodtips.model.*
import com.example.foodtips.ui.theme.FoodTipsTheme

class MainActivity : ComponentActivity()
{
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
    
                    FoodCardInterface(foodCards = FoodCards(
                            imageRes = R.drawable.kiwi,
                            nameRes = R.string.food4,
                            Benifits = R.string.food4_benefits,
                            Description = R.string.food4_description
                    ))
                
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
    
    Card(modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_medium))
            .height(500.dp)
            
            ,
    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    
            ) {
        Column(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
        

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
            Text(text = stringResource(id = foodCards.nameRes), style = MaterialTheme.typography.bodyLarge)
            Text(text = stringResource(id = foodCards.Description), style = MaterialTheme.typography.bodyMedium)
            
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(id = foodCards.Benifits), style = MaterialTheme.typography.bodyMedium)
                FoodItemButton(expanded, onClick = { expanded = !expanded},modifier = Modifier)
                
            }
        }
    }
}

@Composable
fun FoodItemButton( expanded : Boolean,onClick :() -> Unit,modifier: Modifier)
{
    
    IconButton(onClick = onClick) {
        
        Icon(imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore, contentDescription = null)
        
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
}