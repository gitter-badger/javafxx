package javafxx.coroutines

import javafx.scene.media.MediaMarkerEvent
import javafx.scene.media.MediaPlayer
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Sets the marker event handler. */
fun MediaPlayer.onMarker(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MediaMarkerEvent) -> Unit
) = setOnMarker { event -> launch(context) { action(event) } }