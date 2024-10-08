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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.democomposeapp.R

@Preview
@Composable
fun PromosPreview() {
    Promos()
}

@Composable
fun Promos() {
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
                PromosToolBarFunc()
                PromosContainScreen()
            }
        }
    )
}

@Composable
fun PromosToolBarFunc() {
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

        Text(text = "Promos & Offers",
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
            text = "30 Days Validity",
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
                color = colorResource(id = R.color.text_gray_color)
            )
        )
    }
}

@Composable
fun PromosContainScreen() {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxHeight()
            .background(color = Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.promos_banner),
            contentDescription = "",
            modifier = Modifier
                .height(194.dp)
                .fillMaxWidth()
        )

        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top,
            modifier = Modifier.padding(start = 10.dp, top = 20.dp, end = 10.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(2f)
            ) {
                Text(
                    text = "Idea top-up offer Limited offer till 30 Oct",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W600,
                        color = colorResource(id = R.color.wallet_text_color)
                    )
                )
            }

            Box(
                contentAlignment = Alignment.CenterEnd,
                modifier = Modifier
                    .weight(1f)
                    .background(color = Color.White)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .width(116.dp)
                        .height(32.dp)
                        .clip(RoundedCornerShape(15))
                        .border(
                            2.dp, brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color(252, 96, 17),
                                    Color(176, 0, 98),
                                    Color(81, 18, 102)
                                )
                            ), RoundedCornerShape(15.dp)
                        )
                        .shadow(elevation = 1.dp, shape = RoundedCornerShape(15))
                ) {
                    Text(
                        text = "40 % OFF",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W600,
                            color = colorResource(id = R.color.pink_color),
                            textAlign = TextAlign.Center
                        ),
                    )

                }
            }
        }

        Text(
            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s... know more",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W500,
                color = colorResource(id = R.color.text_gray_color)
            ),
            modifier = Modifier
                .padding(start = 10.dp, top = 20.dp, end = 10.dp)
        )

        Text(
            text = "Lorem Ipsum is simply dummy text of the printing",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W500,
                color = colorResource(id = R.color.text_gray_color)
            ),
            modifier = Modifier
                .padding(start = 10.dp, top = 10.dp, end = 10.dp)
        )

        Text(
            text = "Lorem Ipsum is simply dummy text of the printing",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W500,
                color = colorResource(id = R.color.text_gray_color)
            ),
            modifier = Modifier
                .padding(start = 10.dp, top = 10.dp, end = 10.dp)
        )

        Text(
            text = "Lorem Ipsum is simply dummy text of the printing",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W500,
                color = colorResource(id = R.color.text_gray_color)
            ),
            modifier = Modifier
                .padding(start = 10.dp, top = 10.dp, end = 10.dp)
        )


        Box (contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(50.dp)
                .fillMaxWidth()){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(164.dp)
                    .height(51.dp)
                    .background(
                        color = colorResource(R.color.offer_bt_color),
                        RoundedCornerShape(50),
                    )
            ) {
                Text(
                    text = "Redeem Offer",
                    style = TextStyle(
                        color = colorResource(id = R.color.white),
                        fontWeight = FontWeight.W600,
                        fontSize = 16.sp
                    )
                )
            }
        }
    }
}