package com.senai.controle_notas

//pacote para as funções limpas do código, ou seja elas podem ser ultilizadas em outros projetos

 fun situacaoAluno(media: Int): String {
    if (media >= 5) {
        return "Aprovado"
    } else {
        return "Reprovado"
    }
}

//o modificador vararg para que possamos fazer dessa variável um array
fun calcularMedia(vararg notas: Int): Int {
    var soma = 0
    for (nota in notas) {
        soma = soma + nota
    }

    return soma / notas.size
}