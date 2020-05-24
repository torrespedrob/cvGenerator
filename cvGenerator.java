import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;


public class cvGenerator {
	public static void main(String[] args) {

		try {
			String input = "";
			FileWriter graba = null;
			PrintWriter escribe = null;

			BufferedReader br1 = new BufferedReader(new FileReader("curriculum.txt"));
			BufferedReader br2 = new BufferedReader(new FileReader("curriculum.txt"));

			graba = new FileWriter("generatedCV.html");
			escribe = new PrintWriter(graba);
			input = br1.readLine();
      
      // Comienzo de HTML
			escribe.println("<html>");
			escribe.println("<head><meta charset=\"UTF-8\"><title>" + (input + "\n") + "</title></head>");

			escribe.println("<body>");
			input = br2.readLine();

			escribe.println("<h1><font color=\"darkblue\"><font family=\"Arial\">" + input + "</font></font></h1>");
			escribe.println("<p>");

      // Contacto
			br2.readLine();
			input = br2.readLine();
			escribe.println("Correo de contacto: " + input + "<br><br>");
			br2.readLine();

			input = br2.readLine();
			escribe.println("Teléfono de contacto: " + input + "<br><br>");
			br2.readLine();

			// Formación
			escribe.println("<h2><font color=\"green\"> Formación </font></h2>");

			do {
				input = br2.readLine();
				if (input != null) {
					escribe.println(input + "<br>");
					if (input.isEmpty()) {
						break;
					}
				}
			} while (input != null);

			// Experiencia Laboral
			escribe.println("<h2> Experiencia Laboral </h2>");

			do {
				input = br2.readLine();
				if (input != null) {
					escribe.println(input + "<br>");
					if (input.isEmpty()) {
						break;
					}

				}

			} while (input != null);

			escribe.println("</p>");
			escribe.println("</body>");
			escribe.println("</html>");
      //Fin de HTML

			br1.close();
			br2.close();
			escribe.close();
			graba.close();
			System.out.println("Tu curriculum se ha generado correctamente");

		} catch (FileNotFoundException fnf) {
			System.out.println("Falta el archivo curriculum.txt");

		} catch (IOException ioe) {
			System.out.println("Se ha producido un error de escritura o lectura");

		}
	}
}
