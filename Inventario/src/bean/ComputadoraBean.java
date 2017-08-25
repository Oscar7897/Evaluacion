/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author oscar
 */
public class ComputadoraBean {

    public String noSerie;
    public String marca;
    public String modelo;
    public Integer disco;
    public Integer ram;
    public String procesador;
    public String estado;

    public String getNoSerie() {
        return noSerie;
    }

    public void setNoSerie(String noSerie) {
        this.noSerie = noSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getDisco() {
        return disco;
    }

    public void setDisco(Integer disco) {
        this.disco = disco;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ComputadoraBean{" + "noSerie=" + noSerie + ", marca=" + marca + ", modelo=" + modelo + ", disco=" + disco + ", ram=" + ram + ", procesador=" + procesador + ", estado=" + estado + '}';
    }

    
}
