package com.mycompany.hue_01_graf_webservice_maven.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Benutzer;
import model.Reisetyp;
import model.Reiseveranstaltung;

/**
 *
 * @author graff
 */
@Stateless
@Path("/benutzer")
public class BenutzerFacadeREST {

    @PersistenceContext(unitName = "HUE_01_Graf_WebservicePU")
    private EntityManager em;

    @GET
    @Path("/typFromBenutzer")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response findReisetypFromAllBenutzer() {
        Map<Benutzer,List<Reisetyp>> m = new HashMap<>();
        try {

            

            return Response.status(Response.Status.OK)
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e)
                    .location(URI.create("/typFromBenutzer"))
                    .build();
        }

    }


    @GET
    @Path("/typFromBenutzer/{mail}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response findReisetypFromBenutzer(@PathParam("mail") String mail) {
        try {

            Benutzer b = em.find(Benutzer.class, mail);
            List<Reisetyp> rt = new ArrayList(b.getReisetypCollection());

            return Response.status(Response.Status.OK)
                    .entity(new GenericEntity<List<Reisetyp>>(rt) {
                    })
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e)
                    .location(URI.create("/typFromBenutzer"))
                    .build();
        }

    }

    @GET
    @Path("/reisenFromBenutzer/{mail}")
    @Produces( MediaType.APPLICATION_JSON)
    public Response findReiseveranstaltungFromBenutzer(@PathParam("mail") String mail) {
        
            List<Reiseveranstaltung> lReiseveranstaltung = new ArrayList<>();

        try {
            Benutzer b = em.find(Benutzer.class, mail);
            lReiseveranstaltung = reiseveranstaltungFromBenutzer(b);
            return Response.status(Response.Status.OK)
                    .entity(new GenericEntity<List<Reiseveranstaltung>>(lReiseveranstaltung) {
                    })
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e)
                    .location(URI.create("/find"))
                    .build();
        }

    }

   
    private List<Reiseveranstaltung> reiseveranstaltungFromBenutzer(Benutzer b) {
        
            List<Reiseveranstaltung> lReiseveranstaltung = new ArrayList<>();

        List<Reisetyp> rt = new ArrayList(b.getReisetypCollection());

            rt.stream()
                    .map((x) -> new ArrayList(x.getReiseveranstaltungCollection()))
                    .forEach((x) -> lReiseveranstaltung.addAll(x));
            return lReiseveranstaltung;

    }
}
