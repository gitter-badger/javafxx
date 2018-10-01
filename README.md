ktfx
====
[![bintray](https://img.shields.io/badge/bintray-ktfx-brightgreen.svg)](https://bintray.com/hendraanggrian/ktfx)
[![download](https://api.bintray.com/packages/hendraanggrian/ktfx/ktfx/images/download.svg)](https://bintray.com/hendraanggrian/ktfx/ktfx/_latestVersion)
[![build](https://travis-ci.com/hendraanggrian/ktfx.svg)](https://travis-ci.com/hendraanggrian/ktfx)
[![license](https://img.shields.io/badge/license-Apache--2.0-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)
[![gitter](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/hendraanggrian/ktfx) [![Join the chat at https://gitter.im/hendraanggrian/ktfx](https://badges.gitter.im/hendraanggrian/ktfx.svg)](https://gitter.im/hendraanggrian/ktfx?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

[Kotlin] extensions for JavaFX app development. Written in spirit of [android-ktx] and [anko].

Consists of several parts:
 * *ktfx-commons*: full of helpers for common JavaFX application logic.
 * *ktfx-layouts*: dynamic JavaFX layout with Kotlin DSL.
 * *ktfx-listeners*: write common JavaFX listeners with Kotlin DSL.
 * *ktfx-coroutines*: utilities based on the experimental [kotlinx.coroutines] library.
 * *ktfx-styles*: type-safe inline CSS styling.

Download
--------
All artifacts are hosted on [jcenter]. To download all of the main features, use:

```gradle
dependencies {
    compile 'com.hendraanggrian.ktfx:ktfx:$version'
}
```

Or download separate libraries if only specific features are desired:

```gradle
dependencies {
    compile 'com.hendraanggrian.ktfx:ktfx-commons:$version'
    compile 'com.hendraanggrian.ktfx:ktfx-layouts:$version'
    compile 'com.hendraanggrian.ktfx:ktfx-listeners:$version'
    compile 'com.hendraanggrian.ktfx:ktfx-coroutines:$version'
    compile 'com.hendraanggrian.ktfx:ktfx-styles:$version'
}
```

Core Extensions
---------------
Full of extensions for JavaFX, packaged accordingly.
The main goal of core library is not to add any new feature to the existing JavaFX APIs.
Below are preview of some of the packages.

#### Collections

```kotlin
// create unmodifiable observable collection
val emptyUnmodifiableList = emptyObservableList()
val unmodifiableList = observableListOf(1)

// create modifiable observable collection
val emptyModifiableList = mutableObservableListOf()
val modifiableList = mutableObservableListOf(1, 2, 3)

// convert existing
val list = myList.toObservableList() // or toMutableObservableList() for modifiable version
```

#### Bindings

```kotlin
// infix conditional binding
button.disableProperty().bind(firstName.textProperty().isEmpty or lastName.textProperty().isEmpty)

// operator binding for number properties
totalProperty.bind(qtyProperty * priceProperty)

// infix binding for number properties
loginButton.disableProperty().bind(passwordField.textProperty.length() less 4)

// custom binding
label.graphicProperty().bind(stringBindingOf(listView.selectionModel.selectedIndexProperty()) {
    "${listView.selectionModel.selectedIndex} selected"
})
imageView.imageProperty().bind(bindingOf(urlField.textProperty()) {
    Image(urlField.text)
})
```

#### Dialogs

```kotlin
// show an alert
alert("Here's an alert").show()

// show a confirmation alert and wait for input
confirmAlert("Are you sure?").showAndWait()

// custom init a text input dialog
inputDialog("Question #1") {
    contentText = "Why does the chicken cross the road?"
    editor.promptText = "Hint"
}.showAndWait()

// a choice dialog
choiceDialog("Pick an item", ImageView("/my/image.png"), items)
    .showAndWait()

// show a custom dialog
dialog<String>("Who's a little piggy?") {
    content = ...
    yesButton()
    noButton()
    customButton("What's a piggy?") {
        // explain what a piggy is
    }
    resultConverter {
        if(it == button1)  "Me" else null  
    }
}.showAndWait()
```

Layouts Extensions
------------------
Generate JavaFX layouts, controls, shapes, and charts with Kotlin DSL. 
It's a direct replacement of FXML files.

```kotlin
gridPane {
    gaps = 8
    label("First name") row 0 col 0
    val firstName = textField() row 0 col 1
    label("Last name") row 1 col 0
    val lastName = textField() row 1 col 1
    button("Say hello") {
        setOnAction {
            infoAlert("Hello, ${firstName.text} ${lastName.text}!")
                .show()
        }
    } hpos RIGHT row 2 col 1
}
```

![Layouts demo][demo_layouts]

Listeners Extensions
--------------------
Trade common JavaFX listener with Kotlin DSL.
Currently includes string converters and table cells.

```kotlin
// string converter
val dateBox = ChoiceBox<Date>()
dateBox.converter {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy")
    fromString {
        dateFormat.parse(it)
    }
    toString {
        dateFormat.format(it)
    }
}

// custom list cell
val personList = ListView<Person>()
personList.cellFactory {
    onUpdateItem { person, empty ->
        if (person != null && !empty) {
            graphic = Button("Do something")
        }
    }
}
```

Coroutines Extensions
---------------------
Based on the experimental [kotlinx.coroutines] library, it allows invoking JavaFX `EventHandler` the coroutine way.

```kotlin
button.setOnAction {
    doSomethingInBackground()// might freeze UI
    celebrateCompletion()
}

button.onAction(CommonPool) {
    doSomethingInBackground() // non-blocking in common pool
    launch(FX) {
        celebrateCompletion()
    }
}
```

Styles Extensions
-----------------
When writing inline styles, longer strings tend to be hard to read and more likely to cause error.
Replace it with type-safe style builders.

```kotlin
// error prone string
label.style = "-fx-alignment: right; -fx-wrap-text: true; -fx-text-fill: red;"

// type-safe DSL
label.style = labeledStyle {
    alignment = Pos.CENTER_RIGHT
    wrapText = true
    textFill = Color.RED
}
```

Third-party Extensions
----------------------
Some popular libraries are also supported. Though currently is limited.

```gradle
dependencies {
    compile 'com.hendraanggrian.ktfx:ktfx-controlsfx:$version'
    compile 'com.hendraanggrian.ktfx:ktfx-jfoenix:$version'
}
```

License
-------
    Copyright 2018 Hendra Anggrian

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[Kotlin]: https://kotlinlang.org/
[android-ktx]: https://github.com/android/android-ktx
[anko]: https://github.com/Kotlin/anko
[kotlinx.coroutines]: https://github.com/Kotlin/kotlinx.coroutines
[releases]: https://github.com/hendraanggrian/ktfx/releases
[jcenter]: https://bintray.com/hendraanggrian/ktfx
[demo_layouts]: /art/demo_layouts.png
