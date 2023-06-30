package mysql.jdbc2;

import java.util.List;
import java.util.Scanner;

public class QueriesExecution {
    public static void main(String[] args) {
        AlunoDAO alunoDAO = new AlunoDAO();
        System.out.println("Escolhe o que quer fazer" +
                "\n 1 - Consulta" +
                "\n 2 - Adicionar novo Aluno" +
                "\n 3 - Deletar Aluno" +
                "\n 4 - Atualizar Aluno");
        Scanner scan = new Scanner(System.in);
        int op1 = scan.nextInt();

        if(op1 == 1){
            System.out.println("1 - mostrar todos os Alunos ");
            System.out.println("2 - Mostrar aluno pelo id ");
            int op2 = scan.nextInt();

            if (op2 == 1){
                List<Aluno> alunos = alunoDAO.list();

                alunos.forEach(System.out::println);
            } else if (op2 == 2) {
                System.out.println("digite o id do aluno que você deseja");
                int idAluno = scan.nextInt();
                Aluno alunoParaConsulta = alunoDAO.getById(idAluno);
                System.out.println(alunoParaConsulta);
            }
            }
        if (op1 == 2) {
            System.out.println("Digite o nome do novo aluno");
            String nome = scan.next();
            System.out.println("Digite sua idade");
            int idade = scan.nextInt();
            System.out.println("Digite seu estado");
            String estado = scan.next();
            alunoDAO.create(new Aluno(
                    nome, idade, estado
            ));
        }
        if (op1 == 3) {
            int idAluno = scan.nextInt();
            alunoDAO.delete(idAluno);
        }
        if (op1 == 4) {
            System.out.println("Digite o id do aluno que você deseja atualizar");
            int idAluno = scan.nextInt();
            System.out.println("Digite o nome");
            String nome = scan.next();
            System.out.println("Digite sua idade");
            int idade = scan.nextInt();
            System.out.println("Digite seu estado");
            String estado = scan.next();
            alunoDAO.update(new Aluno(
                    idAluno, nome, idade, estado
            ));
        }
        }


//--------------------- 1 Consulta -------------------------------------
//        List<Aluno> alunos = alunoDAO.list();
//
//        alunos.forEach(System.out::println);
//--------------------- Consulta com filtro -----------------------------

//        Aluno alunoParaConsulta = alunoDAO.getById(2);
//        System.out.println(alunoParaConsulta);
    }

