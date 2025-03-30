package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Pet;
import org.example.service.PetService;

import java.io.IOException;

public class AddPetServlet extends HttpServlet {

    private PetService petService = new PetService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("addPet.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        String action = req.getParameter("action");
        if ("save".equals(action)) {

            String name = req.getParameter("name");
            String chipCode = req.getParameter("chipCode");
            String address = req.getParameter("address");
            String species = req.getParameter("species");

            if (name != null && !name.isEmpty() && 
                chipCode != null && !chipCode.isEmpty() && 
                address != null && !address.isEmpty() && 
                species != null && !species.isEmpty()) {

                Pet newPet = new Pet(name, chipCode, address, species);

                petService.save(newPet);
            }

            resp.sendRedirect(req.getContextPath() + "/petList");
        }
    }
}
