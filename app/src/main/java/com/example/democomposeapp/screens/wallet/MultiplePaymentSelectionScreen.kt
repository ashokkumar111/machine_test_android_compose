package com.example.democomposeapp.screens.wallet
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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

@Preview(heightDp = 700, widthDp = 350, showBackground = true)
@Composable
fun MultiplePaymentPreview() {
    MultiplePayment()
}

@Composable
fun MultiplePayment() {
    Scaffold(
        modifier = Modifier
            .background(color = Color.White)
            .padding(top = 30.dp, bottom = 50.dp),
        content = { it
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxHeight()
            ) {
                MultiplePaymentToolBarFunc()
                MultiplePaymentContainScreen()
            }
        }
    )
}

@Composable
fun MultiplePaymentToolBarFunc() {
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
fun MultiplePaymentContainScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(175.dp)
                .background(color = colorResource(id = R.color.pink_transparent_color))

        ) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp),
                    painter = painterResource(id = R.drawable.coin),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "2500 Coins",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W700,
                        color = colorResource(id = R.color.black),
                        //fontFamily = FontFamily(Font(R.font.montserratalternates_regular))
                    ),
                    modifier = Modifier
                        .padding(top = 16.dp)
                )
                Text(
                    text = "Withdraw Amount",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W500,
                        color = colorResource(id = R.color.text_gray_color)
                    ),
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
        //payments methods like google pay,phone pay, paytm, Bhim
        paymentsMethod()
    }
}

@Composable
fun paymentsMethod() {
    Box(
        modifier = Modifier
            .padding(top = 160.dp)
            .fillMaxHeight()
            .fillMaxWidth()
            .background(
                color = colorResource(R.color.white),
                RoundedCornerShape(topStart = 25.dp, topEnd = 30.dp),
            )
    ) {
        Column {
            Row(modifier = Modifier.padding(top = 30.dp)) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 5.dp, bottom = 10.dp)
                    ) {
                        Image(
                            modifier = Modifier
                                .width(36.dp)
                                .height(36.dp),
                            painter = painterResource(id = R.drawable.gpay_icon),
                            contentDescription = "",
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = "G-Pay",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W500,
                                color = colorResource(id = R.color.text_gray_color)
                            ),
                            modifier = Modifier
                                .padding(top = 8.dp)
                        )
                    }
                }

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 5.dp, bottom = 10.dp)
                    ) {
                        Image(
                            modifier = Modifier
                                .width(36.dp)
                                .height(36.dp),
                            painter = painterResource(id = R.drawable.phon_pay_icon),
                            contentDescription = "",
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = "PhonePe",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W500,
                                color = colorResource(id = R.color.text_gray_color)
                            ),
                            modifier = Modifier
                                .padding(top = 8.dp)
                        )
                    }
                }

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 5.dp, bottom = 10.dp)
                    ) {
                        Image(
                            modifier = Modifier
                                .width(36.dp)
                                .height(36.dp),
                            painter = painterResource(id = R.drawable.paytm_icon),
                            contentDescription = "",
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = "Paytm",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W500,
                                color = colorResource(id = R.color.text_gray_color)
                            ),
                            modifier = Modifier
                                .padding(top = 8.dp)
                        )
                    }
                }


                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 5.dp, bottom = 10.dp)
                    ) {
                        Image(
                            modifier = Modifier
                                .width(36.dp)
                                .height(36.dp),
                            painter = painterResource(id = R.drawable.bhim_icon),
                            contentDescription = "",
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = "BHIM",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W500,
                                color = colorResource(id = R.color.text_gray_color)
                            ),
                            modifier = Modifier
                                .padding(top = 8.dp)
                        )
                    }
                }
            }
            Text(
                text = "Wallet",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W600,
                    color = colorResource(id = R.color.wallet_text_color)
                ),
                modifier = Modifier
                    .padding(start = 12.dp, top = 25.dp)
            )

            //paytm payment
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(start = 12.dp, top = 12.dp, end = 12.dp)
                    .fillMaxWidth()
            ) {
                Row {
                    Image(
                        modifier = Modifier
                            .width(36.dp)
                            .height(36.dp),
                        painter = painterResource(id = R.drawable.paytm_icon),
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = "Paytm",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W500,
                            color = colorResource(id = R.color.wallet_text_color)
                        ),
                        modifier = Modifier
                            .padding(start = 10.dp, top = 8.dp)
                    )
                }

                Text(
                    text = "Link",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W700,
                        color = colorResource(id = R.color.green_color)
                    ),
                    modifier = Modifier
                        .padding(top = 8.dp)
                )
            }

            Text(
                text = "Others",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W600,
                    color = colorResource(id = R.color.wallet_text_color)
                ),
                modifier = Modifier
                    .padding(start = 12.dp, top = 25.dp)
            )

            //Debit/Credit Cards  payment
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 12.dp, top = 25.dp, end = 12.dp)
                    .fillMaxWidth()
            ) {
                Row {
                    Image(
                        modifier = Modifier
                            .width(22.dp)
                            .height(22.dp),
                        painter = painterResource(id = R.drawable.wallet_icon),
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "Debit/Credit Cards",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W500,
                            color = colorResource(id = R.color.wallet_text_color)
                        ),
                        modifier = Modifier
                            .padding(start = 10.dp, top = 0.dp)
                    )
                }
                Text(
                    text = "Use",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W700,
                        color = colorResource(id = R.color.green_color)
                    ),
                    modifier = Modifier
                        .padding(top = 8.dp)
                )
            }

            Box(
                modifier = Modifier
                    .padding(start = 12.dp, top = 20.dp, end = 12.dp)
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(colorResource(id = R.color.border_color)) // Set the color of the line here
            )

            //Net Banking  payment

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 12.dp, top = 12.dp, end = 12.dp)
                    .fillMaxWidth()
            ) {
                Row {
                    Image(
                        modifier = Modifier
                            .width(22.dp)
                            .height(22.dp),
                        painter = painterResource(id = R.drawable.bank_icon),
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = "Net Banking",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W500,
                            color = colorResource(id = R.color.wallet_text_color)
                        ),
                        modifier = Modifier
                            .padding(start = 10.dp, top = 0.dp)
                    )
                }
                Text(
                    text = "Use",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W700,
                        color = colorResource(id = R.color.green_color)
                    ),
                    modifier = Modifier
                        .padding(top = 8.dp)
                )
            }

            Box(
                modifier = Modifier
                    .padding(start = 12.dp, top = 20.dp, end = 12.dp)
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(colorResource(id = R.color.border_color)) // Set the color of the line here
            )
        }
    }
}