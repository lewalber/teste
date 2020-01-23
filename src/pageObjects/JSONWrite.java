package pageObjects;

	import java.io.FileWriter;
	import java.io.IOException;
	 
	import org.json.simple.JSONObject;
	 
	public class JSONWrite {
	 
	    @SuppressWarnings("unchecked")
	    public static void main(String[] args) {
	         
	        JSONObject jsonObject = new JSONObject();
	        FileWriter writeFile = null;
	         
	        jsonObject.put("firstName", "Allan");
	        jsonObject.put("lastName", "Romanato");
	        jsonObject.put("email", "Brasil");

	         
	        try{
	            writeFile = new FileWriter("saida.json");
	            writeFile.write(jsonObject.toJSONString());
	            writeFile.close();
	        }
	        catch(IOException e){
	            e.printStackTrace();
	        }
	         
	        System.out.println(jsonObject);
	        
//	        for(String lj: listaJson) {
//	        JSONObject jsonObject;
//	        JSONParser parser = new JSONParser();
//	        jsonObject = (JSONObject) parser.parse(lj);
//	        JSONArray lstJson = (JSONArray) jsonObject.get("valores");
//	        Iterator i = lstJson.iterator();

//	        while (i.hasNext()) {
//	        CampoOperador cop = new CampoOperador();
//	        JSONObject jsnObj = (JSONObject) i.next();

//	        String cmp = (String) jsnObj.get("campo");
//	        String vlr = (String) jsnObj.get("valor");
//	        String opr = (String) jsnObj.get("operador");
//	        String idx = (String) jsnObj.get("index");

//	        cop.setValor(vlr);
//	        cop.setCampo(cmp);
//	        cop.setIndex(idx);
//	        cop.setOperador(opr);

//	        listCampoOperador.add(cop);
	  //        }
//	      /  }
      }
	 
	}
	
