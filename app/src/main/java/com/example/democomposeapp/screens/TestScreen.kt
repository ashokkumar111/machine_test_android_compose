package com.example.democomposeapp.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.democomposeapp.R
import com.example.democomposeapp.models.TestModel
import com.example.democomposeapp.view_models.TestViewModel


@Composable
fun testScreen(onClick:(TestModel)->Unit) {
    val testViewModel: TestViewModel = hiltViewModel()

    // State
    val testListState:State<List<TestModel>?> = testViewModel.testLiveData11.observeAsState()

    // API call
    LaunchedEffect(key1 = Unit) {
        testViewModel.getTestListData()
    }

    //UI Design
    LazyColumn(content = {
        items(testListState.value ?: emptyList()) {
            testScreenRow(it,onClick)
        }
    })
}

@Composable
fun testScreenRow(testModel: TestModel,onClick:(TestModel)->Unit) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .padding(10.dp)
            .background(colorResource(id = R.color.purple_200))
            .fillMaxWidth()
            .padding(5.dp)
            .clickable {
                 onClick(testModel)
            }

    ) {
        Row (horizontalArrangement = Arrangement.SpaceBetween){
            Text(
                text = "Name:-",
                fontSize = 18.sp,
                color = colorResource(R.color.white),
                modifier = Modifier
                    .padding(0.dp, 0.dp, 0.dp, 2.dp)
                    .padding(5.dp)
            )

            Text(
                text = testModel.name ?:"",
                fontSize = 18.sp,
                color = colorResource(R.color.white),
                modifier = Modifier
                    .padding(10.dp, 0.dp, 0.dp, 2.dp)
                    .padding(5.dp)

            )
        }

        Row (horizontalArrangement = Arrangement.SpaceBetween){
            Text(
                text = "Email:-",
                fontSize = 18.sp,
                color = colorResource(R.color.white),
                modifier = Modifier
                    .padding(0.dp, 0.dp, 0.dp, 2.dp)
                    .padding(5.dp)
            )

            Text(
                text = testModel.email?:"",
                fontSize = 18.sp,
                color = colorResource(R.color.white),
                modifier = Modifier
                    .padding(10.dp, 0.dp, 0.dp, 2.dp)
                    .padding(5.dp)
            )
        }


        Text(
            text = "Address-----",
            fontSize = 20.sp,
            color = colorResource(R.color.white),
            modifier = Modifier
                .padding(5.dp, 10.dp, 0.dp, 0.dp)
        )

        Text(
            text = testModel.address.city ?:"",
            fontSize = 14.sp,
            color = colorResource(R.color.white),
            modifier = Modifier
                .padding(5.dp, 2.dp, 0.dp, 0.dp)
        )

        Text(
            text = "Lat Long-----",
            fontSize = 20.sp,
            color = colorResource(R.color.white),
            modifier = Modifier
                .padding(5.dp, 10.dp, 0.dp, 0.dp)
        )

        Text(
            text = testModel.address.geo.lat ?:"",
            fontSize = 14.sp,
            color = colorResource(R.color.white),
            modifier = Modifier
                .padding(5.dp, 2.dp, 0.dp, 0.dp)
        )

        Text(
            text = testModel.address.geo.lng ?:"",
            fontSize = 14.sp,
            color = colorResource(R.color.white),
            modifier = Modifier
                .padding(5.dp, 2.dp, 0.dp, 0.dp)
        )
    }
}
