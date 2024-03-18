package components

import androidx.compose.animation.AnimatedContent
import androidx.compose.runtime.Composable

@Composable
fun Layout(loading: Boolean, content: @Composable () -> Unit) {
    AnimatedContent(loading) {
        when (it) {
            true -> RotatingLogo()
            false -> content()
        }
    }
}