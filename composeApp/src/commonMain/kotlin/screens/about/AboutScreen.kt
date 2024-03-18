package screens.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import components.Layout
import kmp_desktop_android_template.composeapp.generated.resources.Res
import kmp_desktop_android_template.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


object AboutScreen : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Default.Info)

            return remember {
                TabOptions(
                    index = 4u,
                    title = "Home",
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        val screenModel = getScreenModel<AboutScreenModel>()
        val content by screenModel.content.collectAsState()
        val loading by screenModel.isLoading.collectAsState()
        contentUI(content, loading)
    }
}

@Composable
private fun contentUI(content: String, loading: Boolean) {
    Layout(loading) {
        Text(content)
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Logo() {
    Image(
        painterResource(Res.drawable.compose_multiplatform),
        contentDescription = "logo",
        modifier = Modifier.fillMaxWidth()
    )
}
