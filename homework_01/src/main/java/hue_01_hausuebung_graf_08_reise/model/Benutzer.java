/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hue_01_hausuebung_graf_08_reise.model;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author graff
 */
@Entity
@Table(name = "Benutzer")
@SequenceGenerator(name = "ben_seq", sequenceName = "ben_seq_id")
public class Benutzer implements Serializable {
--test
    private static final long serialVersionUID = 1L;


    public Benutzer() {
    }

    @Id
    @GeneratedValue(generator = "ben_seq")
    @Column(name = "email")
    private String email;
    @Column(name = "name", nullable = true)
    private String name;
    @Column(name = "surname", nullable = true)
    private String surname;

    @Column(name = "passwort")
    @Size(min = 6)
    private String passwort;

    @Column(name = "newsletter")
    private boolean newsletter;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "benutzer_reisetyp",
            joinColumns = {
                @JoinColumn(name = "benutzer_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "reisetyp_id")})
    private List<Reisetyp> reisetyp = new ArrayList<>();

    public Benutzer(String email, String passwort, boolean newsletter) {
        this.email = email;
        this.passwort = get_SHA_SecurePassword(passwort, passwort.getBytes());
        this.newsletter = newsletter;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {

        this.passwort = get_SHA_SecurePassword(passwort, passwort.getBytes());
    }

    public boolean isNewsletter() {
        return newsletter;
    }

    public void setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
    }

    public List<Reisetyp> getReisetyp() {
        return reisetyp;
    }

    public void setReisetyp(List<Reisetyp> reisetyp) {
        this.reisetyp = reisetyp;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.email);
        hash = 37 * hash + Objects.hashCode(this.passwort);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Benutzer other = (Benutzer) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.passwort, other.passwort)) {
            return false;
        }
        return true;
    }

    private static String get_SHA_SecurePassword(String passwordToHash, byte[] salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

//    private static byte[] getSalt() {
//        try {
//            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
//            byte[] salt = new byte[16];
//            sr.nextBytes(salt);
//            return salt;
//        }catch(NoSuchAlgorithmException e){
//             return null;
//        }
//       
//
//    }

    @Override
    public String toString() {
        return "Benutzer{" + "email=" + email + ", passwort=" + passwort + ", newsletter=" + newsletter + '}';
    }
    
}
