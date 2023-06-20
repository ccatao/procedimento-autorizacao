package br.com.procedimentos.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table
public class Procedimento implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   private Integer procedimento;
   
   @Min(0)
   @Max(120)
   @NotNull(message="O campo IDADE é de preenchimento obrigatório")   
   private Integer idade;

   @NotNull(message="O campo SEXO é de preenchimento obrigatório")
   @Size(min = 1, max = 1)
   @Enumerated(EnumType.STRING)
   private Sexo sexo;

   @NotNull(message="O campo AUTORIZADO é de preenchimento obrigatório")   
   private Boolean autorizado;

   
   public Procedimento() {
	   
   }
   
   public Procedimento(Integer procedimento, Integer idade, String sexo, Boolean autorizado) {
	   this.procedimento = procedimento;
	   this.idade = idade;
	   this.sexo = Sexo.getSexoPorDescricao(sexo);
	   this.autorizado = autorizado;
   }
   
   public Integer getProcedimento() {
      return procedimento;
   }

   public void setProcedimento(Integer procedimento) {
      this.procedimento = procedimento;
   }

   public Sexo getSexo() {
      return sexo;
   }

   public void setSexo(Sexo sexo) {
      this.sexo = sexo;
   }

   public Integer getIdade() {
	  return idade;
   }

   public void setIdade(Integer idade) {
	  this.idade = idade;
   }
	
   public Boolean getAutorizado() {
	  return autorizado;
   }

   public void setAutorizado(Boolean autorizado) {
	  this.autorizado = autorizado;
   }
   
}