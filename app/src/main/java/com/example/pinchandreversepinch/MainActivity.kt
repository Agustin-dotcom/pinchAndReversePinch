package com.example.pinchandreversepinch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material.

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var theme by remember { mutableStateOf(Theme.Light) }
            var isDrawerOpen by remember { mutableStateOf(false) }

            PinchAndReversePinchTheme(colorScheme = theme) {
                Box(modifier = Modifier.fillMaxSize()) {
                    // Main content
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
                        }
                    }

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
                                        .align(Alignment.TopEnd)
                                        .background(Color.Transparent)
                                ) {
                                    Spacer(
                                        modifier = Modifier
                                            .weight(0.3f)
                                            .fillMaxHeight()
                                            .clickable { isDrawerOpen = false }
                                    )
                                    Box(
                                        modifier = Modifier
                                            .weight(0.7f)
                                            .fillMaxHeight()
                                            .background(Color.White, RoundedCornerShape(4.dp))
                                            .clickable { /* Prevent click propagation */ }
                                    ) {
                                        Column(
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center,
                                            modifier = Modifier.fillMaxSize()
                                        ) {
                                            Button(
                                                onClick = { theme = Theme.Light },
                                                colors = ButtonDefaults.buttonColors(
                                                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                                                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                                                )
                                            ) {
                                                Text("Modo Claro")
                                            }
                                            Spacer(modifier = Modifier.height(16.dp))
                                            Button(
                                                onClick = { theme = Theme.Dark },
                                                colors = ButtonDefaults.buttonColors(
                                                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                                                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                                                )
                                            ) {
                                                Text("Modo Oscuro")
                                            }
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