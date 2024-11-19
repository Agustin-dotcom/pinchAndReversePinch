package com.example.pinchandreversepinch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.pinchandreversepinch.ui.theme.PinchAndReversePinchTheme
import com.example.pinchandreversepinch.ui.theme.Theme
//import androidx.compose.material
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.unit.IntOffset
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.content.Context
import android.speech.tts.TextToSpeech
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var theme by remember { mutableStateOf(Theme.Light) }
            var isDrawerOpen by remember { mutableStateOf(false) }

            PinchAndReversePinchTheme(colorScheme = theme) {
                Box(modifier = Modifier.fillMaxSize()) {
                    // Main content
                    val context = LocalContext.current
                    var isMoved by remember { mutableStateOf(false) }
                    val offsetX by animateDpAsState(if (isMoved) 100.dp else 0.dp)
                    var darkModeIsChecked by remember { mutableStateOf(false) }
                    var protanopiaIsChecked by remember { mutableStateOf(false) }
                    var deuteranopiaIsChecked by remember { mutableStateOf(false) }
                    val minScale = 0.8f
                    val maxScale = 2f
                    var selectedIndex by remember { mutableStateOf(0) }
                    val buttons = listOf("Button 1", "Button 2", "Button 3")
                    var scale by remember { mutableStateOf(1f) }
                    val tts = remember {
                        TextToSpeech(context) { status ->
                        if (status == TextToSpeech.SUCCESS) {
                            tts?.language = Locale.getDefault()
                        }
                    }}

                    LaunchedEffect(selectedIndex) {
                        tts.speak(buttons[selectedIndex], TextToSpeech.QUEUE_FLUSH, null, null)
                    }
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Text("Contenido Principal")


                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .pointerInput(Unit) {
                                        detectTransformGestures { _, _, zoom, _ ->
                                            scale = (scale * zoom).coerceIn(minScale, maxScale)
                                        }
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Button(
                                        onClick = {},
                                        modifier = Modifier
                                            .padding(8.dp)
                                            .width((200 * scale).dp)
                                            .height((50 * scale).dp)
                                    ) {
                                        Text(text = "Button 1", fontSize = (16 * scale).sp)
                                    }
                                    Button(
                                        onClick = {},
                                        modifier = Modifier
                                            .padding(8.dp)
                                            .width((200 * scale).dp)
                                            .height((50 * scale).dp)
                                    ) {
                                        Text(text = "Button 2", fontSize = (16 * scale).sp)
                                    }
                                    Button(
                                        onClick = {},
                                        modifier = Modifier
                                            .padding(8.dp)
                                            .width((200 * scale).dp)
                                            .height((50 * scale).dp)
                                    ) {
                                        Text(text = "Button 3", fontSize = (16 * scale).sp)
                                    }
                                }
                            }
                        }
                    }
//                    Box(modifier = Modifier.size(200.dp)) {
//                        Button(
//                            onClick = { isMoved = !isMoved },
//                            modifier = Modifier.offset { IntOffset(offsetX.roundToPx(), 0) }
//                        ) {
//                            Text("Toggle")
//                        }
//                    }
//                    Switch(
//                        checked = darkModeIsChecked,
//                        onCheckedChange = { darkModeIsChecked = it }
//                    )
//                    Text(text = if (darkModeIsChecked) "Switch is ON" else "Switch is OFF")
                    // Menu button
                    IconButton(
                        onClick = { isDrawerOpen = true },
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu",
                            tint = if (theme == Theme.Light) Color.Black else Color.White
                        )
                    }

                    // Drawer
                    if (isDrawerOpen) {
                        Dialog(onDismissRequest = { isDrawerOpen = false }) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clickable { isDrawerOpen = false }
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .fillMaxWidth()
                                        .align(Alignment.Center)
                                        .background(Color.Transparent)
                                ) {
                                    Spacer(
                                        modifier = Modifier
                                            .weight(0.3f)
                                            .fillMaxSize()
                                            .clickable { isDrawerOpen = false }
                                    )
                                    Box(
                                        modifier = Modifier
                                            .weight(0.7f)
                                            .fillMaxHeight()

                                            .background(MaterialTheme.colorScheme.background, RoundedCornerShape(4.dp))
                                            .clickable { /* Prevent click propagation */ }
                                    ) {
                                        Column(
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center,
                                            modifier = Modifier.fillMaxSize()
                                        ) {
                                            Text(text = "Dark mode")
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Switch(
                                                checked = darkModeIsChecked,
                                                onCheckedChange = {
                                                    darkModeIsChecked = it
                                                    if(theme == Theme.Light)
                                                        theme = Theme.Dark
                                                    else
                                                        theme = Theme.Light
                                                }
                                            )
//                                            Button(
//                                                onClick = { theme = Theme.Light },
//                                                colors = ButtonDefaults.buttonColors(
//                                                    containerColor = MaterialTheme.colorScheme.primaryContainer,
//                                                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
//                                                )
//                                            ) {
//                                                Text("Modo Claro")
//                                            }
//                                            Spacer(modifier = Modifier.height(16.dp))
//                                            Button(
//                                                onClick = { theme = Theme.Dark },
//                                                colors = ButtonDefaults.buttonColors(
//                                                    containerColor = MaterialTheme.colorScheme.primaryContainer,
//                                                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
//                                                )
//                                            ) {
//                                                Text("Modo Oscuro")
//                                            }
                                            Text(text = "Protanopia")
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Switch(
                                                checked = protanopiaIsChecked,
                                                onCheckedChange = {
                                                    protanopiaIsChecked = it
                                                    if(!darkModeIsChecked && protanopiaIsChecked)
                                                        theme = Theme.lightProtanopia
                                                    else if (darkModeIsChecked && protanopiaIsChecked)
                                                            theme = Theme.DarkProtanopia
                                                        else if (!darkModeIsChecked && !protanopiaIsChecked)
                                                                theme = Theme.Light
                                                            else if(darkModeIsChecked && !protanopiaIsChecked)
                                                                    theme = Theme.Dark
                                                }
                                            )
                                            Text(text = "Deuteranopia")
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Switch(
                                                checked = deuteranopiaIsChecked,
                                                onCheckedChange = {
                                                    deuteranopiaIsChecked = it
                                                    if(!darkModeIsChecked && deuteranopiaIsChecked)
                                                        theme = Theme.lightDeuteranopia
                                                    else if (darkModeIsChecked && deuteranopiaIsChecked)
                                                            theme = Theme.DarkDeuteranopia
                                                        else if (!darkModeIsChecked && !deuteranopiaIsChecked)
                                                                theme = Theme.Light
                                                            else if(darkModeIsChecked && !deuteranopiaIsChecked)
                                                                    theme = Theme.Dark
                                                }
                                            )
                                            // Añade más botones aquí
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
//package com.example.pinchandreversepinch
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.ColumnScopeInstance.weight
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.weight
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Menu
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.colorResource
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.window.Dialog
//import com.example.pinchandreversepinch.ui.theme.PinchAndReversePinchTheme
//import com.example.pinchandreversepinch.ui.theme.Theme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            var theme by remember { mutableStateOf(Theme.Light) }
//            var isDrawerOpen by remember { mutableStateOf(false) }
//
//            PinchAndReversePinchTheme(colorScheme = theme) {
//                Box(modifier = Modifier.fillMaxSize()) {
//                    // Main content
//                    Surface(
//                        modifier = Modifier.fillMaxSize(),
//                        color = MaterialTheme.colorScheme.background
//                    ) {
//                        Column(
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            verticalArrangement = Arrangement.Center,
//                            modifier = Modifier.fillMaxSize()
//                        ) {
//                            Text("Contenido Principal")
//                        }
//                    }
//
//                    // Menu button
//                    IconButton(
//                        onClick = { isDrawerOpen = true },
//                        modifier = Modifier
//                            .align(Alignment.TopEnd)
//                            .padding(16.dp)
//                    ) {
//                        Icon(
//                            imageVector = Icons.Default.Menu,
//                            contentDescription = "Menu",
//                            tint = if (theme == Theme.Light) Color.Black else Color.White
//                        )
//                    }
//
//                    // Drawer
//                    if (isDrawerOpen) {
//                        Dialog(onDismissRequest = { isDrawerOpen = false }) {
//                            Box(
//                                modifier = Modifier
//                                    .fillMaxSize()
//                                    .clickable { isDrawerOpen = false }
//                            ) {
//                                Box(
//                                    modifier = Modifier
//                                        .weight(0.7f)
//                                        .fillMaxHeight()
//                                        .background(MaterialTheme.colorScheme.background, RoundedCornerShape(4.dp))
//                                        .clickable { /* Prevent click propagation */ }
//                                ) {
//                                    Column(
//                                        horizontalAlignment = Alignment.CenterHorizontally,
//                                        verticalArrangement = Arrangement.Center,
//                                        modifier = Modifier.fillMaxSize()
//                                    ) {
//                                        Button(
//                                            onClick = { theme = Theme.Light },
//                                            colors = ButtonDefaults.buttonColors(
//                                                containerColor = MaterialTheme.colorScheme.primaryContainer,
//                                                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
//                                            )
//                                        ) {
//                                            Text("Modo Claro")
//                                        }
//                                        Spacer(modifier = Modifier.height(16.dp))
//                                        Button(
//                                            onClick = { theme = Theme.Dark },
//                                            colors = ButtonDefaults.buttonColors(
//                                                containerColor = MaterialTheme.colorScheme.primaryContainer,
//                                                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
//                                            )
//                                        ) {
//                                            Text("Modo Oscuro")
//                                        }
//                                        // Añade más botones aquí
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
////package com.example.pinchandreversepinch
////
////import android.os.Bundle
////import androidx.activity.ComponentActivity
////import androidx.activity.compose.setContent
////import androidx.compose.foundation.layout.*
////import androidx.compose.material3.*
////import androidx.compose.runtime.*
////import androidx.compose.ui.Alignment
////import androidx.compose.ui.Modifier
////import androidx.compose.ui.unit.dp
////import com.example.pinchandreversepinch.ui.theme.PinchAndReversePinchTheme
////import com.example.pinchandreversepinch.ui.theme.Theme
////
////class MainActivity : ComponentActivity() {
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////        setContent {
////            var theme by remember { mutableStateOf(Theme.Light) }
////
////            PinchAndReversePinchTheme(colorScheme = theme) {
////                Surface(
////                    modifier = Modifier.fillMaxSize(),
////                    color = MaterialTheme.colorScheme.background
////                ) {
////                    Column(
////                        horizontalAlignment = Alignment.CenterHorizontally,
////                        verticalArrangement = Arrangement.Center,
////                        modifier = Modifier.fillMaxSize()
////                    ) {
////                        Button(
////                            onClick = { theme = Theme.Light },
////                            colors = ButtonDefaults.buttonColors(
////                                containerColor = MaterialTheme.colorScheme.primaryContainer,
////                                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
////                            )) {
////                            Text("Modo Claro")
////                        }
////                        Spacer(modifier = Modifier.height(16.dp))
////                        Button(
////                            onClick = { theme = Theme.Dark },
////                            colors = ButtonDefaults.buttonColors(
////                            containerColor = MaterialTheme.colorScheme.primaryContainer,
////                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
////                        )) {
////                            Text("Modo Oscuro")
////                        }
////                        Spacer(modifier = Modifier.height(16.dp))
////                        Button(
////                            onClick = { theme = Theme.lightProtanopia },
////                            colors = ButtonDefaults.buttonColors(
////                                containerColor = MaterialTheme.colorScheme.primaryContainer,
////                                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
////                            )) {
////                            Text("Modo Claro Protanopía")
////                        }
////                        Spacer(modifier = Modifier.height(16.dp))
////                        Button(
////                            onClick = { theme = Theme.DarkProtanopia },
////                            colors = ButtonDefaults.buttonColors(
////                                containerColor = MaterialTheme.colorScheme.primaryContainer,
////                                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
////                            )) {
////                            Text("Modo Oscuro Protanopía")
////                        }
////                        Spacer(modifier = Modifier.height(16.dp))
////                        Button(
////                            onClick = { theme = Theme.lightDeuteranopia },
////                            colors = ButtonDefaults.buttonColors(
////                                containerColor = MaterialTheme.colorScheme.primaryContainer,
////                                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
////                            )) {
////                            Text("Modo Claro Deuteranopía")
////                        }
////                        Spacer(modifier = Modifier.height(16.dp))
////                        Button(
////                            onClick = { theme = Theme.DarkDeuteranopia },
////                            colors = ButtonDefaults.buttonColors(
////                                containerColor = MaterialTheme.colorScheme.primaryContainer,
////                                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
////                            )) {
////                            Text("Modo Oscuro Deuteranopía")
////                        }
////                        Spacer(modifier = Modifier.height(16.dp))
////                        Button(
////                            onClick = { theme = Theme.lightTritanopia },
////                            colors = ButtonDefaults.buttonColors(
////                                containerColor = MaterialTheme.colorScheme.primaryContainer,
////                                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
////                            )) {
////                            Text("Modo Claro Tritanopía")
////                        }
////                        Spacer(modifier = Modifier.height(16.dp))
////                        Button(
////                            onClick = { theme = Theme.DarkTritanopia },
////                            colors = ButtonDefaults.buttonColors(
////                                containerColor = MaterialTheme.colorScheme.primaryContainer,
////                                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
////                            )) {
////                            Text("Modo Oscuro Tritanopía")
////                        }
////                    }
////                }
////            }
////        }
////    }
////}