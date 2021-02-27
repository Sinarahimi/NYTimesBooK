package ir.sinarahimi.presentation

import android.view.View
import com.google.android.material.snackbar.Snackbar

/**
 * Created by Sina Rahimi on 2/23/2021.
 */

fun View.showSnackbar(message: String) =
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).show()