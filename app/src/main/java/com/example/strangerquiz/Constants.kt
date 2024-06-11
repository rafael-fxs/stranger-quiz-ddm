package com.example.strangerquiz

import com.example.strangerquiz.model.Option
import com.example.strangerquiz.model.Question

object Constants {
    fun getQuestion() : ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val optionsQuestion1 = ArrayList<Option>()
        optionsQuestion1.add(Option("Dungeons & Dragons", true))
        optionsQuestion1.add(Option("Cluedo", false))
        optionsQuestion1.add(Option("Toca do Dragão", false))
        optionsQuestion1.add(Option("Risk", false))
        questionsList.add(Question(1,"Qual jogo de tabuleiro Will, Mike, Dustin e Lucas jogam na primeira temporada?", R.drawable.tabuleiro, optionsQuestion1))


        val optionsQuestion2 = ArrayList<Option>()
        optionsQuestion2.add(Option("Scoops", false))
        optionsQuestion2.add(Option("Mr Moos Ice Cream Parlour", false))
        optionsQuestion2.add(Option("Scoops Ahoy", true))
        optionsQuestion2.add(Option("The NiceCream Shop", false))
        questionsList.add(Question(2,"Qual é o nome da sorveteria onde Steve e Robin trabalham?", R.drawable.sorveteria, optionsQuestion2))

        val optionsQuestion3 = ArrayList<Option>()
        optionsQuestion3.add(Option("Gawkins", false))
        optionsQuestion3.add(Option("Lawkins", false))
        optionsQuestion3.add(Option("Hawkins", true))
        optionsQuestion3.add(Option("Dawkins", false))
        questionsList.add(Question(3,"Qual é o nome da cidade onde todos moram?", R.drawable.hawkins, optionsQuestion3))

        val optionsQuestion4 = ArrayList<Option>()
        optionsQuestion4.add(Option("Will", false))
        optionsQuestion4.add(Option("Lucas", false))
        optionsQuestion4.add(Option("Max", false))
        optionsQuestion4.add(Option("Eleven", true))
        questionsList.add(Question(4,"Qual personagem sempre diz \"Amigos não mentem?\"", R.drawable.friends, optionsQuestion4))

        val optionsQuestion5 = ArrayList<Option>()
        optionsQuestion5.add(Option("\"Valerie\" da Amy Winehouse", false))
        optionsQuestion5.add(Option("\"Should I Stay or Should I Go?\" do The Clash", true))
        optionsQuestion5.add(Option("\"Jump\" de Van Halen", false))
        optionsQuestion5.add(Option("\"Heroes\" do Peter Gabriel", false))
        questionsList.add(Question(5,"Qual música faz Jonathan lembrar de Will?", R.drawable.shouldistay, optionsQuestion5))

        val optionsQuestion6 = ArrayList<Option>()
        optionsQuestion6.add(Option("\"Bem aqui\" e \"Corra\"", true))
        optionsQuestion6.add(Option("\"Estou aqui\" e \"Eu te amo\"", false))
        optionsQuestion6.add(Option("\"Vá embora\" e \"Saia daqui\"", false))
        optionsQuestion6.add(Option("\"Saia daqui\" e \"Corra\"", false))
        questionsList.add(Question(6,"Qual mensagem a Joyce vê nas luzes de natal?", R.drawable.joycelights, optionsQuestion6))

        val optionsQuestion7 = ArrayList<Option>()
        optionsQuestion7.add(Option("Waffles", true))
        optionsQuestion7.add(Option("Bagels", false))
        optionsQuestion7.add(Option("Panquecas", false))
        optionsQuestion7.add(Option("Sorvete", false))
        questionsList.add(Question(7,"Qual é a comida favorita da Eleven?", R.drawable.favoritefood, optionsQuestion7))
        return questionsList
    }
}