package com.shashifreeze.mvvm_di_templete.apputils.extensions

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.shashifreeze.mvvm_di_templete.R

/**
 *@author = Shashi
 *@date = 25/07/21
 *@description = This File contains Context extension functions
 */


/**
 * Shows alert dialog
 */
fun Context.showAlertDialog(
    title: String? = null,
    message: String,
    posBtnText:String? = null,
    negBtnText:String? = null,
    showNegBtn:Boolean = true,
    callback: () -> Unit
) {
    AlertDialog.Builder(this).also {
        it.setTitle(title ?: getString(R.string.alert))
        it.setMessage(message)
        it.setPositiveButton(posBtnText?:getString(R.string.yes)) { _, _ ->
            callback()
        }
        if (showNegBtn) {
            it.setNegativeButton(negBtnText?:getString(R.string.no)) { dialog, _ ->
                dialog.dismiss()
            }
        }
    }.create().show()
}

/**shows toast to the context
 * @param: text: String
 * @return: Unit
 * @author: Shashi
 */

fun Context.showToast(text: String?) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}
