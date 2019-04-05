package sources;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import sources.PhraseOMatic;

import javax.servlet.ServletException;

@WebServlet("/phrase")
public class PhraseServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws IOException, ServletException {
            try (PrintWriter writer = response.getWriter()) {
                writer.println(new StringBuilder()
                    .append("<html><body>")
                    .append("<p>" + PhraseOMatic.makePhrase() + "</p>")
                    .append("<h1><a href='/phrase'>Get Phrase</a></h1>")
                    .append("</body></html>")
                    .toString());
                writer.flush();
            }
        }

}