package com.example.FatecPi.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ponto")
public class PontoImagem {
    private String imagemPonto;
    private byte[] bytes;

    public PontoImagem(){}

    public PontoImagem(String imagemPonto, byte[] bytes){
        this.imagemPonto = imagemPonto;
        this.bytes = bytes;
    }

    public String getImagemPonto() {
        return imagemPonto;
    }

    public void setImagemPonto(String imagemPonto) {
        this.imagemPonto = imagemPonto;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
