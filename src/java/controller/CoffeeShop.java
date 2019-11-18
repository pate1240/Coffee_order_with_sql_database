/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import BusinessModel.CoffeePOJO;
import dataaccess.OrderData;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohit
 */
public class CoffeeShop extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            //get input from request
            String coffees = request.getParameter("coffees");
            String size = request.getParameter("size");
            String creams = request.getParameter("creams");
            String sugars = request.getParameter("sugars");
            
            CoffeePOJO c = new CoffeePOJO(coffees, size, creams, sugars);
            
            int price = c.price();
            
            
            
            String coffe = c.getCoffees();
            String Size = c.getSize();
            int priceC =c.price();
            String priceCS = Integer.toString(priceC);
            String creamss = c.getCreams();
            String sug = c.getSugar();
            
            
            //process the input data
            
            // response
            response.setContentType("text/html;charset=UTF-8");
            
            //add response-data to the request
            request.setAttribute("cf" , coffe);
            request.setAttribute("si" , Size);
            request.setAttribute("priceSize", priceCS );
            request.setAttribute("cr" , creamss);
            request.setAttribute("su" , sug);
            
            OrderData order=new OrderData();
            order.addToDatabase(coffe, Size, creamss, sug, priceC);
            
            RequestDispatcher view = request.getRequestDispatcher("response.jsp");
            view.forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CoffeeShop.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CoffeeShop.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

