package com.example.democomposeapp.screens.wallet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.democomposeapp.R

@Preview(heightDp = 800, widthDp = 400, showBackground = true)
@Composable
fun PaymentCompletedPreview() {
    PaymentCompleted()
}

@Composable
fun PaymentCompleted() {
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
                PaymentCompletedToolBarFunc()
                PaymentCompletedContainScreen()
            }
        }
    )
}

@Composable
fun PaymentCompletedToolBarFunc() {
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

@Composable
fun PaymentCompletedContainScreen() {
    Column {
        PaymentHeader()
        PaymentsDetails()
    }
}

@Composable
fun PaymentHeader() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(256.dp)
            .background(color = colorResource(id = R.color.pink_transparent_color))

    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier
                    .width(163.dp)
                    .height(126.dp),
                painter = painterResource(id = R.drawable.paymentdone_icon),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )

            Text(
                text = "Payment done!",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    color = colorResource(id = R.color.black)
                ),
                modifier = Modifier
                    .padding(top = 25.dp)
            )
            Text(
                text = "Bill payment has been done successfully",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W500,
                    color = colorResource(id = R.color.text_gray_color)
                ),
                modifier = Modifier
                    .padding(top = 10.dp)
            )
        }
    }
}

@Composable
fun PaymentsDetails() {
    Column {
        Text(
            text = "Payment details",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W600,
                color = colorResource(id = R.color.black)
            ),
            modifier = Modifier
                .padding(start = 12.dp, top = 12.dp)
        )

        Box(
            modifier = Modifier
                .padding(start = 12.dp, top = 12.dp, end = 12.dp)
                .fillMaxWidth()
                .border(
                    1.dp,
                    color = colorResource(id = R.color.border_color),
                    shape = RoundedCornerShape(12)
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Text(
                    text = "Biller",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W600,
                        color = colorResource(id = R.color.text_gray_color)
                    ),
                    modifier = Modifier
                        .padding(top = 0.dp)
                )
                Text(
                    text = "Vishad Aman",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W600,
                        color = colorResource(id = R.color.text_gray_color)
                    ),
                    modifier = Modifier
                        .padding(top = 0.dp)
                )
            }
        }


        Box(
            modifier = Modifier
                .padding(start = 12.dp, top = 12.dp, end = 12.dp)
                .fillMaxWidth()
                .border(
                    1.dp,
                    color = colorResource(id = R.color.border_color),
                    shape = RoundedCornerShape(12)
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Text(
                    text = "Amount",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W600,
                        color = colorResource(id = R.color.text_gray_color)
                    ),
                    modifier = Modifier
                        .padding(top = 0.dp)
                )
                Text(
                    text = "2500.00",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W600,
                        color = colorResource(id = R.color.text_gray_color)
                    ),
                    modifier = Modifier
                        .padding(top = 0.dp)
                )
            }
        }

        Box(
            modifier = Modifier
                .padding(start = 12.dp, top = 12.dp, end = 12.dp)
                .fillMaxWidth()
                .border(
                    1.dp,
                    color = colorResource(id = R.color.border_color),
                    shape = RoundedCornerShape(12)
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Text(
                    text = "Method",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W600,
                        color = colorResource(id = R.color.text_gray_color)
                    ),
                    modifier = Modifier
                        .padding(top = 0.dp)
                )
                Text(
                    text = "Paytm",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W600,
                        color = colorResource(id = R.color.text_gray_color)
                    ),
                    modifier = Modifier
                        .padding(top = 0.dp)
                )
            }
        }


        Box(
            modifier = Modifier
                .padding(start = 12.dp, top = 12.dp, end = 12.dp)
                .fillMaxWidth()
                .border(
                    1.dp,
                    color = colorResource(id = R.color.border_color),
                    shape = RoundedCornerShape(12)
                )
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Text(
                        text = "Transaction no.",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W600,
                            color = colorResource(id = R.color.text_gray_color)
                        ),
                        modifier = Modifier
                            .padding(top = 0.dp)
                    )
                    Text(
                        text = "23010412432431",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W600,
                            color = colorResource(id = R.color.text_gray_color)
                        ),
                        modifier = Modifier
                            .padding(top = 0.dp)
                    )
                }

                Image(
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .width(24.dp)
                        .height(24.dp),
                    painter = painterResource(id = R.drawable.copy_icon),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )

            }
        }

        Row (horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 25.dp)
                .fillMaxWidth()
        ){

            Image(
                modifier = Modifier
                    .padding(end = 12.dp)
                    .width(20.dp)
                    .height(20.dp),
                painter = painterResource(id = R.drawable.flag_icon),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Report a problem",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600,
                    color = colorResource(id = R.color.pink_color)
                ),
                modifier = Modifier
                    .padding(top = 0.dp))
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(top = 40.dp, start = 12.dp, end = 12.dp)
                .fillMaxWidth()
                .height(45.dp)
                .background(
                    color = colorResource(R.color.offer_bt_color),
                    RoundedCornerShape(50),
                )
        ) {
            Text(
                text = "Back to wallet",
                style = TextStyle(
                    color = colorResource(id = R.color.white),
                    fontWeight = FontWeight.W600,
                    fontSize = 16.sp
                )
            )
        }
    }
}


