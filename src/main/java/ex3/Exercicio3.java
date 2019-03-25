package ex3;

import ex3.entities.Aluno;
import ex3.entities.AlunoDAO;

import java.util.List;

public class Exercicio3 {

    public static void main(String[] args) {
        Aluno a = new Aluno(4,"Lucas", 70, 160, "lucas@email.com");
        //AlunoDAO.inserir(a);

        List<Aluno> alunos = AlunoDAO.litarTodos();

        alunos.forEach(aluno -> {
            System.out.println(aluno);
        });

//        alunos.forEach(System.out::println);

//        for(Aluno aluno : alunos){
//            System.out.println(aluno);
//        }
    }

}
