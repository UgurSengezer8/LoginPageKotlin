package com.example.loginpage.View

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.loginpage.MainActivity
import com.example.loginpage.ViewModel.MainViewModel
import com.example.loginpage.ui.theme.LoginPageTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage() {
    val txtKullaniciAdi = remember{ mutableStateOf("")}
    val txtSifre = remember{ mutableStateOf("")}
    val viewModel = MainViewModel()
    val mainActivity = MainActivity()
    Column( Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(text = "LOGİN",
            modifier = Modifier
                .align(CenterHorizontally),
            fontSize = 65.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            style = TextStyle(color = Color(133,49,198), shadow = Shadow(color = Color(103,19,168), offset = Offset(6f,5f),)),
        )
        Spacer(modifier = Modifier.padding(30.dp))
        TextField(
            value = txtKullaniciAdi.value,
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Email Icon")},
            onValueChange = {newText->
            txtKullaniciAdi.value=newText
        }, label = { Text(text = "KullacıAdı")},
            placeholder = { Text(text = "Enter Your Password")},
            modifier = Modifier.fillMaxWidth(0.85f))
        Spacer(modifier = Modifier.padding(30.dp))
        TextField(
            value = txtSifre.value,
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "Email Icon")},
            onValueChange = { newText->
            txtSifre.value=newText
        },
            label = { Text("Şifre", fontSize = 20.sp) },
            placeholder = { Text(text = "Enter Your Password")},
            modifier = Modifier.fillMaxWidth(0.85f)
        )
        Spacer(modifier = Modifier.padding(30.dp))
        Button(
            onClick = {
                if (txtSifre.value.isNotEmpty()&&txtKullaniciAdi.value.isNotEmpty()){
                    println("İşlem Başarılı")
                }else{
                    println("İşlem Başarısız")
                }
            },
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(103,19,168)
            )
        ) {
            Text(text = "Login", fontSize = 25.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginPageTheme {
        MainPage()
    }
}