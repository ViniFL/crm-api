package com.vinicius.salescontrol.dto;

import com.vinicius.salescontrol.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClientDTO {

    private Long id;

    @Size(min = 3, max = 80, message = "Nome precisa ter de 3 a 80 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;

    @Size(min = 3, max = 80, message = "Email precisa ter de 3 a 80 caracteres")
    @NotBlank(message = "Cliente precisa ter email")
    private String email;

    @Size(max = 11, message = "O número deve ter 11 caracteres")
    @NotBlank(message = "Cliente precisa ter número de contato")
    private String cellphone;

    public ClientDTO() {
    }

    public ClientDTO(Long id, String name, String email, String cellphone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cellphone = cellphone;
    }

    public ClientDTO(Client entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        cellphone = entity.getCellphone();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCellphone() {
        return cellphone;
    }
}
