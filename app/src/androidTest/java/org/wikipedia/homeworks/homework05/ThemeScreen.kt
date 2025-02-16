package org.wikipedia.homeworks.homework05

import androidx.appcompat.widget.AppCompatImageView
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.progress.KProgressBar
import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import com.google.android.material.R as materialR

// 2. Открываем приложение, пропускаем онбординг,
// проваливаемся в любую статью, нажимаем на кнопку Theme в нижнем навбаре.
//3. Всплывает панель настроек темы.
// Здесь полно интересных элементов, которые мы можем описать.
//4. Для каждого значимого элемента создаём переменную
// и инициализируем её соответствующим объектом из набора типизированных элементов Kakao.
// Не забываем добавить матчер для поиска этого элемента.
//5. Если элемент совсем нетипичный, то используем тип KView.

// THEME BOTTOM MENU

// reading block
val themeSlideout = KView {
    withId(materialR.id.design_bottom_sheet)
}

val readingBlockTitle = KTextView {
    withId(R.id.textSettingsCategory)
}

val textSizePreview = KTextView {
    withId(R.id.text_size_percent)
}

val textSizeSelectionBar = KSeekBar {
    withId(R.id.text_size_seek_bar)
}

val textSizeDecreaseButton = KTextView {
    withId(R.id.buttonDecreaseTextSize)
}

val textSizeIncreaseButton = KTextView {
    withId(R.id.buttonIncreaseTextSize)
}

val fontChangeProgressBar = KProgressBar {
    withId(R.id.font_change_progress_bar)
}

val fontSelectButtonSansSerif = KButton {
    withId(R.id.button_font_family_sans_serif)
}

val fontSelectButtonSerif = KButton {
    withId(R.id.button_font_family_serif)
}

val readingFocusSwitch = KSwitch {
    withId(R.id.theme_chooser_reading_focus_mode_switch)
}

val readingFocusDescriptionText = KTextView {
    withId(R.id.theme_chooser_reading_focus_mode_description)
}

val readingFocusIcon = KImageView {
    withParent {
        withId(R.id.readingFocusModeContainer)
    }
    isInstanceOf(AppCompatImageView::class.java)
}

// theme block
val themeBlockTitle = KTextView {
    isDescendantOfA {
        withId(materialR.id.design_bottom_sheet)
    }
    withText(R.string.color_theme_select)
}

val buttonThemeLight = KButton {
    withId(R.id.button_theme_light)
}

val buttonThemeSepia = KButton {
    withId(R.id.button_theme_sepia)
}

val buttonThemeDark = KButton {
    withId(R.id.button_theme_dark)
}

val buttonThemeBlack = KButton {
    withId(R.id.button_theme_black)
}

val matchSystemThemeSwitch = KSwitch {
    withId(R.id.theme_chooser_match_system_theme_switch)
}

val imageDimmingInDarThemeSwitch = KSwitch {
    withId(R.id.theme_chooser_dark_mode_dim_images_switch)
}
