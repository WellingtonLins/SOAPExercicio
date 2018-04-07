/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.soapexercicio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wellington
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livro.consultarTodos", query = "SELECT a FROM Livro a"),
            @NamedQuery(name = "Livro.consultarPorId", query = "SELECT a FROM Livro a WHERE a.id = :id"),
            @NamedQuery(name = "Livro.consultarPorTitulo",query = "SELECT  a FROM Livro a WHERE a.titulo = :titulo")})
public class Livro implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String edicao;
    private String titulo;
    private String descricao;
    @ManyToMany
    private List<Autor> autores = new ArrayList<>();

    public Livro() {
    }

    public Livro(String edicao, String titulo, String descricao) {
        this.edicao = edicao;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void adicionarAutor(Autor autor) {
        this.autores.add(autor);
    }

    public void removerAutor(Autor autor) {
        this.autores.remove(autor);
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

}
