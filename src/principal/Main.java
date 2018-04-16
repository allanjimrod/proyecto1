package principal;


import com.ucenfotec.ac.cr.proyecto1.capalogica.ClienteLogica;
import com.ucenfotec.ac.cr.proyecto1.capalogica.ContactoLogica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main  {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;


    public static void main(String[] args) throws IOException {
        ClienteLogica micliente=new ClienteLogica();
        System.out.println(micliente.getAllClientes().toString());
    }
}
