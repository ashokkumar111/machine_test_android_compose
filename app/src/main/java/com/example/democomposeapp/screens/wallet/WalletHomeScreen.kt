package com.example.democomposeapp.screens.wallet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.democomposeapp.R

@Preview(widthDp = 400, heightDp = 1100, showBackground = true)
@Composable
fun MyPreview() {
    val navController = rememberNavController()
    WalletHome(navController)
}
@Composable
fun WalletHome(navController: NavHostController) {
 //here will be manage code part
    val scrollState = rememberScrollState()

    Scaffold(
        modifier = Modifier
            .background(color = Color.White)
            .padding(top = 30.dp, bottom = 50.dp),
        content = { it
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.verticalScroll(scrollState)

            ) {
                BalletToolBarFunc()
                BalletContainScreen(navController)
            }
        }
    )
}
@Composable
fun BalletToolBarFunc() {
    ConstraintLayout(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth()
            .height(55.dp)
    ) {
        val (userImage, name, setting) = createRefs()

        Image(painter = painterResource(id = R.drawable.profile_photo),
            contentDescription = "",
            modifier = Modifier
                .padding(start = 10.dp)
                .height(40.dp)
                .width(40.dp)
                .constrainAs(userImage) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                })

        Text(text = "Vishad Aman",
            style = TextStyle(
                fontSize = 14.sp,
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

        Image(painter = painterResource(id = R.drawable.setting_icon),
            contentDescription = "",
            modifier = Modifier
                .padding(10.dp)
                .height(20.dp)
                .width(20.dp)
                .constrainAs(setting) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                })

    }
}

@Composable
fun BalletContainScreen(navController: NavHostController) {
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                /*  brush = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color.Transparent),

                    ),*/
                color = colorResource(id = R.color.light_gray),

                shape = RoundedCornerShape(topStartPercent = 8, topEndPercent = 8)
            )
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {

            ConstraintLayout(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                val (coinImg, amount, title, note) = createRefs()

                Image(painter = painterResource(id = R.drawable.coin),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .height(50.dp)
                        .width(50.dp)
                        .constrainAs(coinImg) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        }
                )

                Text(text = "14235.33",
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.W600,
                        fontSize = 24.sp
                    ),
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .constrainAs(amount) {
                            start.linkTo(coinImg.end)
                            top.linkTo(coinImg.top)

                        }
                )


                Text(text = "Total earned coin",
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.W400,
                        fontSize = 12.sp
                    ),
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .constrainAs(title) {
                            start.linkTo(coinImg.end)
                            top.linkTo(amount.bottom)
                            bottom.linkTo(coinImg.bottom)
                        }
                )

                Text(text = "Not 1000 Point = 1000 Coin",
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.W400,
                        fontSize = 12.sp
                    ),
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .constrainAs(note) {
                            end.linkTo(parent.end)
                            top.linkTo(amount.bottom)
                            bottom.linkTo(coinImg.bottom)
                        }
                )
            }


            Box(
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp, end = 10.dp)
                    .height(170.dp)
                    .fillMaxWidth()
                    .background(
                        color = Color.Red,
                        shape = RoundedCornerShape(8)
                    )
            ) {
                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "In Wallet",
                        style = TextStyle(
                            color = Color.White,
                            fontWeight = FontWeight.W600,
                            fontSize = 18.sp
                        ),
                        modifier = Modifier
                            .padding(start = 10.dp, top = 15.dp)
                    )

                    Text(
                        text = "14235.33 Points",
                        style = TextStyle(
                            color = Color.White,
                            fontWeight = FontWeight.W600,
                            fontSize = 24.sp
                        ),
                        modifier = Modifier
                            .padding(start = 10.dp, top = 10.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.withdraw_btn),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(start = 10.dp, top = 28.dp)
                            .height(33.dp)
                            .width(136.dp)
                            .clickable {
                            }
                    )
                }
            }

            Box(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Recent Transaction",
                        style = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.W600,
                            fontSize = 20.sp
                        ),
                        modifier = Modifier
                            .padding(start = 10.dp, top = 15.dp)
                    )
                    Text(
                        text = "View All",
                        style = TextStyle(
                            color = Color.Gray,
                            fontWeight = FontWeight.W600,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier
                            .padding(start = 10.dp, top = 15.dp, end = 10.dp)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            ) {
                LazyColumn(content = {
                    items(10) {
                        Column {
                            TransactionRow()
                            Box(
                                modifier = Modifier
                                    .padding(start = 10.dp, end = 10.dp)
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(color = colorResource(id = R.color.line_color))
                            )
                        }

                    }
                })
            }

            Box(modifier = Modifier
                    .height(167.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    modifier =  Modifier
                    .height(167.dp)
                    .fillMaxWidth()
                    .background( color = Color.Transparent, shape = RoundedCornerShape(8)),
                    painter = painterResource(id = R.drawable.offer_bg),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.TopStart
                )

                Column {
                    Text(
                        text = "Promos & Offer",
                        style = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.W600,
                            fontSize = 20.sp
                        ),
                        modifier = Modifier
                            .padding(start = 10.dp, top = 15.dp)
                    )

                    LazyRow(content = {
                        items(10) {
                            PromsAndOfferRow()

                        }
                    })
                }
            }
            DailyChallengeBanner()
        }

    }
}


@Composable
fun TransactionRow() {
    ConstraintLayout(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth()
            .height(60.dp)
    ) {
        val (coinImg, amount, title, note) = createRefs()

        Image(painter = painterResource(id = R.drawable.coin),
            contentDescription = "",
            modifier = Modifier
                .padding(start = 8.dp)
                .height(36.dp)
                .width(36.dp)
                .constrainAs(coinImg) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
        )

        Text(text = "14235.33",
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.W600,
                fontSize = 14.sp
            ),
            modifier = Modifier
                .padding(start = 10.dp)
                .constrainAs(amount) {
                    start.linkTo(coinImg.end)
                    top.linkTo(coinImg.top)

                }
        )


        Text(text = "Total earned coin",
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.W400,
                fontSize = 12.sp
            ),
            modifier = Modifier
                .padding(start = 10.dp)
                .constrainAs(title) {
                    start.linkTo(coinImg.end)
                    top.linkTo(amount.bottom)
                    bottom.linkTo(coinImg.bottom)
                }
        )
        Text(text = "+ ₹452,44",
            style = TextStyle(
                color = colorResource(id = R.color.green_color),
                fontWeight = FontWeight.W600,
                fontSize = 16.sp
            ),
            modifier = Modifier
                .padding(end = 10.dp)
                .constrainAs(note) {
                    end.linkTo(parent.end)
                    top.linkTo(amount.bottom)
                    bottom.linkTo(coinImg.bottom)
                }
        )
    }
}

@Composable
fun PromsAndOfferRow() {
    Box(
        modifier = Modifier
            .padding(start = 10.dp, top = 10.dp, end = 10.dp)
            .width(173.dp)
            .height(90.dp)
            .background(color = Color.Green, shape = RoundedCornerShape(8)),

        ) {

        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Special offer for today top-up",
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.W600,
                    fontSize = 13.sp
                ),
                modifier = Modifier
                    .padding(start = 10.dp, top = 15.dp)
            )

            Text(
                text = "Get special offers using your reward coins",
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.W500,
                    fontSize = 10.sp
                ),
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp, end = 10.dp)
            )
        }
    }

}

@Composable
fun DailyChallengeBanner() {
    Box(
        modifier = Modifier
            .padding(start = 14.dp, top = 20.dp, end = 14.dp)
            .height(170.dp)
            .fillMaxWidth()
            .background(
                color = Color.Red,
                shape = RoundedCornerShape(8)
            )
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Your Daily Challang",
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.W600,
                    fontSize = 23.sp
                ),
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp)
            )

            Text(
                text = "Complete daily challenges to earn more points",
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.W600,
                    fontSize = 14.sp
                ),
                modifier = Modifier
                    .padding(start = 15.dp, top = 10.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.start_btn),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 10.dp, top = 28.dp)
                    .height(33.dp)
                    .width(136.dp)
            )

        }

    }
}