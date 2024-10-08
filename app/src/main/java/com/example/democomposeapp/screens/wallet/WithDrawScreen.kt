package com.example.democomposeapp.screens.wallet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.democomposeapp.R

@Preview(heightDp = 700, widthDp = 350, showBackground = true)
@Composable
fun WithDrawPreview() {
    WithDraw()
}

@Composable
fun WithDraw() {
    Scaffold(
        modifier = Modifier
            .background(color = Color.White)
            .padding(top = 30.dp, bottom = 50.dp),
        content = {
            it
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxHeight()
            ) {
                WithDrawToolBarFunc()
                WithDrawContainScreen()
            }
        }
    )
}

@Composable
fun WithDrawToolBarFunc() {
    ConstraintLayout(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth()
            .height(55.dp)
    ) {
        val (userImage, name) = createRefs()

        Image(painter = painterResource(id = R.drawable.arrow_back_24px),
            contentDescription = "",
            modifier = Modifier
                .padding(start = 10.dp)
                .height(28.dp)
                .width(28.dp)
                .constrainAs(userImage) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                })

        Text(text = "Back",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.W600,
                color = colorResource(id = R.color.wallet_text_color)

            ),
            modifier = Modifier
                .padding(10.dp)
                .constrainAs(name) {
                    start.linkTo(userImage.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WithDrawContainScreen() {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(25.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.White)
    ) {

        Text(
            text = "Withdraw Coins",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.W600,
                color = colorResource(id = R.color.wallet_text_color),
                // fontFamily = FontFamily(Font(R.font.montserratalternates_regular)),
            )
        )

        Text(
            text = "Enter Amount",
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.W400,
                color = colorResource(id = R.color.text_gray_color)
            ),
            modifier = Modifier
                .padding(top = 10.dp)
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                //.padding(top = 4.dp)
                .background(
                    color = Color.Transparent,
                    RoundedCornerShape(4)
                )

                .drawWithContent {
                    drawContent()
                },
            enabled = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Number,
                autoCorrect = false,
            ),

            singleLine = true,
            maxLines = 1,
            value = "00.00",
            onValueChange = {

            },
            textStyle = TextStyle(
                fontSize = 36.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W400,
                color = colorResource(id = R.color.offer_bt_color)
            ),

            colors = TextFieldDefaults.outlinedTextFieldColors(
                cursorColor = Color.LightGray,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),

            placeholder = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "00.00",
                    style = TextStyle(
                        fontSize = 36.sp,
                        textAlign = TextAlign.Start,
                        color = colorResource(id = R.color.light_gray)
                    )
                )
            },
        )

        Box(
            modifier = Modifier
                .width(150.dp)
                .height(2.dp)
                .background(color = colorResource(id = R.color.offer_bt_color))
        )

        Text(
            text = "Min amount 50 Coins",
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.W500,
                color = colorResource(id = R.color.text_gray_color)
            ),
            modifier = Modifier
                .padding(top = 25.dp)
        )

        Text(
            text = "1000 Points = 1000 Coins",
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.W500,
                color = colorResource(id = R.color.text_gray_color)
            ),
            modifier = Modifier
                .padding(top = 20.dp)
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(top = 60.dp)
                .fillMaxWidth()
                .height(45.dp)
                .background(
                    color = colorResource(R.color.offer_bt_color),
                    RoundedCornerShape(50),
                )
        ) {
            Text(
                text = "Next",
                style = TextStyle(
                    color = colorResource(id = R.color.white),
                    fontWeight = FontWeight.W600,
                    fontSize = 16.sp
                )
            )
        }
    }
}