package Modelo;

/**
 * Created by Aluno on 20/11/2017.
 */

public class Organize {
    private int id;
    private String Titulo;
    private String Texto;
    private String Data;
    private String Hora;

    public Organize(int id, String titulo, String texto, String data) {
        this.setId(id);
        this.setTitulo(titulo);
        this.setTexto(texto);
        this.setData(data);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String texto) {
        Texto = texto;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

}
