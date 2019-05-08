package com.gl.kev.data.model

class ThemeWrapper(
    val theme: Theme
) {

    fun getBackgroundColor(): String? {
        return theme.colors.backgroundColor
    }

    fun getBackgroundColor2(): String? {
        return theme.colors.backgroundColor2
    }

    fun getTextColor(): String? {
        return theme.colors.textColor
    }

    fun getTintColor(): String? {
        return theme.colors.tintColor
    }

    data class Theme(
        val colors: Colors,
        val fonts: Fonts
    )

    data class Fonts(
        val body: Body,
        val callout: Callout,
        val caption1: Caption1,
        val caption2: Caption2,
        val footnote: Footnote,
        val headline: Headline,
        val largeTitle: LargeTitle,
        val subheadline: Subheadline,
        val title1: Title1,
        val title2: Title2,
        val title3: Title3
    )

    data class Title1(
        val name: String,
        val size: Double
    )

    data class Footnote(
        val name: String,
        val size: Double
    )

    data class LargeTitle(
        val name: String,
        val size: Double
    )

    data class Headline(
        val name: String,
        val size: Double
    )

    data class Body(
        val name: String,
        val size: Double
    )

    data class Subheadline(
        val name: String,
        val size: Double
    )

    data class Callout(
        val name: String,
        val size: Double
    )

    data class Title2(
        val name: String,
        val size: Double
    )

    data class Caption2(
        val name: String,
        val size: Double
    )

    data class Title3(
        val name: String,
        val size: Double
    )

    data class Caption1(
        val name: String,
        val size: Double
    )

    data class Colors(
        val backgroundColor: String,
        val backgroundColor2: String,
        val textColor: String,
        val tintColor: String
    )
}