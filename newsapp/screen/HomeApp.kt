package com.example.newsapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeApp(modifier: Modifier = Modifier, viewModel: NewsViewModel) {
         val res  = viewModel.res.value?.articles!!
         LazyColumn(modifier = Modifier.fillMaxSize().fillMaxWidth(),
             contentPadding = PaddingValues(12.dp),
             verticalArrangement = Arrangement.spacedBy(10.dp)
         ) {
             items(res){
                 val cardColors = CardDefaults.cardColors(
                     containerColor = Color.White
                 )
                 Card(
                     shape = RoundedCornerShape(12.dp),
                     colors = cardColors,
                     modifier = Modifier
                         .fillMaxWidth()
                         .shadow(8.dp)
                 ) {
                     Column {
                         AsyncImage(
                             model = it.urlToImage,
                             contentDescription = null,
                             contentScale = ContentScale.Crop,
                             modifier = Modifier
                                 .fillMaxWidth()
                                 .clip(RoundedCornerShape(8.dp))
                         )
                         if(!it.title.isNullOrEmpty())
                         Text(text = it.title,
                             style = TextStyle(
                                 fontSize = 16.sp,
                                 color = Color.Black
                             ),
                             textAlign = TextAlign.Center
                         )
                         if(!it.description.isNullOrEmpty())
                             Text(text = it.description,
                                 style = TextStyle(
                                     fontSize = 10.sp,
                                     color = Color.Black
                                 ),
                                 textAlign = TextAlign.Center
                            )

                     }
                 }
             }
         }
}