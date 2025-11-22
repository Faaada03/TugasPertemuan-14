/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugaspertemuan12;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author MyBook Hype AMD
 */
@Entity
@Table(name = "harga_jual_barang")
@NamedQueries({
    @NamedQuery(name = "HargaJualBarang.findAll", query = "SELECT h FROM HargaJualBarang h"),
    @NamedQuery(name = "HargaJualBarang.findByIdBarang", query = "SELECT h FROM HargaJualBarang h WHERE h.idBarang = :idBarang"),
    @NamedQuery(name = "HargaJualBarang.findByHargaJual", query = "SELECT h FROM HargaJualBarang h WHERE h.hargaJual = :hargaJual"),
    @NamedQuery(name = "HargaJualBarang.findByRakBarang", query = "SELECT h FROM HargaJualBarang h WHERE h.rakBarang = :rakBarang")})
public class HargaJualBarang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_barang")
    private String idBarang;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "harga_jual")
    private BigDecimal hargaJual;
    @Basic(optional = false)
    @Column(name = "rak_barang")
    private String rakBarang;
    @JoinColumn(name = "id_barang", referencedColumnName = "id_barang", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Barang barang;

    public HargaJualBarang() {
    }

    public HargaJualBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public HargaJualBarang(String idBarang, BigDecimal hargaJual, String rakBarang) {
        this.idBarang = idBarang;
        this.hargaJual = hargaJual;
        this.rakBarang = rakBarang;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public BigDecimal getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(BigDecimal hargaJual) {
        this.hargaJual = hargaJual;
    }

    public String getRakBarang() {
        return rakBarang;
    }

    public void setRakBarang(String rakBarang) {
        this.rakBarang = rakBarang;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public String getNamaBarang() {
        return barang != null ? barang.getNamaBarang() : "";
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBarang != null ? idBarang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HargaJualBarang)) {
            return false;
        }
        HargaJualBarang other = (HargaJualBarang) object;
        if ((this.idBarang == null && other.idBarang != null) || (this.idBarang != null && !this.idBarang.equals(other.idBarang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tugaspertemuan12.HargaJualBarang[ idBarang=" + idBarang + " ]";
    }

}
