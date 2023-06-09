package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceRollerLayout()
                }
            }
        }
    }
}

@Composable
fun DiceRollerLayout() {
    var results by rememberSaveable {mutableStateOf(1)}
    val imageResource: Int
    val stringResource: Int

    when(results) {
        1 -> {
            imageResource = R.drawable.r1
            stringResource = R.string.one
        }
        2 -> {
            imageResource = R.drawable.r2
            stringResource = R.string.two
        }
        3 -> {
            imageResource = R.drawable.r3
            stringResource = R.string.three
        }
        4 -> {
            imageResource = R.drawable.r4
            stringResource = R.string.four
        }
        5 -> {
            imageResource = R.drawable.r5
            stringResource = R.string.five
        }
        else -> {
            imageResource = R.drawable.r6
            stringResource = R.string.six
        }
    }

    Column(verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = stringResource(
            id = stringResource
            ),
            modifier = Modifier.size(width = 150.dp, height = 150.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { results =  (1..6).random()},
            shape = RoundedCornerShape(15)
        ) {
            Text(text = "Roll")
        }
    }    
}




@Preview(showBackground = true)
@Composable
fun DiceRollerPreview() {
    DiceRollerTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            DiceRollerLayout()
        }
    }
}