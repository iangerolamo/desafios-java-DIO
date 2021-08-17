import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class UniformesDeFinalDeAno {
    private String nome;
    private String tamanhoUniforme;
    private String corUniforme;

    public UniformesDeFinalDeAno(String nome, String tamanhoUniforme, String corUniforme) {
        this.nome = nome;
        this.tamanhoUniforme = tamanhoUniforme;
        this.corUniforme = corUniforme;
    }

    public UniformesDeFinalDeAno() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTamanhoUniforme() {
        return tamanhoUniforme;
    }

    public void setTamanhoUniforme(String tamanhoUniforme) {
        this.tamanhoUniforme = tamanhoUniforme;
    }

    public String getCorUniforme() {
        return corUniforme;
    }

    public void setCorUniforme(String corUniforme) {
        this.corUniforme = corUniforme;
    }

    public void mostrarInformacoesDosEstudantes() {
        System.out.println(corUniforme + " " + tamanhoUniforme + " " + nome);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        ArrayList<UniformesDeFinalDeAno> uniformesDeFinalDeAno = new ArrayList<>(N);
        String nome, detalhesUniforme, corUniforme, tamanhoUniforme;

        for (int i = 0; i < N; i++) {
            nome = scanner.nextLine();
            detalhesUniforme = scanner.nextLine();
            corUniforme = detalhesUniforme.split(" ")[0];
            tamanhoUniforme = detalhesUniforme.split(" ")[1];
            uniformesDeFinalDeAno.add(new UniformesDeFinalDeAno(nome, tamanhoUniforme, corUniforme));
        }
        scanner.close();
        uniformesDeFinalDeAno.sort(new ComparadorDeUniformes());

        for (var item : uniformesDeFinalDeAno) {
            item.mostrarInformacoesDosEstudantes();
        }
    }

    static class ComparadorDeUniformes implements Comparator<UniformesDeFinalDeAno> {
        @Override
        public int compare(UniformesDeFinalDeAno estudante0, UniformesDeFinalDeAno estudante1){
            int res = estudante0.corUniforme.compareTo(estudante1.corUniforme);

            if (res == 0) {
                res = estudante0.tamanhoUniforme.compareTo(estudante1.tamanhoUniforme);

                if (res == 0) {
                    res = estudante0.nome.compareTo(estudante1.nome);
                } else {
                    res = -res;
                }
            }
            return res;
        }
    }
}
