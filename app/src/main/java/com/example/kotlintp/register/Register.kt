package com.example.kotlintp.register

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlintp.R
import com.example.kotlintp.auth.LoginActivity
import com.example.kotlintp.common.AppContextHelper
import com.example.kotlintp.ui.theme.IconDesign
import com.example.kotlintp.ui.theme.InputButton
import com.example.kotlintp.ui.theme.KotlinTpTheme
import com.example.kotlintp.ui.theme.TemplatePage
import com.example.kotlintp.ui.theme.TextDesign
import com.example.kotlintp.ui.theme.TextFieldDesign
import kotlinx.coroutines.flow.MutableStateFlow

class Register : ComponentActivity() {

    lateinit var viewModel: MutableStateFlow<UserViewModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        viewModel = MutableStateFlow(
            UserViewModel(
                email = "vv@vv.com",
                pseudo = "vivi",
                password = "password",
                passwordConfirm = "password",
                cityCode = "44000",
                city = "SLVJSD",
                phone = "0234893563"
            )
        )
        setContent {
            RegisterPage(viewModel)
        }
    }
}

@Composable
fun RegisterPage(viewModel: MutableStateFlow<UserViewModel>) {
    val context = LocalContext.current

    val viewModelState by viewModel.collectAsState()

    TemplatePage {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)

        ) {
            IconDesign(R.drawable.bloc_note, 50)
            TextDesign(stringResource(R.string.text_register_intro))
            TextFieldDesign(
                label = stringResource(R.string.field_pseudo_hint),
                value = viewModelState.pseudo,
                onValueChange = { value -> viewModel.value = viewModel.value.copy(pseudo = value) })
            TextFieldDesign(
                label = stringResource(R.string.field_email_hint),
                value = viewModelState.email,
                onValueChange = { value -> viewModel.value = viewModel.value.copy(email = value) })
            TextFieldDesign(
                label = stringResource(R.string.field_password_hint),
                value = viewModelState.password,
                onValueChange = { value ->
                    viewModel.value = viewModel.value.copy(password = value) })
            TextFieldDesign(
                label = stringResource(R.string.field_confirm_password_hint),
                value = viewModelState.passwordConfirm,
                onValueChange = { value ->
                    viewModel.value = viewModel.value.copy(passwordConfirm = value) })
            TextFieldDesign(
                label = stringResource(R.string.field_city_code_hint),
                value = viewModelState.cityCode,
                onValueChange = { value ->
                    viewModel.value = viewModel.value.copy(cityCode = value) })
            TextFieldDesign(
                label = stringResource(R.string.field_city_hint),
                value = viewModelState.city,
                onValueChange = { value -> viewModel.value = viewModel.value.copy(city = value) })
            TextFieldDesign(
                label = stringResource(R.string.field_phone_hint),
                value = viewModelState.phone,
                onValueChange = { value -> viewModel.value = viewModel.value.copy(phone = value) })
            Spacer(modifier = Modifier.size(20.dp))
            InputButton(
                onClick = {
                    viewModelState.callSignUpApi(context)
                },
                stringResource(R.string.btn_sign_in)
            )
            TextDesign(stringResource(R.string.text_accept_policy))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    KotlinTpTheme {
        val viewModel = MutableStateFlow(
            UserViewModel(
                email = "vv@vv.com",
                pseudo = "vivi",
                password = "password",
                passwordConfirm = "password",
                cityCode = "44000",
                city = "SLVJSD",
                phone = "0234893563"
            )
        )
        RegisterPage(viewModel)
    }
}