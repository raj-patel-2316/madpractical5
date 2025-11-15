package com.example.madpractical5.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.madpractical5.R

@Composable
fun RegisterPage(onLoginClick: () -> Unit = {}) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = R.drawable.guni_pink_logo),
            contentDescription = "GUNI Logo",
            modifier = Modifier
                .height(130.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                FormRowField(labelString = "Name")
                FormRowField(labelString = "Phone Number", isNumber = true)
                FormRowField(labelString = "City")
                FormRowField(labelString = "Email")
                FormRowField(labelString = "Password", isPasswordField = true)
                FormRowField(labelString = "Confirm Password", isPasswordField = true)
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = {
                        Toast.makeText(context, "Registration Clicked!", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Register", fontSize = 18.sp)
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Do you have an account?",
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
            TextButton(onClick = onLoginClick) {
                Text(
                    text = "LOGIN",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
fun FormRowField(
    labelString: String,
    isNumber: Boolean = false,
    isPasswordField: Boolean = false
) {
    val inputValue = remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = labelString, fontSize = 18.sp, modifier = Modifier.weight(1f))
        OutlinedTextField(
            value = inputValue.value,
            onValueChange = { inputValue.value = it },
            placeholder = { Text("Enter $labelString") },
            modifier = Modifier
                .weight(2f)
                .padding(start = 16.dp),
            keyboardOptions = if (isNumber) KeyboardOptions(keyboardType = KeyboardType.Phone) else KeyboardOptions.Default,
            visualTransformation = if (isPasswordField) PasswordVisualTransformation() else VisualTransformation.None
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegisterPage() {
    RegisterPage()
}
