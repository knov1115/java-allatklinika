package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.repository.PetRepository;
import org.example.service.PetService;

import java.io.IOException;

public class PetListServlet extends HttpServlet {

    private static final PetRepository petRepository = PetRepository.getInstance();
    private PetService petService = new PetService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("petList", petService.findAll());
        request.getRequestDispatcher("petList.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        
        if ("delete".equals(action)) {
            String petIdStr = request.getParameter("petId");
            if (petIdStr != null && !petIdStr.isEmpty()) {
                try {
                    Long petId = Long.parseLong(petIdStr);
                    petService.deletePet(petId);
                } catch (NumberFormatException e) {
                    // Hibás ID formátum esetén - nem csinálunk semmit
                    e.printStackTrace();
                }
            }
        }
        
        // Törlés után frissítjük a listát és visszairányítunk
        response.sendRedirect(request.getContextPath() + "/petList");
    }
}
