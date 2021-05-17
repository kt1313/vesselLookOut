
package pl.javastart.lookout;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.text.Document;
import java.io.IOException;
import java.util.List;

@WebServlet("/getVesselDetailsController")
public class GetVesselDetailsController extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //tu należy otrzymac szczegoly vslNameAndIMO po wcisnieciu Show Details

        System.out.println(request.getParameter("vslChosen"));
        createVesselDetails(getVslNameAndIMO(request));
        response.sendRedirect(request.getContextPath());
    }

    private String getVslNameAndIMO(HttpServletRequest request) {
        String vslNameAndIMO = request.getParameter("vslChosen");
        return vslNameAndIMO;
    }

    private List<String> createVesselDetails(String vslChosen) throws IOException {
        ServletContext context = getServletContext();
        List<String> fullVslDescription = (List<String>) context.getAttribute("fullVslDescription");
        fullVslDescription = GetDetails.getVslDetails(vslChosen);
        context.setAttribute("fullVslDescription", fullVslDescription);
        return fullVslDescription;
    }
}