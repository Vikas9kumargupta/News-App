package com.example.newsapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen
import com.example.newsapp.ui.theme.NewsAppTheme
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                SplashScreen()
            }
        }
    }


    @Preview
    @Composable
    private fun SplashScreen(){
        LaunchedEffect(key1 = true, block =  {
            delay(3000)
            startActivity(Intent(this@SplashActivity,
                MainActivity::class.java ))
            finish()
        })
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffffffff)),
            contentAlignment = Alignment.Center)
        {
            Image(painter= painterResource(id = R.drawable.img),
                contentDescription = null,
                modifier = Modifier.align(Alignment.Center)
            )

        }
    }
}