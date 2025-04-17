package br.senai.sp.jandira.bmi.screens

import android.content.Context
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.BmiStatus
import br.senai.sp.jandira.bmi.R
import br.senai.sp.jandira.bmi.bmiCalculete
import br.senai.sp.jandira.bmi.screens.components.BmiLevel
import br.senai.sp.jandira.bmi.utils.numberConvertTolocale

@Composable
fun BMIResultScreen(navegacao: NavHostController?) {

    val userFile = LocalContext.current.
    getSharedPreferences("user_file", Context.MODE_PRIVATE)

    val userHeight = userFile.getFloat("user_height", 0.0f)
    val userWeight = userFile.getFloat("user_weight", 0.0f)
    val userAge = userFile.getInt("user_age", 0)

    // Obter os daods do imc do usuário
    val result = bmiCalculete(
        userWeight.toInt(),
        userHeight.toDouble().div(100)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xFF9D00FF),
                        Color(0xFF583BFF),
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
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
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(8f),
                colors = CardDefaults
                    .cardColors(
                        containerColor = Color.White
                    ),
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Card(
                        modifier = Modifier
                            .size(130.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        shape = CircleShape,
                        border = BorderStroke(
                            width = 7.dp,
                            color = result.color


                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = numberConvertTolocale(result.bmi.second),
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 35.sp
                            )
                        }
                    }

                    Text(
                        text = result.bmi.first,
                        fontSize = 20.sp,
                        color = result.color,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp)
                            .align(Alignment.CenterHorizontally)


                    )
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(15.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Column(
                                modifier = Modifier
                                    .height(50.dp)
                                    .weight(1f),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = stringResource(R.string.age),
                                    color = Color.Gray,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = "$userAge",
                                    color = Color.Black,
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
                                    text = "$userWeight Kg",
                                    color = Color.Black,
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
                                    text = "$userHeight",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Transparent)
                    ) {
                        BmiLevel(
                            leftText = "Underweight",
                            rightText = "< 18.5",
                            bulletColor = colorResource(R.color.light_blue),
                            background = if (result.status == BmiStatus.UNDER_WEIGHT) colorResource(R.color.light_blue) else Color.Transparent
                        )
                       BmiLevel(
                            leftText = "Normal",
                            rightText = "18.6 - 24.9",
                            bulletColor = colorResource(R.color.light_green),
                            background = if (result.status == BmiStatus.NORMAL) colorResource(R.color.light_green) else Color.Transparent
                        )

                        BmiLevel(
                            leftText = "Overweight",
                            rightText = "25.0 - 29.9",
                            bulletColor = colorResource(R.color.yellow),
                            background = if (result.status == BmiStatus.OVER_WEIGHT) colorResource(R.color.yellow) else Color.Transparent
                        )


                        BmiLevel(
                            leftText = "Obesity Class I",
                            rightText = "30.0 - 34.9",
                            bulletColor = colorResource(R.color.light_orange),
                            background = if (result.status == BmiStatus.OBSITY_1) colorResource(R.color.light_orange) else Color.Transparent
                        )

                        BmiLevel(
                            leftText = "Obesity Class II",
                            rightText = "35.0 - 39.9",
                            bulletColor = colorResource(R.color.dark_orange),
                            background = if (result.status == BmiStatus.OBSITY_2) colorResource(R.color.dark_orange) else Color.Transparent
                        )

                        BmiLevel(
                            leftText = "Obesity Class III",
                            rightText = ">39.9",
                            bulletColor = colorResource(R.color.light_red),
                            background = if (result.status == BmiStatus.OBSITY_3) colorResource(R.color.light_red) else Color.Transparent
                        )
                    }
                    HorizontalDivider()
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        colors = ButtonDefaults
                            .buttonColors(
                                containerColor = Color(0xff9c27b0)
                            ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.calc),
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
    }
}


@Preview
@Composable
private fun BMIResultScreenPreview() {
    BMIResultScreen(null)
}