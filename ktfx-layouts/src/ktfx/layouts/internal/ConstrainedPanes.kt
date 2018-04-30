package ktfx.layouts.internal

import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.Node
import javafx.scene.layout.Priority
import ktfx.internal.KtFXInternals.NO_GETTER
import ktfx.internal.KtFXInternals.noGetter
import kotlin.DeprecationLevel.ERROR

internal interface ConstrainedPane {

    fun Node.reset()
}

internal interface MarginedPane : ConstrainedPane {

    infix fun <N : Node> N.margins(margins: Insets?): N = also { it.margins = margins }

    infix fun <N : Node> N.marginAll(marginAll: Double?) = also { it.marginAll = marginAll }

    infix fun <N : Node> N.marginTop(marginTop: Double?): N = also { it.marginTop = marginTop }

    infix fun <N : Node> N.marginRight(marginRight: Double?): N = also { it.marginRight = marginRight }

    infix fun <N : Node> N.marginBottom(marginBottom: Double?): N = also { it.marginBottom = marginBottom }

    infix fun <N : Node> N.marginLeft(marginLeft: Double?): N = also { it.marginLeft = marginLeft }

    var Node.margins: Insets? // alias for reserved variable `margin`

    var Node.marginAll: Double?
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) {
            margins = value?.let { Insets(it) }
        }

    var Node.marginTop: Double?
        get() = margins?.top
        set(value) = updateMargin(top = value)

    var Node.marginRight: Double?
        get() = margins?.right
        set(value) = updateMargin(right = value)

    var Node.marginBottom: Double?
        get() = margins?.bottom
        set(value) = updateMargin(bottom = value)

    var Node.marginLeft: Double?
        get() = margins?.left
        set(value) = updateMargin(left = value)

    fun Node.updateMargin(
        top: Double? = marginTop,
        right: Double? = marginRight,
        bottom: Double? = marginBottom,
        left: Double? = marginLeft
    ) {
        margins = Insets(top ?: 0.0, right ?: 0.0, bottom ?: 0.0, left ?: 0.0)
    }
}

internal interface AlignedPane : ConstrainedPane {

    infix fun <N : Node> N.pos(pos: Pos?): N = also { it.pos = pos }

    var Node.pos: Pos?
}

internal interface HAlignedPane : ConstrainedPane {

    infix fun <N : Node> N.hpos(hpos: HPos?): N = also { it.hpos = hpos }

    var Node.hpos: HPos?
}

internal interface VAlignedPane : ConstrainedPane {

    infix fun <N : Node> N.vpos(vpos: VPos?): N = also { it.vpos = vpos }

    var Node.vpos: VPos?
}

internal interface HGrowedPane : ConstrainedPane {

    infix fun <N : Node> N.hpriority(hpriority: Priority?): N = also { it.hpriority = hpriority }

    var Node.hpriority: Priority?
}

internal interface VGrowedPane : ConstrainedPane {

    infix fun <N : Node> N.vpriority(vpriority: Priority?): N = also { it.vpriority = vpriority }

    var Node.vpriority: Priority?
}