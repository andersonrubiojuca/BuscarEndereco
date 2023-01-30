package com.example.buscarendereo

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.buscarendereo.presentation.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.stopKoin

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
    fun givenCPF_whenAccess_shouldGoToEnderecoAndReturnTrue(){

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

    @Test
    fun givenCPF_whenAccess_shouldGoToEnderecoAndReturnFalse(){

        val cpf = "87954317"

        enderecoAct{
            typeCPF(cpf)
            cpfClick()
        }

        //TODO tem uma forma melhor de se resolver isso
        Thread.sleep(3000)

        enderecoAssert{
            assertEnderecoHasNegated()
        }
    }

    @Test
    fun givenCPF_whenAccess_shouldGoToEnderecoTextAndReturnTrue(){

        val cpf = "01504000"
        val rua = "Rua Vergueiro"

        enderecoAct{
            typeCPF(cpf)
            cpfClick()
        }

        //TODO tem uma forma melhor de se resolver isso
        Thread.sleep(3000)

        enderecoAssert{
            assertEnderecoTextHasAccepted(rua)
        }
    }

    @Test
    fun givenCPF_whenAccess_shouldGoToEnderecoTextAndReturnFalse(){

        val cpf = "01504000"
        val rua = "Rua Vergueiroo"

        enderecoAct{
            typeCPF(cpf)
            cpfClick()
        }

        //TODO tem uma forma melhor de se resolver isso
        Thread.sleep(3000)

        enderecoAssert{
            assertEnderecoTextHasNegated(rua)
        }
    }


}