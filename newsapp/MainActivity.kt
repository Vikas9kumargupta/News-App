package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsapp.network.ApiProvider
import com.example.newsapp.screen.HomeApp
import com.example.newsapp.screen.NewsViewModel
import com.example.newsapp.ui.theme.NewsAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel: NewsViewModel by viewModels()
        setContent {
            NewsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "News App") },
                            navigationIcon = {
                                IconButton(onClick = { /*TODO*/ },
                                    ) {
                                    Image(painter = painterResource(id = R.drawable.img),
                                        contentDescription = "News App"
                                    )
                                }
                            },
                        ) },
                   )
                { innerPadding ->
                    Box (modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                        .border(1.dp, Color.Black)
                        .shadow(8.dp)
                        .padding(8.dp))
                    {
                        if(viewModel.res.value == null){
                            Column(modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center)
                            {
                                CircularProgressIndicator()
                            }
                        }else {
                            HomeApp(viewModel = viewModel)
                        }
                    }
                }
            }
        }
    }
}