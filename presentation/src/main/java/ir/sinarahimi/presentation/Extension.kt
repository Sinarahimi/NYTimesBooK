package ir.sinarahimi.presentation

import android.view.View
import android.widget.Toast.LENGTH_SHORT
import com.google.android.material.snackbar.Snackbar

/**
 * Created by Sina Rahimi on 2/23/2021.
 */

fun View.showSnackbar(message: String) =
    Snackbar.make(this, message, LENGTH_SHORT).show()