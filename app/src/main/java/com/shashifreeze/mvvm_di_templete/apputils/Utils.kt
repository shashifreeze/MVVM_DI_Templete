package com.shashifreeze.mvvm_di_templete.apputils

import android.view.Menu
import android.view.View
import android.widget.ProgressBar
import androidx.core.view.iterator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
@Author: Shashi
@Date: 16-03-2021
@Description: Contains all common functions and extension functions for this specific project*/

const val TAG = "UtilsTAG"

/**
 * Add divider to recyclerview
 * @param: (orientation :Int = LinearLayoutManager.VERTICAL)
 * @return: Unit
 * @author: Shashi
 * */
fun RecyclerView.addDivider() {

    if (layoutManager !is LinearLayoutManager)
        return
    addItemDecoration(
        DividerItemDecoration(
            context,
            (layoutManager as LinearLayoutManager).orientation
        )
    )
}

//shows and hide progressbar
fun ProgressBar.hide(b: Boolean) {

    if (b) {
        this.visibility = View.INVISIBLE
    } else {
        this.visibility = View.VISIBLE
    }
}

/**
 * shows and hides all the munu items
 */
fun Menu.showAllItems(mVisible:Boolean = false)
{
    for ( m in this)
    {
        m.isVisible = mVisible
    }
}






