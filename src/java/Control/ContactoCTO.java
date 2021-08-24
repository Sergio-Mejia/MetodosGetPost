/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.dao.ContactoDAO;
import Modelo.dto.ContactoDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daser
 */
public class ContactoCTO extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Action = request.getParameter("Action");
        ContactoDAO dao = new ContactoDAO();

        switch (Action) {
            case "Agregar": {
                //1
                String nombre = request.getParameter("txtNombre");
                String correo = request.getParameter("txtEmail");
                String asunto = request.getParameter("txtAsunto");
                String mensaje = request.getParameter("txtMensaje");

                //2
                ContactoDTO dto = new ContactoDTO(nombre, correo, asunto, mensaje);

                //3
                boolean res = dao.Crear(dto);

                if (res) {
                    PrintWriter out = response.getWriter();
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Respuesta</title>");
                    out.println("</head>");
                    out.println("<body><h1>Su comentario fue enviado exitosamente</h1>"
                            + "<a href='index.jsp'>Volver</a></body>");
                    out.println("</html>");
                }
                break;
            }

            case "Listar": {
                List<ContactoDTO> List = dao.readAll();
                
                //request.getRequestDispatcher("URL").forward(request, response); Redireccionar a otra pagina

                PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Respuesta</title>");
                out.println("<style>"
                        + "table, th, td {"
                        + "  border: 1px solid black;"
                        + "  border-collapse: collapse;"
                        + " text-align : center;"
                        + "}"
                        + " th, td {"
                        + "padding: 15px;"
                        + "}"
                        + "</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<table>");
                out.println("<caption>Lista de Mensajes</caption>");
                out.println("<th>Nombre</th>");
                out.println("<th>Email</th>");
                out.println("<th>Asunto</th>");
                out.println("<th>Mensaje</th>");
                for (ContactoDTO i : List) {
                    out.println("<tr>");
                    out.println("<td>" + i.getNombre());
                    out.println("</td>");
                    out.println("<td>" + i.getCorreo());
                    out.println("</td>");
                    out.println("<td>" + i.getAsunto());
                    out.println("</td>");
                    out.println("<td>" + i.getDescripcion());
                    out.println("</td>");
                    out.println("</tr>");

                }
                out.println("</table>");
                
                out.println("</body>");
                out.println("</html>");

                System.out.println("Entró");
                break;
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        /*
        String nombre = request.getParameter("txtNombre");
        String correo = request.getParameter("txtEmail");
        String asunto = request.getParameter("txtAsunto");
        String mensaje = request.getParameter("txtMensaje");
        
        //2
        ContactoDTO dto = new ContactoDTO(nombre, correo, asunto, mensaje);
        
        //3
        ContactoDAO dao = new ContactoDAO();
        dao.Crear(dto);
        
        List<ContactoDTO> List = dao.readAll();
        
        for(int i=0; i<List.size();i++){
            System.out.println(List.get(i));
        }
         */
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
