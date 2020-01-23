package pageObjects;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class JSONRead {
 
    public static void main(String[] args) {
        JSONObject jsonObject;
        //Cria o parse de tratamento
        JSONParser parser = new JSONParser();
        //Variaveis que irao armazenar os dados do arquivo JSON
        String nome;
        String sobrenome;
        String email;
 
        try {
            //Salva no objeto JSONObject o que o parse tratou do arquivo
            jsonObject = (JSONObject) parser.parse(new FileReader(
                    "saida.json"));
             
            //Salva nas variaveis os dados retirados do arquivo
            nome = (String) jsonObject.get("firstName");
            sobrenome = (String) jsonObject.get("LastName");
            email = (String) jsonObject.get("email");
 
            System.out.printf(
                    "Nome: %s\nSobrenome: %s\nEmail: %s\n",
                    nome, sobrenome, email);
        } 
        //Trata as exceptions que podem ser lançadas no decorrer do processo
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
}