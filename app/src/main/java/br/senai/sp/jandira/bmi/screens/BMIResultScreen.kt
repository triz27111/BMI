package br.senai.sp.jandira.bmi.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmi.R

@Composable
fun BMIResultScreen(modifier: Modifier = Modifier){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xFF4D2277),
                        Color(0xFF4D2277),
                    )
                )
            )
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
        ){
            Text(
                text = stringResource(R.string.result),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(32.dp)
                    .weight(1f)
            )
            Card(
                modifier = modifier
                    .fillMaxSize()
                    .weight(4f),
                colors = CardDefaults
                    .cardColors(
                        containerColor = Color.White
                    ),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Card(
                                modifier = Modifier
                                    .padding(top=30.dp)
                                    .size(130.dp),
                                shape = CircleShape,
                                border = BorderStroke(
                                    width = 2.dp,
                                    brush = Brush.linearGradient(
                                        listOf(
                                            Color(0xFF9D00FF),
                                            Color(0xFFFF0000),
                                        )
                                    )
                                )
                            ) {
                                Column (
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ){
                                    Text(
                                        text = "30,6",
                                        fontSize = 32.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black,
                                        modifier = Modifier

                                    )
                                }
                            }
                            Text(
                                text = stringResource(R.string.have),
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                modifier = Modifier
                                    .padding(10.dp)
                            )

                        }
                    }
                    Column(
                        modifier = Modifier
                            .height(100.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Card(
                            modifier = Modifier
                                .width(300.dp)
                                .height(80.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(15.dp),
                                horizontalArrangement = Arrangement.Center,
                            ){
                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(50.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = stringResource(R.string.age),
                                        color = Color.Gray,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 20.sp
                                    )
                                    Text(
                                        text = stringResource(R.string.value_age),
                                        color = Color.Gray,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 20.sp
                                    )
                                }
                                VerticalDivider()
                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(50.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = stringResource(R.string.weight),
                                        color = Color.Gray,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 20.sp
                                    )
                                    Text(
                                        text = stringResource(R.string.value_weight),
                                        color = Color.Gray,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 20.sp
                                    )
                                }
                                VerticalDivider()
                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(50.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = stringResource(R.string.height),
                                        color = Color.Gray,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 20.sp
                                    )
                                    Text(
                                        text = stringResource(R.string.value_height),
                                        color = Color.Gray,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 20.sp
                                    )
                                }
                            }

                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ){

                        }
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(30.dp),
                            colors = ButtonDefaults
                                .buttonColors(
                                    containerColor = Color(0xFFFFEB3B)
                                ),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = stringResource(R.string.calc),
                                fontSize = 50.sp
                            )
                        }
                    }
                }

            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview(){
    BMIResultScreen()
}