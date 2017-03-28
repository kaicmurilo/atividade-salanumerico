package calculo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recebendo.RecebendoNumeros;

@WebServlet(urlPatterns="/usucalcula")
public class UsuarioCalculo extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private List<RecebendoNumeros> lista = new ArrayList<RecebendoNumeros>();
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			String num1 = req.getParameter("numero1");
			String num2 = req.getParameter("numero2");
			String operador = req.getParameter("operador");
			
			
			RecebendoNumeros rec = new RecebendoNumeros(operador, Integer.parseInt(num1),Integer.parseInt(num2));
			
			lista.add(rec);
			
	
			
			
		}
		
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			int resultado; 
			String json="[";
			for(int i=0;i<lista.size()-1;i++){
				
				json += "\n numero 1: "+lista.get(i).getNum1()+ "\n numero 2: "+lista.get(i).getNum2()+ "\n operador: "+lista.get(i).getOperador()+"\n";
				if(i<lista.size())
					json+= ",";
				if(lista.get(i).getOperador().equals("som")){
					resultado=lista.get(i).getNum1()+lista.get(i).getNum2();
					resp.getWriter().print("\n Resposta da requisição: \n {resultado: "+resultado+"}");
				}
				if(lista.get(i).getOperador().equals("sub")){
					resultado=lista.get(i).getNum1()-lista.get(i).getNum2();
					resp.getWriter().print("\n Resposta da requisição: \n {resultado: "+resultado+"}");
				}
				if(lista.get(i).getOperador().equals("mult")){
					resultado=lista.get(i).getNum1()*lista.get(i).getNum2();
					resp.getWriter().print("\n Resposta da requisição: \n {resultado: "+resultado+"}");
				}
				if(lista.get(i).getOperador().equals("div")){
					resultado=lista.get(i).getNum1()/lista.get(i).getNum2();
					resp.getWriter().print("\n Resposta da requisição: \n {resultado: "+resultado+"}");
					
				}
			}
			json +="]\n";
			
			resp.getWriter().print(json);
			
		}
		
			
}


