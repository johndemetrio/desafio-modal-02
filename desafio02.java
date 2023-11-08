import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
public class desafio02 {

    public static void main(String[] args) {
        String linha, nome, email, dataNascimento; 
        List<String> listaAniversariantes = new ArrayList<>();
        int mesAtual = Calendar.getInstance().get(Calendar.MONTH) + 1; // Mês atual

        try (BufferedReader br = new BufferedReader(new FileReader("consultores.txt"))) {
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split("\\|");
                nome = dados[0].trim();
                email = dados[1].trim();
                dataNascimento = dados[2].trim();
                int mesNascimento = Integer.parseInt(dataNascimento.split("/")[1]);
                if (mesNascimento == mesAtual) {
                    listaAniversariantes.add(nome + " | " + email + " | " + dataNascimento);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fw = new FileWriter("aniversariantes.txt")) {
            for (String aniversariante : listaAniversariantes) {
                fw.write(aniversariante + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
