/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author DEFCON
 */
public class search extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
 
            String product_name = request.getParameter("product_name");
 
            try {
                Class.forName("org.hsqldb.jdbc.JDBCDriver");
                Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb");
 
                Statement st = conn.createStatement();
                String sql = "SELECT product_name, products FROM products WHERE product_name='" + product_name + "'";
                System.out.println(sql);
                ResultSet rs = st.executeQuery(sql);
 
                while (rs.next()) {
                    String prod_name = rs.getString("product_name");
                    String prod_price = rs.getString("product_price");
                    out.println(prod_name);
                    out.println(prod_price);
                    out.println("<br/>");
                }
                conn.close();
 
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        
        }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */

}
