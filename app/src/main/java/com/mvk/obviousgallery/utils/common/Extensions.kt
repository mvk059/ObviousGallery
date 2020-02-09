/*
 * Created by Manpreet Kunnath on 29/1/2020 10:16
 * Copyright (c) 2020 . All rights reserved.
 */

package com.mvk.obviousgallery.utils.common

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import java.io.InputStream
import java.nio.charset.Charset

/**
 * Read input from a file
 *
 * @param charset InputStream
 * @return Read string
 */
fun InputStream.readInput(charset: Charset = Charsets.UTF_8): String {
    return this.bufferedReader(charset).use { it.readText() }
}

/**
 * Transacts to the fragment specified
 *
 * @param func Lambda
 */
inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

/**
 * Calls the inTransaction method and loads the fragment. Called from an Activity
 *
 * @param fragment Fragment to be added
 * @param container Place to be added
 */
fun  AppCompatActivity.addFragment(fragment: Fragment, container: Int){
    supportFragmentManager.inTransaction { addToBackStack(null).add(container, fragment) }
}

/**
 * Calls the inTransaction method and loads the fragment. Called from an Fragment
 *
 * @param fragment Fragment to be added
 * @param container Place to be added
 */
fun Fragment.addFragment(fragment: Fragment, container: Int){
    parentFragmentManager.inTransaction { addToBackStack(null).add(container, fragment) }
}

/**
 * Calls the inTransaction method and loads the fragment. Called from an Fragment
 *
 * @param fragment Fragment to be added
 * @param container Place to be added
 */
fun Fragment.replaceFragment(fragment: Fragment, container: Int){
    parentFragmentManager.inTransaction { addToBackStack(null).replace(container, fragment) }
}