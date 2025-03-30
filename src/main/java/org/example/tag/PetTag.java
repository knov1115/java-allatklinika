package org.example.tag;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import org.example.model.Pet;
import org.example.service.PetService;

import java.io.IOException;

public class PetTag extends SimpleTagSupport {


    private Pet pet;
    private PetService petService = new PetService();

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.write(String.valueOf(petService.getGlobalIdentifier(pet)));
    }
}
