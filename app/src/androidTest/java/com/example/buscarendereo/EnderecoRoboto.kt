package com.example.buscarendereo

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matchers.not

class enderecoAct(action: enderecoAct.() -> Unit) {
    init {
        action.invoke(this)
    }

    fun typeCPF(cpf: String){
        Espresso.onView(ViewMatchers.withId(R.id.cpfCampo)).perform(ViewActions.typeText(cpf))
    }

    fun cpfClick(){
        Espresso.onView(ViewMatchers.withId(R.id.pesquisarbutton)).perform(ViewActions.click())
    }

}

class enderecoAssert(action: enderecoAssert.() -> Unit){
    init {
        action.invoke(this)
    }

    fun assertEnderecoHasAccepted(){
        Espresso.onView(ViewMatchers.withId(R.id.logradouroCampo))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun assertEnderecoHasNegated(){
        Espresso.onView(ViewMatchers.withId(R.id.logradouroCampo))
            .check(doesNotExist())
    }

    fun assertEnderecoTextHasAccepted(rua: String){
        Espresso.onView(allOf(ViewMatchers.withId(R.id.logradouroCampo), ViewMatchers.withText(rua)))
    }

    fun assertEnderecoTextHasNegated(rua: String){
        Espresso.onView(allOf(ViewMatchers.withId(R.id.logradouroCampo), not(ViewMatchers.withText(rua))))
    }

}