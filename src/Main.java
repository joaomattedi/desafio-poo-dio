import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);
        cursos.add(curso1);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);
        cursos.add(curso2);

        List<Bootcamp> bootcamps = new ArrayList<>();
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamps.add(bootcamp);

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String devName = scan.next();

        Dev dev = new Dev();
        dev.setNome(devName);

        System.out.println("Olá " + devName + "! O que você deseja fazer hoje?");
        System.out.println("1. Se inscrever em um bootcamp");
        System.out.println("2. Se inscrever em um curso");
        System.out.println("Digite o número da opção que quer selecionar:");

        int opcao = scan.nextInt();

        switch (opcao){
            case 1:
                System.out.println("Selecione o bootcamp:");
                AtomicInteger index = new AtomicInteger(0);
                bootcamps.stream().forEach(bc -> {
                    int i = index.getAndIncrement();
                    System.out.println(i + ". " + bc.getNome());
                });
                break;
            case 2:
                System.out.println("Selecione o curso:");
                AtomicInteger ind = new AtomicInteger(0);
                cursos.stream().forEach(curso -> {
                    int i = ind.getAndIncrement();
                    System.out.println(i + ". " + curso.getTitulo());
                });
                break;
            default:
                System.out.println("Opção invalida!");
                throw new RuntimeException();
        }

        int opcaoRegistro = scan.nextInt();

        if (opcao == 1) {
            dev.inscreverBootcamp(bootcamps.get(opcaoRegistro));
        } else if (opcao == 2) {
            dev.inscreverCurso(cursos.get(opcaoRegistro));
        }

        System.out.println("Inscrição concluída!");
        System.out.println(dev.toString());
    }

}
