package com.tracusa.logistica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tracusa.logistica.model.OrdenRecoleccion;
import com.tracusa.logistica.interfase.bo.IRecoleccionBO;

@Controller
@RequestMapping("/rest/recoleccion")
public class RecoleccionRestController
{
    @Autowired
    private IRecoleccionBO iRecoleccionBO;

    @RequestMapping(method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<OrdenRecoleccion> listAllMembers()
    {
        return null;//memberDao.findAllOrderedByName();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody OrdenRecoleccion lookupMemberById(@PathVariable("id") Long id)
    {
        return null;//memberDao.findById(id);
    }
}
