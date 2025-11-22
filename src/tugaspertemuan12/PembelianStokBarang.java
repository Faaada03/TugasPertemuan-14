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
@Table(name = "pembelian_stok_barang")
@NamedQueries({
    @NamedQuery(name = "PembelianStokBarang.findAll", query = "SELECT p FROM PembelianStokBarang p"),
    @NamedQuery(name = "PembelianStokBarang.findByIdBarang", query = "SELECT p FROM PembelianStokBarang p WHERE p.idBarang = :idBarang"),
    @NamedQuery(name = "PembelianStokBarang.findByJumlahBeli", query = "SELECT p FROM PembelianStokBarang p WHERE p.jumlahBeli = :jumlahBeli"),
    @NamedQuery(name = "PembelianStokBarang.findByHargaBeli", query = "SELECT p FROM PembelianStokBarang p WHERE p.hargaBeli = :hargaBeli")})
public class PembelianStokBarang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_barang")
    private String idBarang;
    @Basic(optional = false)
    @Column(name = "jumlah_beli")
    private int jumlahBeli;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "harga_beli")
    private BigDecimal hargaBeli;
    @OneToOne(optional = false)
    @JoinColumn(name = "id_barang", referencedColumnName = "id_barang", insertable = false, updatable = false)
    private Barang barang;

    public PembelianStokBarang() {
    }

    public PembelianStokBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public PembelianStokBarang(String idBarang, int jumlahBeli, BigDecimal hargaBeli) {
        this.idBarang = idBarang;
        this.jumlahBeli = jumlahBeli;
        this.hargaBeli = hargaBeli;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public int getJumlahBeli() {
        return jumlahBeli;
    }

    public void setJumlahBeli(int jumlahBeli) {
        this.jumlahBeli = jumlahBeli;
    }

    public BigDecimal getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(BigDecimal hargaBeli) {
        this.hargaBeli = hargaBeli;
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
        if (!(object instanceof PembelianStokBarang)) {
            return false;
        }
        PembelianStokBarang other = (PembelianStokBarang) object;
        if ((this.idBarang == null && other.idBarang != null) || (this.idBarang != null && !this.idBarang.equals(other.idBarang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tugaspertemuan12.PembelianStokBarang[ idBarang=" + idBarang + " ]";
    }

}
