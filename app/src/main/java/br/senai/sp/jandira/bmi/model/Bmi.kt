package br.senai.sp.jandira.bmi.model

import androidx.compose.ui.graphics.Color
import br.senai.sp.jandira.bmi.BmiStatus

class Bmi(
    var color: Color = Color.Transparent,
    var status: BmiStatus = BmiStatus.NORMAL,
    var bmi: Pair<String, Double>
)
