/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jmoya
 */
package controladores;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Rol;
import service.RolesService;


@WebServlet(name = "RolControllers", urlPatterns = {"/rol"})
public class RolControllers extends HttpServlet {


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
    protected void doPost(HttpServletRequest rs, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = rs.getParameter("name"); //captura los campos de la bd
        int priority = Integer.parseInt(rs.getParameter("priority"));//parseInt formatea el string a un numero
  
        Rol rol = new Rol(0, name, priority); //captura lo que se guarda en la vista
        
        RolesService  rolesService = new RolesService();//instanciar servicios
        int resultado = rolesService.creaRol(rol);
        
        if(resultado == 0){
            System.out.println("no inserto");
        }else{
           System.out.println("inserto");
                
                }
                   System.out.println("inserto");

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
