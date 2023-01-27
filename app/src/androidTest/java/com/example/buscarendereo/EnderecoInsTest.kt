package com.example.buscarendereo

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.example.buscarendereo.di.apiModules
import com.example.buscarendereo.di.domainModule
import com.example.buscarendereo.di.viewModelModules
import com.example.buscarendereo.presentation.MainActivity
import com.example.buscarendereo.presentation.cpfform.CpfFormFragment
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTestRule
import kotlin.coroutines.coroutineContext

@RunWith(AndroidJUnit4::class)
class EnderecoInsTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUp(){
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @After
    fun tearDown(){
        stopKoin()
        scenario.close()
    }


    @Test
    fun givenCPF_whenAcess_shouldGoToEnderetoAndReturnTrue(){

        val cpf = "29161758"

        enderecoAct{
            typeCPF(cpf)
            cpfClick()
        }

        //TODO tem uma forma melhor de se resolver isso
        Thread.sleep(3000)

        enderecoAssert{
            assertEnderecoHasAccepted()
        }
    }


}