package com.example.pinchandreversepinch.ui.theme



import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = Colors.Purple80,
    secondary = Colors.PurpleGrey80,
    tertiary = Colors.Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Colors.Purple40,
    secondary = Colors.PurpleGrey40,
    tertiary = Colors.Pink40
)

object Theme {
    val Light = lightColorScheme(
        background = Colors.background_light,
        onBackground = Colors.text_light,
        primaryContainer = Colors.container_light,
        onPrimaryContainer = Colors.text_light
    )
    val Dark = darkColorScheme(
        background = Colors.background_dark,
        onBackground = Colors.text_dark,
        primaryContainer = Colors.container_dark,
        onPrimaryContainer = Colors.text_dark
    )
    val lightTritanopia = lightColorScheme(
        background = Colors.background_light_tritanopia,
        onBackground = Colors.text_light_tritanopia,
        primaryContainer = Colors.background_light_tritanopia,
        onPrimaryContainer = Colors.text_light_tritanopia
    )
    val DarkTritanopia = darkColorScheme(
        background = Colors.background_dark_tritanopia,
        onBackground = Colors.text_dark_tritanopia,
        primaryContainer = Colors.background_dark_tritanopia,
        onPrimaryContainer = Colors.text_dark_tritanopia
    )
    val lightProtanopia = lightColorScheme(
        background = Colors.background_light_protanopia,
        onBackground = Colors.text_light_protanopia,
        primaryContainer = Colors.background_light_protanopia,
        onPrimaryContainer = Colors.text_light_protanopia
    )
    val DarkProtanopia = darkColorScheme(
        background = Colors.background_dark_protanopia,
        onBackground = Colors.text_dark_protanopia,
        primaryContainer = Colors.background_dark_protanopia,
        onPrimaryContainer = Colors.text_dark_protanopia
    )
    val lightDeuteranopia = lightColorScheme(
        background = Colors.background_light_deuteranopia,
        onBackground = Colors.text_light_deuteranopia,
        primaryContainer = Colors.background_light_deuteranopia,
        onPrimaryContainer = Colors.text_light_deuteranopia
    )
    val DarkDeuteranopia = darkColorScheme(
        background = Colors.background_dark_deuteranopia,
        onBackground = Colors.text_dark_deuteranopia,
        primaryContainer = Colors.background_dark_deuteranopia,
        onPrimaryContainer = Colors.text_dark_deuteranopia
    )
}

@Composable
fun PinchAndReversePinchTheme(
    colorScheme: ColorScheme,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = colorScheme,
        content = content,
        typography = Typography
    )
}