package org.wikipedia.homeworks.homework22

import org.wikipedia.homeworks.homework07.exploreScreen.DateItem
import org.wikipedia.homeworks.homework07.exploreScreen.FeaturedArticleItem
import org.wikipedia.homeworks.homework07.exploreScreen.InTheNewsItem
import org.wikipedia.homeworks.homework07.exploreScreen.SearchCardViewItem
import org.wikipedia.homeworks.homework07.exploreScreen.topRead.TopReadBlockInnerItem
import org.wikipedia.homeworks.homework20.ExploreScreen

fun ExploreScreen.topReadItem(index: Int,
                                      targetId: Int,
                                      limiter: Int,
                                      blockNmae: String,
                                      function: TopReadBlockInnerItem.() -> Unit): Unit {
    return items.invokeById<TopReadBlockInnerItem>(
        targetId = targetId,
        index = index,
        function = function,
        blockName = blockNmae,
        limiter = limiter
    )
}

fun ExploreScreen.searchCardViewItem(targetId: Int,
                                     limiter: Int,
                                     blockNmae: String,
                                     function: SearchCardViewItem.() -> Unit): Unit {
    return items.invokeById<SearchCardViewItem>(
        targetId = targetId,
        index = 0,
        function = function,
        blockName = blockNmae,
        limiter = limiter
    )
}

fun ExploreScreen.featuredArticleItem(index: Int,
                                     targetId: Int,
                                     limiter: Int,
                                     blockNmae: String,
                                     function: FeaturedArticleItem.() -> Unit): Unit {
    return items.invokeById<FeaturedArticleItem>(
        targetId = targetId,
        index = index,
        function = function,
        blockName = blockNmae,
        limiter = limiter
    )
}

fun ExploreScreen.inTheNewsItem(index: Int,
                                     targetId: Int,
                                     limiter: Int,
                                     blockNmae: String,
                                     function: InTheNewsItem.() -> Unit): Unit {
    return items.invokeById<InTheNewsItem>(
        targetId = targetId,
        index = index,
        function = function,
        blockName = blockNmae,
        limiter = limiter
    )
}

fun ExploreScreen.dateItem(index: Int,
                                     targetId: Int,
                                     limiter: Int,
                                     blockNmae: String,
                                     function: DateItem.() -> Unit): Unit {
    return items.invokeById<DateItem>(
        targetId = targetId,
        index = index,
        function = function,
        blockName = blockNmae,
        limiter = limiter
    )
}


fun ExploreScreen.searchCardViewItem(index: Int,
                                     targetId: Int,
                                     limiter: Int,
                                     blockNmae: String,
                                 ): SearchCardViewItem {
    return items.findByById<SearchCardViewItem>(
        targetId = targetId,
        index = index,
        blockName = blockNmae,
        limiter = limiter
    )
}

fun ExploreScreen.featuredArticleItem(index: Int,
                                      targetId: Int,
                                      limiter: Int,
                                      blockNmae: String): FeaturedArticleItem {
    return this.items.findByById<FeaturedArticleItem>(
        targetId = targetId,
        index = index,
        blockName = blockNmae,
        limiter = limiter
    )
}

fun ExploreScreen.inTheNewsItem(index: Int,
                                targetId: Int,
                                limiter: Int,
                                blockNmae: String): InTheNewsItem {
    return items.findByById<InTheNewsItem>(
        targetId = targetId,
        index = index,
        blockName = blockNmae,
        limiter = limiter
    )
}

fun ExploreScreen.dateItem(index: Int,
                           targetId: Int,
                           limiter: Int,
                           blockNmae: String): DateItem {
    return items.findByById<DateItem>(
        targetId = targetId,
        index = index,
        blockName = blockNmae,
        limiter = limiter
    )
}

