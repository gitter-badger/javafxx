@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.Node
import javafx.scene.control.Accordion
import javafx.scene.control.Button
import javafx.scene.control.CheckBox
import javafx.scene.control.ChoiceBox
import javafx.scene.control.ColorPicker
import javafx.scene.control.ComboBox
import javafx.scene.control.DatePicker
import javafx.scene.control.Hyperlink
import javafx.scene.control.Label
import javafx.scene.control.ListView
import javafx.scene.control.MenuButton
import javafx.scene.control.MenuItem
import javafx.scene.control.Pagination
import javafx.scene.control.Pagination.INDETERMINATE
import javafx.scene.control.PasswordField
import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressBar.INDETERMINATE_PROGRESS
import javafx.scene.control.ProgressIndicator
import javafx.scene.control.RadioButton
import javafx.scene.control.ScrollBar
import javafx.scene.control.ScrollPane
import javafx.scene.control.Separator
import javafx.scene.control.Slider
import javafx.scene.control.Spinner
import javafx.scene.control.SplitMenuButton
import javafx.scene.control.SplitPane
import javafx.scene.control.TableView
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import javafx.scene.control.TitledPane
import javafx.scene.control.ToggleButton
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableView
import javafx.scene.control.TreeView
import javafx.scene.layout.Pane
import javafx.scene.layout.Region
import javafx.scene.paint.Color
import javafx.scene.paint.Color.WHITE
import ktfx.collections.mutableObservableListOf
import java.time.LocalDate

inline fun region(noinline init: ((@LayoutDsl Region).() -> Unit)? = null): Region = Region().apply { init?.invoke(this) }
inline fun ChildManager.region(noinline init: ((@LayoutDsl Region).() -> Unit)? = null): Region = ktfx.layouts.region(init).add()
inline fun ItemManager.region(noinline init: ((@LayoutDsl Region).() -> Unit)? = null): Region = ktfx.layouts.region(init).add()
inline fun ButtonManager.region(noinline init: ((@LayoutDsl Region).() -> Unit)? = null): Region = ktfx.layouts.region(init).add()

inline fun pane(noinline init: ((@LayoutDsl Pane).() -> Unit)? = null): Pane = Pane().apply { init?.invoke(this) }
inline fun ChildManager.pane(noinline init: ((@LayoutDsl Pane).() -> Unit)? = null): Pane = ktfx.layouts.pane(init).add()
inline fun ItemManager.pane(noinline init: ((@LayoutDsl Pane).() -> Unit)? = null): Pane = ktfx.layouts.pane(init).add()
inline fun ButtonManager.pane(noinline init: ((@LayoutDsl Pane).() -> Unit)? = null): Pane = ktfx.layouts.pane(init).add()

inline fun accordion(vararg titledPanes: TitledPane, noinline init: ((@LayoutDsl Accordion).() -> Unit)? = null): Accordion = Accordion(*titledPanes).apply { init?.invoke(this) }
inline fun ChildManager.accordion(vararg titledPanes: TitledPane, noinline init: ((@LayoutDsl Accordion).() -> Unit)? = null): Accordion = ktfx.layouts.accordion(*titledPanes, init = init).add()
inline fun ItemManager.accordion(vararg titledPanes: TitledPane, noinline init: ((@LayoutDsl Accordion).() -> Unit)? = null): Accordion = ktfx.layouts.accordion(*titledPanes, init = init).add()
inline fun ButtonManager.accordion(vararg titledPanes: TitledPane, noinline init: ((@LayoutDsl Accordion).() -> Unit)? = null): Accordion = ktfx.layouts.accordion(*titledPanes, init = init).add()

inline fun button(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl Button).() -> Unit)? = null): Button = Button(text, graphic).apply { init?.invoke(this) }
inline fun ChildManager.button(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl Button).() -> Unit)? = null): Button = ktfx.layouts.button(text, graphic, init).add()
inline fun ItemManager.button(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl Button).() -> Unit)? = null): Button = ktfx.layouts.button(text, graphic, init).add()
inline fun ButtonManager.button(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl Button).() -> Unit)? = null): Button = ktfx.layouts.button(text, graphic, init).add()

inline fun checkBox(text: String? = null, noinline init: ((@LayoutDsl CheckBox).() -> Unit)? = null): CheckBox = CheckBox(text).apply { init?.invoke(this) }
inline fun ChildManager.checkBox(text: String? = null, noinline init: ((@LayoutDsl CheckBox).() -> Unit)? = null): CheckBox = ktfx.layouts.checkBox(text, init).add()
inline fun ItemManager.checkBox(text: String? = null, noinline init: ((@LayoutDsl CheckBox).() -> Unit)? = null): CheckBox = ktfx.layouts.checkBox(text, init).add()
inline fun ButtonManager.checkBox(text: String? = null, noinline init: ((@LayoutDsl CheckBox).() -> Unit)? = null): CheckBox = ktfx.layouts.checkBox(text, init).add()

inline fun <T> choiceBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ChoiceBox<T>).() -> Unit)? = null): ChoiceBox<T> = ChoiceBox(items).apply { init?.invoke(this) }
inline fun <T> ChildManager.choiceBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ChoiceBox<T>).() -> Unit)? = null): ChoiceBox<T> = ktfx.layouts.choiceBox(items, init).add()
inline fun <T> ItemManager.choiceBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ChoiceBox<T>).() -> Unit)? = null): ChoiceBox<T> = ktfx.layouts.choiceBox(items, init).add()
inline fun <T> ButtonManager.choiceBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ChoiceBox<T>).() -> Unit)? = null): ChoiceBox<T> = ktfx.layouts.choiceBox(items, init).add()

inline fun colorPicker(color: Color = WHITE, noinline init: ((@LayoutDsl ColorPicker).() -> Unit)? = null): ColorPicker = ColorPicker(color).apply { init?.invoke(this) }
inline fun ChildManager.colorPicker(color: Color = WHITE, noinline init: ((@LayoutDsl ColorPicker).() -> Unit)? = null): ColorPicker = ktfx.layouts.colorPicker(color, init).add()
inline fun ItemManager.colorPicker(color: Color = WHITE, noinline init: ((@LayoutDsl ColorPicker).() -> Unit)? = null): ColorPicker = ktfx.layouts.colorPicker(color, init).add()
inline fun ButtonManager.colorPicker(color: Color = WHITE, noinline init: ((@LayoutDsl ColorPicker).() -> Unit)? = null): ColorPicker = ktfx.layouts.colorPicker(color, init).add()

inline fun <T> comboBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ComboBox<T>).() -> Unit)? = null): ComboBox<T> = ComboBox(items).apply { init?.invoke(this) }
inline fun <T> ChildManager.comboBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ComboBox<T>).() -> Unit)? = null): ComboBox<T> = ktfx.layouts.comboBox(items, init).add()
inline fun <T> ItemManager.comboBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ComboBox<T>).() -> Unit)? = null): ComboBox<T> = ktfx.layouts.comboBox(items, init).add()
inline fun <T> ButtonManager.comboBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ComboBox<T>).() -> Unit)? = null): ComboBox<T> = ktfx.layouts.comboBox(items, init).add()

inline fun datePicker(date: LocalDate? = null, noinline init: ((@LayoutDsl DatePicker).() -> Unit)? = null): DatePicker = DatePicker(date).apply { init?.invoke(this) }
inline fun ChildManager.datePicker(date: LocalDate? = null, noinline init: ((@LayoutDsl DatePicker).() -> Unit)? = null): DatePicker = ktfx.layouts.datePicker(date, init).add()
inline fun ItemManager.datePicker(date: LocalDate? = null, noinline init: ((@LayoutDsl DatePicker).() -> Unit)? = null): DatePicker = ktfx.layouts.datePicker(date, init).add()
inline fun ButtonManager.datePicker(date: LocalDate? = null, noinline init: ((@LayoutDsl DatePicker).() -> Unit)? = null): DatePicker = ktfx.layouts.datePicker(date, init).add()

inline fun hyperlink(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl Hyperlink).() -> Unit)? = null): Hyperlink = Hyperlink(text, graphic).apply { init?.invoke(this) }
inline fun ChildManager.hyperlink(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl Hyperlink).() -> Unit)? = null): Hyperlink = ktfx.layouts.hyperlink(text, graphic, init).add()
inline fun ItemManager.hyperlink(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl Hyperlink).() -> Unit)? = null): Hyperlink = ktfx.layouts.hyperlink(text, graphic, init).add()
inline fun ButtonManager.hyperlink(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl Hyperlink).() -> Unit)? = null): Hyperlink = ktfx.layouts.hyperlink(text, graphic, init).add()

inline fun label(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl Label).() -> Unit)? = null): Label = Label(text, graphic).apply { init?.invoke(this) }
inline fun ChildManager.label(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl Label).() -> Unit)? = null): Label = ktfx.layouts.label(text, graphic, init).add()
inline fun ItemManager.label(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl Label).() -> Unit)? = null): Label = ktfx.layouts.label(text, graphic, init).add()
inline fun ButtonManager.label(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl Label).() -> Unit)? = null): Label = ktfx.layouts.label(text, graphic, init).add()

inline fun <T> listView(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ListView<T>).() -> Unit)? = null): ListView<T> = ListView(items).apply { init?.invoke(this) }
inline fun <T> ChildManager.listView(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ListView<T>).() -> Unit)? = null): ListView<T> = ktfx.layouts.listView(items, init).add()
inline fun <T> ItemManager.listView(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ListView<T>).() -> Unit)? = null): ListView<T> = ktfx.layouts.listView(items, init).add()
inline fun <T> ButtonManager.listView(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ListView<T>).() -> Unit)? = null): ListView<T> = ktfx.layouts.listView(items, init).add()

inline fun menuButton(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl MenuButton).() -> Unit)? = null): MenuButton = MenuButton(text, graphic).apply { init?.invoke(this) }
inline fun ChildManager.menuButton(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl MenuButton).() -> Unit)? = null): MenuButton = ktfx.layouts.menuButton(text, graphic, init).add()
inline fun ItemManager.menuButton(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl MenuButton).() -> Unit)? = null): MenuButton = ktfx.layouts.menuButton(text, graphic, init).add()
inline fun ButtonManager.menuButton(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl MenuButton).() -> Unit)? = null): MenuButton = ktfx.layouts.menuButton(text, graphic, init).add()

inline fun pagination(count: Int = INDETERMINATE, index: Int = 0, noinline init: ((@LayoutDsl Pagination).() -> Unit)? = null): Pagination = Pagination(count, index).apply { init?.invoke(this) }
inline fun ChildManager.pagination(count: Int = INDETERMINATE, index: Int = 0, noinline init: ((@LayoutDsl Pagination).() -> Unit)? = null): Pagination = ktfx.layouts.pagination(count, index, init).add()
inline fun ItemManager.pagination(count: Int = INDETERMINATE, index: Int = 0, noinline init: ((@LayoutDsl Pagination).() -> Unit)? = null): Pagination = ktfx.layouts.pagination(count, index, init).add()
inline fun ButtonManager.pagination(count: Int = INDETERMINATE, index: Int = 0, noinline init: ((@LayoutDsl Pagination).() -> Unit)? = null): Pagination = ktfx.layouts.pagination(count, index, init).add()

inline fun passwordField(noinline init: ((@LayoutDsl PasswordField).() -> Unit)? = null): PasswordField = PasswordField().apply { init?.invoke(this) }
inline fun ChildManager.passwordField(noinline init: ((@LayoutDsl PasswordField).() -> Unit)? = null): PasswordField = ktfx.layouts.passwordField(init).add()
inline fun ItemManager.passwordField(noinline init: ((@LayoutDsl PasswordField).() -> Unit)? = null): PasswordField = ktfx.layouts.passwordField(init).add()
inline fun ButtonManager.passwordField(noinline init: ((@LayoutDsl PasswordField).() -> Unit)? = null): PasswordField = ktfx.layouts.passwordField(init).add()

inline fun progressBar(progress: Double = INDETERMINATE_PROGRESS, noinline init: ((@LayoutDsl ProgressBar).() -> Unit)? = null): ProgressBar = ProgressBar(progress).apply { init?.invoke(this) }
inline fun ChildManager.progressBar(progress: Double = INDETERMINATE_PROGRESS, noinline init: ((@LayoutDsl ProgressBar).() -> Unit)? = null): ProgressBar = ktfx.layouts.progressBar(progress, init).add()
inline fun ItemManager.progressBar(progress: Double = INDETERMINATE_PROGRESS, noinline init: ((@LayoutDsl ProgressBar).() -> Unit)? = null): ProgressBar = ktfx.layouts.progressBar(progress, init).add()
inline fun ButtonManager.progressBar(progress: Double = INDETERMINATE_PROGRESS, noinline init: ((@LayoutDsl ProgressBar).() -> Unit)? = null): ProgressBar = ktfx.layouts.progressBar(progress, init).add()

inline fun progressIndicator(progress: Double = INDETERMINATE_PROGRESS, noinline init: ((@LayoutDsl ProgressIndicator).() -> Unit)? = null): ProgressIndicator = ProgressIndicator(progress).apply { init?.invoke(this) }
inline fun ChildManager.progressIndicator(progress: Double = INDETERMINATE_PROGRESS, noinline init: ((@LayoutDsl ProgressIndicator).() -> Unit)? = null): ProgressIndicator = ktfx.layouts.progressIndicator(progress, init).add()
inline fun ItemManager.progressIndicator(progress: Double = INDETERMINATE_PROGRESS, noinline init: ((@LayoutDsl ProgressIndicator).() -> Unit)? = null): ProgressIndicator = ktfx.layouts.progressIndicator(progress, init).add()
inline fun ButtonManager.progressIndicator(progress: Double = INDETERMINATE_PROGRESS, noinline init: ((@LayoutDsl ProgressIndicator).() -> Unit)? = null): ProgressIndicator = ktfx.layouts.progressIndicator(progress, init).add()

inline fun radioButton(text: String? = null, noinline init: ((@LayoutDsl RadioButton).() -> Unit)? = null): RadioButton = RadioButton(text).apply { init?.invoke(this) }
inline fun ChildManager.radioButton(text: String? = null, noinline init: ((@LayoutDsl RadioButton).() -> Unit)? = null): RadioButton = ktfx.layouts.radioButton(text, init).add()
inline fun ItemManager.radioButton(text: String? = null, noinline init: ((@LayoutDsl RadioButton).() -> Unit)? = null): RadioButton = ktfx.layouts.radioButton(text, init).add()
inline fun ButtonManager.radioButton(text: String? = null, noinline init: ((@LayoutDsl RadioButton).() -> Unit)? = null): RadioButton = ktfx.layouts.radioButton(text, init).add()

inline fun scrollBar(noinline init: ((@LayoutDsl ScrollBar).() -> Unit)? = null): ScrollBar = ScrollBar().apply { init?.invoke(this) }
inline fun ChildManager.scrollBar(noinline init: ((@LayoutDsl ScrollBar).() -> Unit)? = null): ScrollBar = ktfx.layouts.scrollBar(init).add()
inline fun ItemManager.scrollBar(noinline init: ((@LayoutDsl ScrollBar).() -> Unit)? = null): ScrollBar = ktfx.layouts.scrollBar(init).add()
inline fun ButtonManager.scrollBar(noinline init: ((@LayoutDsl ScrollBar).() -> Unit)? = null): ScrollBar = ktfx.layouts.scrollBar(init).add()

inline fun scrollPane(content: Node? = null, noinline init: ((@LayoutDsl ScrollPane).() -> Unit)? = null): ScrollPane = ScrollPane(content).apply { init?.invoke(this) }
inline fun ChildManager.scrollPane(content: Node? = null, noinline init: ((@LayoutDsl ScrollPane).() -> Unit)? = null): ScrollPane = ktfx.layouts.scrollPane(content, init).add()
inline fun ItemManager.scrollPane(content: Node? = null, noinline init: ((@LayoutDsl ScrollPane).() -> Unit)? = null): ScrollPane = ktfx.layouts.scrollPane(content, init).add()
inline fun ButtonManager.scrollPane(content: Node? = null, noinline init: ((@LayoutDsl ScrollPane).() -> Unit)? = null): ScrollPane = ktfx.layouts.scrollPane(content, init).add()

inline fun separator(orientation: Orientation = HORIZONTAL, noinline init: ((@LayoutDsl Separator).() -> Unit)? = null): Separator = Separator(orientation).apply { init?.invoke(this) }
inline fun ChildManager.separator(orientation: Orientation = HORIZONTAL, noinline init: ((@LayoutDsl Separator).() -> Unit)? = null): Separator = ktfx.layouts.separator(orientation, init).add()
inline fun ItemManager.separator(orientation: Orientation = HORIZONTAL, noinline init: ((@LayoutDsl Separator).() -> Unit)? = null): Separator = ktfx.layouts.separator(orientation, init).add()
inline fun ButtonManager.separator(orientation: Orientation = HORIZONTAL, noinline init: ((@LayoutDsl Separator).() -> Unit)? = null): Separator = ktfx.layouts.separator(orientation, init).add()

inline fun slider(min: Double, max: Double, value: Double, noinline init: ((@LayoutDsl Slider).() -> Unit)? = null): Slider = Slider(min, max, value).apply { init?.invoke(this) }
inline fun ChildManager.slider(min: Double, max: Double, value: Double, noinline init: ((@LayoutDsl Slider).() -> Unit)? = null): Slider = ktfx.layouts.slider(min, max, value, init).add()
inline fun ItemManager.slider(min: Double, max: Double, value: Double, noinline init: ((@LayoutDsl Slider).() -> Unit)? = null): Slider = ktfx.layouts.slider(min, max, value, init).add()
inline fun ButtonManager.slider(min: Double, max: Double, value: Double, noinline init: ((@LayoutDsl Slider).() -> Unit)? = null): Slider = ktfx.layouts.slider(min, max, value, init).add()

inline fun <T> spinner(noinline init: ((@LayoutDsl Spinner<T>).() -> Unit)? = null): Spinner<T> = Spinner<T>().apply { init?.invoke(this) }
inline fun <T> ChildManager.spinner(noinline init: ((@LayoutDsl Spinner<T>).() -> Unit)? = null): Spinner<T> = ktfx.layouts.spinner(init).add()
inline fun <T> ItemManager.spinner(noinline init: ((@LayoutDsl Spinner<T>).() -> Unit)? = null): Spinner<T> = ktfx.layouts.spinner(init).add()
inline fun <T> ButtonManager.spinner(noinline init: ((@LayoutDsl Spinner<T>).() -> Unit)? = null): Spinner<T> = ktfx.layouts.spinner(init).add()

inline fun splitMenuButton(vararg items: MenuItem, noinline init: ((@LayoutDsl SplitMenuButton).() -> Unit)? = null): SplitMenuButton = SplitMenuButton(*items).apply { init?.invoke(this) }
inline fun ChildManager.splitMenuButton(vararg items: MenuItem, noinline init: ((@LayoutDsl SplitMenuButton).() -> Unit)? = null): SplitMenuButton = ktfx.layouts.splitMenuButton(*items, init = init).add()
inline fun ItemManager.splitMenuButton(vararg items: MenuItem, noinline init: ((@LayoutDsl SplitMenuButton).() -> Unit)? = null): SplitMenuButton = ktfx.layouts.splitMenuButton(*items, init = init).add()
inline fun ButtonManager.splitMenuButton(vararg items: MenuItem, noinline init: ((@LayoutDsl SplitMenuButton).() -> Unit)? = null): SplitMenuButton = ktfx.layouts.splitMenuButton(*items, init = init).add()

inline fun splitPane(vararg items: Node, noinline init: ((@LayoutDsl SplitPane).() -> Unit)? = null): SplitPane = SplitPane(*items).apply { init?.invoke(this) }
inline fun ChildManager.splitPane(vararg items: Node, noinline init: ((@LayoutDsl SplitPane).() -> Unit)? = null): SplitPane = ktfx.layouts.splitPane(*items, init = init).add()
inline fun ItemManager.splitPane(vararg items: Node, noinline init: ((@LayoutDsl SplitPane).() -> Unit)? = null): SplitPane = ktfx.layouts.splitPane(*items, init = init).add()
inline fun ButtonManager.splitPane(vararg items: Node, noinline init: ((@LayoutDsl SplitPane).() -> Unit)? = null): SplitPane = ktfx.layouts.splitPane(*items, init = init).add()

inline fun <S> tableView(items: ObservableList<S> = mutableObservableListOf(), noinline init: ((@LayoutDsl TableView<S>).() -> Unit)? = null): TableView<S> = TableView<S>(items).apply { init?.invoke(this) }
inline fun <S> ChildManager.tableView(items: ObservableList<S> = mutableObservableListOf(), noinline init: ((@LayoutDsl TableView<S>).() -> Unit)? = null): TableView<S> = ktfx.layouts.tableView(items, init).add()
inline fun <S> ItemManager.tableView(items: ObservableList<S> = mutableObservableListOf(), noinline init: ((@LayoutDsl TableView<S>).() -> Unit)? = null): TableView<S> = ktfx.layouts.tableView(items, init).add()
inline fun <S> ButtonManager.tableView(items: ObservableList<S> = mutableObservableListOf(), noinline init: ((@LayoutDsl TableView<S>).() -> Unit)? = null): TableView<S> = ktfx.layouts.tableView(items, init).add()

inline fun textArea(text: String = "", noinline init: ((@LayoutDsl TextArea).() -> Unit)? = null): TextArea = TextArea(text).apply { init?.invoke(this) }
inline fun ChildManager.textArea(text: String = "", noinline init: ((@LayoutDsl TextArea).() -> Unit)? = null): TextArea = ktfx.layouts.textArea(text, init).add()
inline fun ItemManager.textArea(text: String = "", noinline init: ((@LayoutDsl TextArea).() -> Unit)? = null): TextArea = ktfx.layouts.textArea(text, init).add()
inline fun ButtonManager.textArea(text: String = "", noinline init: ((@LayoutDsl TextArea).() -> Unit)? = null): TextArea = ktfx.layouts.textArea(text, init).add()

inline fun textField(text: String = "", noinline init: ((@LayoutDsl TextField).() -> Unit)? = null): TextField = TextField(text).apply { init?.invoke(this) }
inline fun ChildManager.textField(text: String = "", noinline init: ((@LayoutDsl TextField).() -> Unit)? = null): TextField = ktfx.layouts.textField(text, init).add()
inline fun ItemManager.textField(text: String = "", noinline init: ((@LayoutDsl TextField).() -> Unit)? = null): TextField = ktfx.layouts.textField(text, init).add()
inline fun ButtonManager.textField(text: String = "", noinline init: ((@LayoutDsl TextField).() -> Unit)? = null): TextField = ktfx.layouts.textField(text, init).add()

inline fun titledPane(text: String? = null, content: Node? = null, noinline init: ((@LayoutDsl TitledPane).() -> Unit)? = null): TitledPane = TitledPane(text, content).apply { init?.invoke(this) }
inline fun ChildManager.titledPane(text: String? = null, content: Node? = null, noinline init: ((@LayoutDsl TitledPane).() -> Unit)? = null): TitledPane = ktfx.layouts.titledPane(text, content, init).add()
inline fun ItemManager.titledPane(text: String? = null, content: Node? = null, noinline init: ((@LayoutDsl TitledPane).() -> Unit)? = null): TitledPane = ktfx.layouts.titledPane(text, content, init).add()
inline fun ButtonManager.titledPane(text: String? = null, content: Node? = null, noinline init: ((@LayoutDsl TitledPane).() -> Unit)? = null): TitledPane = ktfx.layouts.titledPane(text, content, init).add()

inline fun toggleButton(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl ToggleButton).() -> Unit)? = null): ToggleButton = ToggleButton(text, graphic).apply { init?.invoke(this) }
inline fun ChildManager.toggleButton(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl ToggleButton).() -> Unit)? = null): ToggleButton = ktfx.layouts.toggleButton(text, graphic, init).add()
inline fun ItemManager.toggleButton(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl ToggleButton).() -> Unit)? = null): ToggleButton = ktfx.layouts.toggleButton(text, graphic, init).add()
inline fun ButtonManager.toggleButton(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl ToggleButton).() -> Unit)? = null): ToggleButton = ktfx.layouts.toggleButton(text, graphic, init).add()

inline fun <S> treeTableView(root: TreeItem<S>? = null, noinline init: ((@LayoutDsl TreeTableView<S>).() -> Unit)? = null): TreeTableView<S> = TreeTableView<S>(root).apply { init?.invoke(this) }
inline fun <S> ChildManager.treeTableView(root: TreeItem<S>? = null, noinline init: ((@LayoutDsl TreeTableView<S>).() -> Unit)? = null): TreeTableView<S> = ktfx.layouts.treeTableView(root, init).add()
inline fun <S> ItemManager.treeTableView(root: TreeItem<S>? = null, noinline init: ((@LayoutDsl TreeTableView<S>).() -> Unit)? = null): TreeTableView<S> = ktfx.layouts.treeTableView(root, init).add()
inline fun <S> ButtonManager.treeTableView(root: TreeItem<S>? = null, noinline init: ((@LayoutDsl TreeTableView<S>).() -> Unit)? = null): TreeTableView<S> = ktfx.layouts.treeTableView(root, init).add()

inline fun <T> treeView(root: TreeItem<T>? = null, noinline init: ((@LayoutDsl TreeView<T>).() -> Unit)? = null): TreeView<T> = TreeView<T>(root).apply { init?.invoke(this) }
inline fun <T> ChildManager.treeView(root: TreeItem<T>? = null, noinline init: ((@LayoutDsl TreeView<T>).() -> Unit)? = null): TreeView<T> = ktfx.layouts.treeView(root, init).add()
inline fun <T> ItemManager.treeView(root: TreeItem<T>? = null, noinline init: ((@LayoutDsl TreeView<T>).() -> Unit)? = null): TreeView<T> = ktfx.layouts.treeView(root, init).add()
inline fun <T> ButtonManager.treeView(root: TreeItem<T>? = null, noinline init: ((@LayoutDsl TreeView<T>).() -> Unit)? = null): TreeView<T> = ktfx.layouts.treeView(root, init).add()