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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.democomposeapp.R

@Preview(heightDp = 750, widthDp = 350, showBackground = true)
@Composable
fun MyPreview11() {
    Transaction()
}
@Composable
fun Transaction() {
//here will be manage code part
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
                TransactionToolBarFunc()
                TransactionContainScreen()
            }
        }
    )
}

@Composable
fun TransactionToolBarFunc() {
    ConstraintLayout(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth()
            .height(55.dp)
    ) {
        val (userImage, name, setting) = createRefs()
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

        Text(text = "Total Transaction",
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
        Text(
            text = "1000 Points = 1000 Coins",
            modifier = Modifier
                .padding(10.dp)
                .constrainAs(setting) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },

            style = TextStyle(
                fontWeight = FontWeight.W500,
                fontSize = 10.sp,
                color = colorResource(id = R.color.wallet_text_color)
            )
        )
    }
}

@Composable
fun TransactionContainScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = colorResource(id = R.color.light_gray)
            )

    ) {
        LazyColumn(content = {
            items(20) {
                Column {
                    TransactionListRow()
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
}


@Composable
private fun TransactionListRow() {
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

