package eu;

import java.util.ArrayList;
import java.util.Scanner;

public class NewClass {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<Pessoa> pessoa = new ArrayList<>();
        Pessoa eu = new Pessoa();

        String nome;
        int idade;
        String ende;
        String opc = "";

        System.out.println("Você quer Gravar, Ler ou excluir (g, l, e) ?");
        opc = in.next();

        switch (opc) {
            case "g":

                System.out.println("Nome: ");
                nome = in.next();
                System.out.println("Idade: ");
                idade = in.nextInt();
                System.out.println("Endereço:");
                ende = in.next();

                Pessoa incluir = new Pessoa();

                incluir.setNome(nome);
                incluir.setIdade(idade);
                incluir.setEnde(ende);

                pessoa.add(incluir);
                break;
            case "l":
                for (int i = 0; i < pessoa.size(); i++) {

                }
                System.out.println("");
                break;
            case "e":
                int posi;
                System.out.println("Deseja excluir quem?");
                posi = in.nextInt();

                pessoa.remove(posi);
                break;
            default:
                System.out.println("Erro");
        }
    }
}
